package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Tribunal;



public interface ITribunalService {
	public List<Tribunal> findAll();

	Tribunal save(Tribunal tribunal);

	Tribunal findById(Long id);

	void delete(Long id);

}
