package lu.eyet.dev.jdbcsandbox.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import lu.eyet.dev.jdbcsandbox.model.Pet;

public interface PetRepository extends PagingAndSortingRepository<Pet, Long> {

    @Query("select * from pets where name = :name")
    List<Pet> findByName(@Param("name") String name);

}