package com.eya.evenements.restcontrollers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eya.evenements.model.Type;
import com.eya.evenements.repos.TypeRepository;



@RestController
@RequestMapping("/api/type")
@CrossOrigin("*")

public class TypeRESTController {
	@Autowired
	TypeRepository typeRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Type> getAllTypes()
	{
	return typeRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Type getTypesById(@PathVariable("id") Long id) {
	return typeRepository.findById(id).get();
	}
	@RequestMapping(method=RequestMethod.POST)
	public void createType(@RequestBody Type type) {
		typeRepository.save(type);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteType(@PathVariable("id") Long id) {
		typeRepository.deleteById(id);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.POST)
	public void updateType(@RequestBody Type type) {
		typeRepository.save(type);
		
	}
	}
