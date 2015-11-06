package com.catalyst.zookeepr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.zookeepr.entities.Enclosure;
import com.catalyst.zookeepr.repository.EnclosureRepository;
import com.catalyst.zookeepr.services.EnclosureService;

@Service
public class EnclosureServiceImpl implements EnclosureService{

	@Autowired
	private EnclosureRepository repository;
	
	public void setEnclosureRepository(EnclosureRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Enclosure> getEnclosures() {
		return repository.findAll();
	}

	@Override
	public void createEnclosure(Enclosure enclosure) {
		repository.save(enclosure);
	}

	@Override
	public void updateEnclosure(Enclosure enclosure) {
		repository.save(enclosure);
		
	}

	@Override
	public void deleteEnclosure(long id) {
		repository.delete(id);
		
	}


}
