package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Phase;
import com.inti.service.interfaces.IPhaseService;

@RestController
@CrossOrigin
public class PhaseController {
	@Autowired
	IPhaseService phaseService;

	@GetMapping("/phases")
	public List<Phase> findAll() {
		return phaseService.findAll();
	}

	@GetMapping("/phases/{idPhase}")
	public Phase findById(@PathVariable("idPhase") Long id) {
		return phaseService.findById(id);
	}

	@PostMapping("/phases")
	public Phase save(@RequestBody Phase phase) {
		return phaseService.save(phase);
	}

	@DeleteMapping("/phases/{idPhase}")
	public void delete(@PathVariable("idPhase") Long id) {
		phaseService.delete(id);
	}

	@PutMapping("/phases/{idPhase}")
	public Phase updateWithPut(@PathVariable("idPhase") Long id, @RequestBody Phase phase) {
		Phase currentPhase = phaseService.findById(id);

		currentPhase.setNom(phase.getNom());
		currentPhase.setDateDebut(phase.getDateDebut());
		currentPhase.setDateFin(phase.getDateFin());
		
		return phaseService.save(currentPhase);
	}

	@PatchMapping("/phases/{idPhase}")
	public Phase updateWithPatch(@PathVariable("idPhase") Long id, @RequestBody Phase phase) {
		Phase currentPhase = phaseService.findById(id);

		
		currentPhase.setDateDebut(phase.getDateDebut());
		currentPhase.setDateFin(phase.getDateFin());

		return phaseService.save(currentPhase);
	}
}
