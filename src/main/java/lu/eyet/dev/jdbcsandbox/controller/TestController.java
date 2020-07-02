package lu.eyet.dev.jdbcsandbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lu.eyet.dev.jdbcsandbox.model.Pet;
import lu.eyet.dev.jdbcsandbox.repository.PetRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/animals")
    @PreAuthorize("hasRole('ADMIN')")
    public Iterable<Pet> getAllPets() {
        return petRepository.findAll();
    }

}