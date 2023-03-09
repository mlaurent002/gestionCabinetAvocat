package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Tribunal;
import com.inti.repositories.TribunalRepository;
import com.inti.service.interfaces.ITribunalService;
@Service
public class TribunalService implements ITribunalService{
	@Autowired
	TribunalRepository tribunalRepository;

	@Override
	public List<Tribunal> findAll() {
		// TODO Auto-generated method stub
		return tribunalRepository.findAll();
	}

	@Override
	public Tribunal save(Tribunal tribunal) {
		// TODO Auto-generated method stub
		return tribunalRepository.save(tribunal);
	}

	@Override
	public Tribunal findById(Long id) {
		// TODO Auto-generated method stub
		return tribunalRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		tribunalRepository.deleteById(id);
	}
	

}
