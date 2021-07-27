package com.miguel.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miguel.relationships.models.License;
import com.miguel.relationships.models.Person;
import com.miguel.relationships.services.LicenseService;
import com.miguel.relationships.services.PersonService;

@Controller
public class MainController {

//	Agrega PersonService y LicenseService como depoendencia

	private final PersonService personService;
	private final LicenseService licenseService;

//	Constructor
	public MainController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}

//	redirecciona 

	@RequestMapping("/")
	public String index() {
		return "redirect:/persons/new";
	}

//	render formulario nueva person	

	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/newPerson.jsp";
	}

	// crear una nueva persona (post)

	@RequestMapping(value = "/persons/new", method = RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "/newPerson.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/persons/new";
		}
	}

//	render formulario nueva licencia

	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> listPerson = personService.findAll();
		model.addAttribute("persons", listPerson);
		return "newLicense.jsp";
	}

	// crear una nueva licencia (post)

	@PostMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "newLicense.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/licenses/new";
		}
	}

//	muestra informacion del perfil

	@RequestMapping("/persons/{id}")
	public String showProfile(@PathVariable("id") Long id, Model model) {
		Person findPerson = personService.findPerson(id);
		if (findPerson == null) {
			return "redirect:/";
		} else {
			model.addAttribute("person", findPerson);
			return "profilePage.jsp";
		}
	}
}
