package lu.eyet.dev.jdbcsandbox.controller;

import java.util.List;

import com.querydsl.sql.SQLQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lu.eyet.dev.jdbcsandbox.DatabaseConnection;
import lu.eyet.dev.jdbcsandbox.model.Pet;
import lu.eyet.dev.jdbcsandbox.repository.PetRepository;
import lu.eyet.qclasses.QPets;

@RestController
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    DatabaseConnection databaseConnection;

    @GetMapping("/pets")
    public Iterable<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @GetMapping("/petsPagable")
    public Page<Pet> getAllPetsPagable(Pageable pagable) {
        return petRepository.findAll(pagable);
    }

    @PostMapping("/petsByName/{petName}")
    public List<Pet> getPetsByName(@PathVariable String petName) {
        return petRepository.findByName(petName);
    }

    @PostMapping(path = "/petsByName", consumes = "text/plain", produces = "application/json")
    public List<Pet> getPetsByNameJson(@RequestBody String petName) {
        return petRepository.findByName(petName);
    }

    @PostMapping(path = "/newPet", consumes = "application/json", produces = "application/json")
    public Pet addPat(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }

    @PostMapping(path = "/editPet", consumes = "application/json", produces = "application/json")
    public Pet editPat(@RequestBody Pet pet) {
        if (petRepository.existsById(pet.getPetId())) {
            petRepository.save(pet);
        }
        return pet;
    }

    @GetMapping("/petNames")
    public List<String> getAllPetNames() {
        QPets pets = QPets.pets;
        SQLQuery<?> q = databaseConnection.pgQuery();
        List<String> list = q.select(pets.name).from(pets).fetch();
        return list;

    }

}