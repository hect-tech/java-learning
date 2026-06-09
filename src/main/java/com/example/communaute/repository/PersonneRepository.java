package com.example.communaute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.communaute.entity.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {
} 