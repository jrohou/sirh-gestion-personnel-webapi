package dev.sgpwebapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpwebapi.entite.Collaborateurs;
import dev.sgpwebapi.entite.Departements;

public interface CollaborateursRepository extends JpaRepository <Collaborateurs, Integer> {

	public List <Collaborateurs> findByDepartements( Departements id);
	
	public Optional<Collaborateurs> findByMatricule(String matricule);
	
}
