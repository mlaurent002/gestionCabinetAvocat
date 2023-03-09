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

import com.inti.entities.Tribunal;
import com.inti.service.interfaces.ITribunalService;

@RestController
@CrossOrigin
public class TribunalController {
	@Autowired
	ITribunalService tribunalService;

	@GetMapping("/tribunals")
	public List<Tribunal> findAll() {
		return tribunalService.findAll();
	}

	@GetMapping("/tribunals/{idTribunal}")
	public Tribunal findById(@PathVariable("idTribunal") Long id) {
		return tribunalService.findById(id);
	}

	@PostMapping("/tribunals")
	public Tribunal save(@RequestBody Tribunal tribunal) {
		return tribunalService.save(tribunal);
	}

	@DeleteMapping("/tribunals/{idTribunal}")
	public void delete(@PathVariable("idTribunal") Long id) {
		tribunalService.delete(id);
	}

	@PutMapping("/tribunals/{idTribunal}")
	public Tribunal updateWithPut(@PathVariable("idTribunal") Long id, @RequestBody Tribunal tribunal) {
		Tribunal currentTribunal = tribunalService.findById(id);

		currentTribunal.setAdresse(tribunal.getAdresse());
		currentTribunal.setTel(tribunal.getTel());
		currentTribunal.setRegion(tribunal.getRegion());
		currentTribunal.setFax(tribunal.getFax());

		return tribunalService.save(currentTribunal);
	}

	@PatchMapping("/tribunals/{idTribunal}")
	public Tribunal updateWithPatch(@PathVariable("idTribunal") Long id, @RequestBody Tribunal tribunal) {
		Tribunal currentTribunal = tribunalService.findById(id);

		
		currentTribunal.setTel(tribunal.getTel());
		currentTribunal.setFax(tribunal.getFax());

		return tribunalService.save(currentTribunal);
	}
}


