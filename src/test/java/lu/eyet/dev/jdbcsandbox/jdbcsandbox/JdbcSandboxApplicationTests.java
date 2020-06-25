package lu.eyet.dev.jdbcsandbox.jdbcsandbox;

import java.time.LocalDate;
import java.util.List;

import com.querydsl.sql.SQLQuery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lu.eyet.dev.jdbcsandbox.Address;
import lu.eyet.dev.jdbcsandbox.Customer;
import lu.eyet.dev.jdbcsandbox.CustomerRepository;
import lu.eyet.dev.jdbcsandbox.DatabaseConnection;
import lu.eyet.dev.jdbcsandbox.Pet;
import lu.eyet.dev.jdbcsandbox.PetRepository;
import lu.eyet.qclasses.QCustomer;

@SpringBootTest
class JdbcSandboxApplicationTests {

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DatabaseConnection dbCon;

	@Test
	@Transactional
	void createAndFindPet() {
		Pet pet1 = Pet.create("Pfötschen", LocalDate.of(2018, 7, 25));
		Pet pet2 = Pet.create("Ayiumi", LocalDate.of(2018, 7, 25));

		System.out.println(petRepository.save(pet1));
		System.out.println(petRepository.save(pet2));

		System.out.println(petRepository.count());
		System.out.println(petRepository.findByName("Ayiumi"));

	}

	@Test
	@Transactional
	void queryWithQueryDSL() {
		QCustomer customer = QCustomer.customer;
		SQLQuery<?> query = dbCon.pgQuery();
		List<String> names = query.select(customer.name).from(customer).where(customer.name.containsIgnoreCase("kai"))
				.fetch();
		System.out.println("**************************************:" + names.size());
		System.out.println("************************************:" + names);
	}

	@Test
	@Transactional
	void createCustomerWithAddress() {
		Address a1 = new Address("2a an der Gruecht");
		Customer c1 = Customer.create("Kai Kremer", a1);

		System.out.println(customerRepository.save(c1));
		System.out.println(customerRepository.count());

	}

}
