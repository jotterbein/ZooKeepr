package com.catalyst.zookeepr.services;

import java.util.List;

import com.catalyst.zookeepr.entities.Enclosure;

public interface EnclosureService {

	/**
	 * Gets all the enclosures in the database
	 * @return: List containing all the enclosures
	 */
	List<Enclosure> getEnclosures();
	
	/**
	 * Adds an enclosure to the database
	 * @param enclosure: To be added to tbe database
	 */
	Enclosure createEnclosure(Enclosure enclosure);
	
	/**
	 * Updates an enclosure
	 * @param enclosure to be updated
	 */
	Enclosure updateEnclosure(Enclosure enclosure);
	
	/**
	 * Deletes an enclosure from the database
	 * @param id of the enclosure to be deleted
	 */
	void deleteEnclosure(long id);
}
