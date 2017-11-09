package dev.sgpwebapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpwebapi.entite.Collaborateurs;
import dev.sgpwebapi.repository.CollaborateursRepository;
import dev.sgpwebapi.repository.DepartementsRepository;

@RestController
@RequestMapping("/collaborateurs")
public class CollaborateursController {

	@Autowired
	CollaborateursRepository collaborateurs;

	@Autowired
	DepartementsRepository departements;

	@GetMapping
	public List<Collaborateurs> listerCollaborateurs(@RequestParam Optional<Integer> departement) {
		if (departement.isPresent())
			return collaborateurs.findByDepartements(departements.findOne(departement.get()));
		return collaborateurs.findAll();

	}

	@GetMapping(value = "/{matricule}")
	public Collaborateurs unCollaborateur(@PathVariable String matricule) {
		Optional<Collaborateurs> collab = collaborateurs.findByMatricule(matricule);

		if (collab.isPresent())
			return collab.get();
		return null;

	}

	@Transactional
	@PutMapping(value="/{matricule}")
	public String PourunCollab(@RequestBody Collaborateurs collab, @PathVariable String matricule) {
		Optional<Collaborateurs> update = collaborateurs.findByMatricule(matricule);
		
		if(update.isPresent()) {
			collab.setId(update.get().getId());
			collaborateurs.save(collab);
			
			return collab.getMatricule();
		}
		
		return null; 
	}

}
