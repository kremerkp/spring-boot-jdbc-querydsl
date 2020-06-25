package lu.eyet.dev.jdbcsandbox;

import java.time.LocalDate;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JdbcSandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcSandboxApplication.class, args);
	}

	/*
	 * @Bean ApplicationRunner applicationRunner(PetRepository petRepository) {
	 * return args -> { Pet pet1 = Pet.create("Pfötschen", LocalDate.of(2018, 7,
	 * 25)); Pet pet2 = Pet.create("Ayiumi", LocalDate.of(2018, 7, 25));
	 * 
	 * System.out.println(petRepository.save(pet1));
	 * System.out.println(petRepository.save(pet2));
	 * 
	 * System.out.println(petRepository.findByName("Ayiumi"));
	 * 
	 * Address a1 = new Address("2a an der Gruecht"); Customer c1 =
	 * Customer.create("Kai Kremer", a1); Customer c2 =
	 * Customer.create("Simone Schram", a1);
	 * 
	 * System.out.println(petRepository.save(pet1));
	 * 
	 * };
	 * 
	 * }
	 */

}
