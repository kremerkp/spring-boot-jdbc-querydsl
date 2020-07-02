package lu.eyet.dev.jdbcsandbox.jdbcsandbox;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.castor.core.util.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import lu.eyet.dev.jdbcsandbox.model.Author;
import lu.eyet.dev.jdbcsandbox.model.Book;
import lu.eyet.dev.jdbcsandbox.model.Role;
import lu.eyet.dev.jdbcsandbox.model.User;
import lu.eyet.dev.jdbcsandbox.repository.AuthorRepository;
import lu.eyet.dev.jdbcsandbox.repository.BookRepository;
import lu.eyet.dev.jdbcsandbox.repository.MovieRepository;
import lu.eyet.dev.jdbcsandbox.repository.RoleRepository;
import lu.eyet.dev.jdbcsandbox.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class JdbcOneToOneAndOneToManyTests {

    private static final Logger logger = LoggerFactory.getLogger(JdbcOneToOneAndOneToManyTests.class);

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Value("${secure.app.jwtSecret}")
    private String jwtSecret;

    @Test
    @Transactional
    public void contextLoads() {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder(12, new SecureRandom());
        String encodedPassword = bc.encode("secure");
        System.out.println("************************************");
        System.out.println(bc.matches("secure", encodedPassword));
        System.out.println(encodedPassword);
        System.out.println("************************************");

        String testPass = "$2a$10$/VsO2xwfQmUd8R2pniLwGu8ngo9bDAwwfNKs1kBnimqPe1P9KpotK";
        System.out.println(bc.matches("myPassword", testPass));

        // Set<Rental> rentals = new HashSet<Rental>();
        // rentals.add(new Rental(Duration.ofDays(1), 2));
        // rentals.add(new Rental(Duration.ofDays(2), 3));
        // rentals.add(new Rental(Duration.ofDays(5), 5));
        // Movie movie = new Movie(null, "Pulp Fiction", "desc...", rentals);
        // movieRepository.save(movie);
        // System.out.println(movieRepository.findAll());

    }

    @Test
    public void testSecurity() {
        logger.info("enter testSecurity");
        User user = userRepository.findById(6L).get();
        System.out.println("******************************");

        System.out.println(jwtSecret);

        List<Role> roleList = new ArrayList<>();
        user.getUserRoles().forEach(role -> roleList.add(roleRepository.findById(role.getRole()).get()));
        roleList.forEach(action -> {
            System.out.println(action.getName());
        });

        List<GrantedAuthority> authorities = user.getUserRoles().stream()
                .map(role -> new SimpleGrantedAuthority(roleRepository.findById(role.getRole()).get().getName()))
                .collect(Collectors.toList());

        Assert.notNull(authorities, "darf nicht null sein");

    }

    @Test
    public void createUserWithRole() {
        logger.info("enter createUserWithRole");
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder(12, new SecureRandom());
        String encodedPassword = bc.encode("secure");
        logger.info("Setting Password to: " + encodedPassword);
        User us = new User();
        us.setEmail("dev@eye-t.lu");
        us.setName("Dev-Test");
        us.setIslogin(true);
        us.setPassword(encodedPassword);
        /*
         * Role user_role = roleRepository.findById(ERole.ROLE_USER.getValue()).get();
         * Role moderator_role =
         * roleRepository.findById(ERole.ROLE_MODERATOR.getValue()).get(); Role
         * admin_role = roleRepository.findById(ERole.ROLE_ADMIN.getValue()).get();
         * us.addRoleRef(user_role); us.addRoleRef(moderator_role);
         * us.addRoleRef(admin_role);
         */

        try {
            userRepository.save(us);
            logger.info("User was saved");
        } catch (DbActionExecutionException | DuplicateKeyException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    @Transactional
    public void testManyToMany() {

        Author at = new Author();
        at.setName("Martin Walser");
        authorRepository.save(at);

        Author at2 = new Author();
        at2.setName("Martin Walser 2");
        authorRepository.save(at2);

        Book book = new Book();
        book.setTitle("Ein sterbender Mann");
        book.setIsbn("12343");
        book.addAuthor2(at);
        book.addAuthor2(at2);

        bookRepository.save(book);

    }

}