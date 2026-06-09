package com.example.communaute.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.communaute.entity.Personne;
import com.example.communaute.repository.PersonneRepository;
import com.example.communaute.service.PersonneService;

@Service
public class PersonneServiceImpl implements PersonneService {
    private final PersonneRepository personneRepository;

    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    @Override
    public Personne save(Personne personne) {
        return personneRepository.save(personne);
    }

    @Override
    public Personne delete(Long id) {
        Personne personne = findById(id);
        personneRepository.delete(personne);
        return personne;
    }

    @Override
    public Personne update(Long id, Personne personne) {
        Personne existingPersonne = findById(id);
        existingPersonne.setNom(personne.getNom());
        existingPersonne.setPrenom(personne.getPrenom());
        existingPersonne.setEmail(personne.getEmail());
        existingPersonne.setTelephone(personne.getTelephone());
        existingPersonne.setAdresse(personne.getAdresse());
        return personneRepository.save(existingPersonne);
    }

    @Override
    public Personne findById(Long id) {
        return personneRepository.findById(id).orElse(null);
    }
}
