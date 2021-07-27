package com.miguel.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miguel.relationships.models.Person;
import com.miguel.relationships.repositories.PersonRepo;

@Service
public class PersonService {

//	agrega PersonRepo como dependencia
	
	private final PersonRepo personRepo;
	
//	Constructor
	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
//	crea una nueva persona
	
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}
	
//	encuentra todas las personas
	
	public List<Person> findAll(){
		return personRepo.findAll();
	}

	
//	encuentra persona por id
	
	public Person findPerson(Long id) {
		Optional<Person> findPerson = personRepo.findById(id);
		if(findPerson.isPresent()) {
			System.out.println(findPerson.get());
			return findPerson.get();
		} else {
			return null;
		}
	}
	
	
}
