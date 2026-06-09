package com.example.communaute.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.communaute.entity.Personne;
import com.example.communaute.repository.PersonneRepository;

@RestController
@RequestMapping("/api/personnes")
public class PersonneController {

    private final PersonneRepository personneRepository;

    public PersonneController(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @GetMapping
    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    @GetMapping("/{id}")
    public Personne findById(@PathVariable Long id) {
        return personneRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personne not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Personne create(@RequestBody Personne personne) {
        return personneRepository.save(personne);
    }

    @PutMapping("/{id}")
    public Personne update(@PathVariable Long id, @RequestBody Personne personne) {
        personneRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personne not found"));
        personne.setId(id);
        return personneRepository.save(personne);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        personneRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personne not found"));
        personneRepository.deleteById(id);
    }
}
