package org.springframework.samples.petclinic.visit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
	@Autowired
	private VisitRepository visitRepository;
	
	public void save(Visit visit) throws DataAccessException {
		this.visitRepository.save(visit);
	}
	
	public List<Visit> findByPetId(Integer petId) {
		return this.visitRepository.findByPetId(petId);
	}
	
	public List<Visit> findAll() {
		return this.visitRepository.findAll();
	}
	
	public Visit findOne(Integer id) {
		return this.visitRepository.findById(id);
	}
}
