package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Phase;
import com.inti.entities.Tribunal;
import com.inti.repositories.PhaseRepository;
import com.inti.service.interfaces.IPhaseService;


@Service
public class PhaseService implements IPhaseService {
	@Autowired
	PhaseRepository phaseRepository;

	@Override
	public List<Phase> findAll() {
		// TODO Auto-generated method stub
		return phaseRepository.findAll();
	}

	@Override
	public Phase save(Phase phase) {
		// TODO Auto-generated method stub
		return phaseRepository.save(phase);
	}

	@Override
	public Phase findById(Long id) {
		// TODO Auto-generated method stub
		return phaseRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		phaseRepository.deleteById(id);
	}

}
