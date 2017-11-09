package dev.sgpwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpwebapi.entite.Departements;


public interface DepartementsRepository extends JpaRepository <Departements, Integer>  {

}
