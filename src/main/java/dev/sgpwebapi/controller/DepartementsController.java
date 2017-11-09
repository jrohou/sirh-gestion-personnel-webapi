package dev.sgpwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.sgpwebapi.entite.Departements;
import dev.sgpwebapi.repository.DepartementsRepository;

@Controller
@RequestMapping("/departements")
public class DepartementsController {
	
	@Autowired DepartementsRepository departements;
	
	@GetMapping
	public List<Departements> listerDepartements() {
		return departements.findAll();
	}
	

}
