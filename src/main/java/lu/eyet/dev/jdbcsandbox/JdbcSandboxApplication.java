package lu.eyet.dev.jdbcsandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcSandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcSandboxApplication.class, args);
	}

	// @Bean
	// @Transactional
	// ApplicationRunner applicationRunner(PetRepository petRepository) {
	// return args -> {

	// Pet pet1 = Pet.create("Pfötschen", LocalDate.of(2018, 7, 25));
	// Pet pet2 = Pet.create("Ayiumi", LocalDate.of(2018, 7, 25));
	// System.out.println(petRepository.save(pet1));
	// System.out.println(petRepository.save(pet2));
	// System.out.println(petRepository.findByName("Ayiumi"));
	// System.out.println(petRepository.save(pet1));

	// };

	// }

}
