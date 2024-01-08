package com.camunda.sample.controllers;
import com.camunda.sample.models.Person;
import com.camunda.sample.models.ProcessCamunda;
import com.camunda.sample.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

	private final ItemRepository processRepository;

	public SampleController(ItemRepository processRepository){
		this.processRepository = processRepository;
	}

	@GetMapping("/message/{message}")
	public Person getMessage(@PathVariable String message){
		System.out.println("I'm here !!!!!!!!!!!");
		System.out.println(message);
		Person person = new Person();
		person.setId("2");
		person.setName(message);
		return person;
	}

	@PostMapping("/process")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void processCamunda(@RequestBody ProcessCamunda processCamunda) {
		List<ProcessCamunda> listaUsuario = processRepository.findAll();
		System.out.println(listaUsuario);
		List<ProcessCamunda> process = processRepository.findByUsername("bc");
		System.out.println(processCamunda.getUsername());
		System.out.println(process.get(0).getId());
		processRepository.save(processCamunda);

	}
}
