package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Phase;



public interface IPhaseService {
	
	public List<Phase> findAll();
	
	Phase save(Phase phase);

	Phase findById(Long id);

	void delete(Long id);

}
