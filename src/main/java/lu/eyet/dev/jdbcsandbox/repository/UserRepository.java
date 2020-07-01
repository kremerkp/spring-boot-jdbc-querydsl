package lu.eyet.dev.jdbcsandbox.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import lu.eyet.dev.jdbcsandbox.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("select * from public.user where email = :email")
    User findByMail(@Param("email") String email);

}