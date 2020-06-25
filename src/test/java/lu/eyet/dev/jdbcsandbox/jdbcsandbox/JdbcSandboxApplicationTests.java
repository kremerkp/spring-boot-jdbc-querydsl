package lu.eyet.dev.jdbcsandbox.jdbcsandbox;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lu.eyet.dev.jdbcsandbox.Address;
import lu.eyet.dev.jdbcsandbox.Customer;
import lu.eyet.dev.jdbcsandbox.CustomerRepository;
import lu.eyet.dev.jdbcsandbox.Pet;
import lu.eyet.dev.jdbcsandbox.PetRepository;

@SpringBootTest
class JdbcSandboxApplicationTests {

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private CustomerRepository customerRepository;

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
	void createCustomerWithAddress() {
		Address a1 = new Address("2a an der Gruecht");
		Customer c1 = Customer.create("Kai Kremer", a1);

		System.out.println(customerRepository.save(c1));
		System.out.println(customerRepository.count());

	}

}
