package com.mr486.tda.repository;

import com.mr486.tda.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, UUID> {
}
