package com.example.communaute.service;

import java.util.List;

import com.example.communaute.entity.Personne;

public interface PersonneService {
   List<Personne> findAll();

   Personne save(Personne personne);

   Personne delete(Long id);

   Personne update(Long id, Personne personne);

   Personne findById(Long id);
    
}  
