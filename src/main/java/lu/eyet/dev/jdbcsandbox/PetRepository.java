package lu.eyet.dev.jdbcsandbox;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PetRepository extends CrudRepository<Pet, Long> {

    @Query("select * from pets where name = :name")
    List<Pet> findByName(@Param("name") String name);

}