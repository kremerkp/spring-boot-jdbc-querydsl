package lu.eyet.dev.jdbcsandbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lu.eyet.dev.jdbcsandbox.model.Pet;
import lu.eyet.dev.jdbcsandbox.repository.PetRepository;
import lu.eyet.dev.jdbcsandbox.utilities.ObjectUtilities;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pet")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/pets")
    public Iterable<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @PreAuthorize("isAuthenticated()")
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
    public ResponseEntity<Pet> editPat(@RequestBody Pet pet) {
        Pet resPet = new Pet();
        if (petRepository.existsById(pet.getPetId())) {
            Pet accPet = petRepository.findById(pet.getPetId()).get();
            resPet = ObjectUtilities.combine2Objects2(accPet, pet, new Pet());
            if (!resPet.equals(accPet)) {
                petRepository.save(resPet);
                return new ResponseEntity<Pet>(resPet, HttpStatus.OK);
            }
        }
        return new ResponseEntity<Pet>(resPet, HttpStatus.NOT_MODIFIED);
    }

    // @GetMapping("/petNames")
    // public List<String> getAllPetNames() {
    // DatabaseConnection dbConn = new DatabaseConnection();
    // QPets pets = QPets.pets;
    // SQLQuery<?> q = dbConn.pgQuery();
    // List<String> list = q.select(pets.name).from(pets).fetch();
    // return list;

    // }

}