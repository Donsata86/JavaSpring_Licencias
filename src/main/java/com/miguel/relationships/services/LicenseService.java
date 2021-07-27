package com.miguel.relationships.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miguel.relationships.models.License;
import com.miguel.relationships.repositories.LicenseRepo;

@Service
public class LicenseService {

//	agrear LicenseRepo como dependencia 
	private final LicenseRepo licenseRepo;

	private static String newNumber = "00000";

//	constructor
	public LicenseService(LicenseRepo licenseRepo) {
		this.licenseRepo = licenseRepo;
	}

//	crea una nueva licencia
	public License createLicense(License license) {
		newNumber = String.format("%05d", Integer.parseInt(newNumber) + 1);
		license.setNumber(newNumber);
		return licenseRepo.save(license);
	}

//	busca licencia por ID
	public License findLicense(Long id) {
		Optional<License> findL = licenseRepo.findById(id);
		if (findL.isPresent()) {
			return findL.get();
		} else {
			return null;
		}
	}
	
}
