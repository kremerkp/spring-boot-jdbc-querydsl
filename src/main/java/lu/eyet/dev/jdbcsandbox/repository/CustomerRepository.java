package lu.eyet.dev.jdbcsandbox.repository;

import org.springframework.data.repository.CrudRepository;

import lu.eyet.dev.jdbcsandbox.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}