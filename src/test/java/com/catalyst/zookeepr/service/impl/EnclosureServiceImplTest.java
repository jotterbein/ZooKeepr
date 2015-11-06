package com.catalyst.zookeepr.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.catalyst.zookeepr.entities.Enclosure;
import com.catalyst.zookeepr.repository.EnclosureRepository;

public class EnclosureServiceImplTest {

	EnclosureRepository repository;
	
	EnclosureServiceImpl target;
	
	@Before
	public void setUp() {
		target = new EnclosureServiceImpl();
		repository = Mockito.mock(EnclosureRepository.class);
		target.setEnclosureRepository(repository);
	}
	
	@Test
	public void testGetEnclosures() {
		target.getEnclosures();
		Mockito.verify(repository).findAll();
	}
	
	@Test
	public void testCreateEnclosure() {
		Enclosure en = new Enclosure();
		target.createEnclosure(en);
		Mockito.verify(repository).save(en);
	}
	
	@Test
	public void testUpdateEnclosure() {
		Enclosure en = new Enclosure();
		target.updateEnclosure(en);
		Mockito.verify(repository).save(en);
	}
	
	@Test
	public void testDeleteEnclosure() {
		target.deleteEnclosure((long) 1.0);
		Mockito.verify(repository).delete((long) 1.0);
	}
}
