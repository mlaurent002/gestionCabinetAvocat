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

import com.inti.entities.Tache;
import com.inti.service.interfaces.ITacheService;

@RestController
@CrossOrigin
public class TacheController {
	@Autowired
    ITacheService tacheService;

    @GetMapping("/taches")
    public List<Tache> findAll() {
        return tacheService.findAll();
    }

    @GetMapping("/taches/{idTache}")
    public Tache findOne(@PathVariable("idTache") Long id) {
        return tacheService.findOne(id);
    }

    @PostMapping("/taches")
    public Tache saveTache(@RequestBody Tache tache) {
        return tacheService.save(tache);
    }

    @DeleteMapping("/taches/{idTache}")
    public void deleteTache(@PathVariable("idTache") Long id) {
    	tacheService.delete(id);
    }
    @PutMapping("/taches/{idTache}")
    public Tache updateTacheWithPut(@PathVariable("idTache") Long id, @RequestBody Tache tache) { //
        Tache currentTache = tacheService.findOne(id);
        currentTache.setTitreTache(tache.getTitreTache());
        currentTache.setDateCreation(tache.getDateCreation());
        currentTache.setDescriptionTache(tache.getDescriptionTache());
        currentTache.setStatutAudience(tache.isStatutAudience());
        return tacheService.save(currentTache);
    }

    @PatchMapping("/taches/{idTache}")
    public Tache updateTacheWithPatch(@PathVariable("idTache") Long id, @RequestBody Tache tache) {
        Tache currentTache = tacheService.findOne(id);
        currentTache.setTitreTache(tache.getTitreTache());
        currentTache.setDateCreation(tache.getDateCreation());
        currentTache.setDescriptionTache(tache.getDescriptionTache());
        currentTache.setStatutAudience(tache.isStatutAudience());
        return tacheService.save(currentTache);
    }
    }