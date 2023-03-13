package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Tache;

public interface ITacheService {
List<Tache> findAll();
	
	Tache findOne(Long id);
	
	Tache save(Tache tache);
	
	void delete(Long id);

}
