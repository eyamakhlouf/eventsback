package com.eya.evenements.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eya.evenements.model.Evenement;
import com.eya.evenements.model.Image;
import com.eya.evenements.service.EvenementService;
import com.eya.evenements.service.ImageService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EvenementRESTController {
	@Autowired
	EvenementService evenementService;
	@Autowired
	 ImageService imageService ;
	
	@RequestMapping(path="/all" , method = RequestMethod.GET)
	public List<Evenement> getAllEvenements() {
		return evenementService.getAllEvenements();
		}
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Evenement getEvenmentById(@PathVariable("id") Long id) {
	return evenementService.getEvenement(id);
	 }
	@RequestMapping(path="/addevent",method = RequestMethod.POST)
	public Evenement createEvenement(@RequestBody Evenement evenement) {
	return evenementService.saveEvenement(evenement);
	}
	@RequestMapping(path="/updateevent",method = RequestMethod.PUT)
	public Evenement updateEvenement(@RequestBody Evenement evenement) {
	return evenementService.updateEvenement(evenement);
	}
	@RequestMapping(value="/delevent/{id}",method = RequestMethod.DELETE)
	public void deleteEvenement(@PathVariable("id") Long id)
	{
		 List<Image> images = imageService.getImagesParEvnt(id);
		    for (Image img : images) {
		        imageService.deleteImage(img.getIdImage());
		    }
		    // Supprimer l'événement
		    evenementService.deleteEvenementById(id);
	}
	@RequestMapping(value="/evenementtype/{idType}",method = RequestMethod.GET)
	public List<Evenement> getEvenementsByTypeID(@PathVariable("idType") Long idType) {
	return evenementService.findByTypeIdType(idType);
	}
	@RequestMapping(value="/eventByName/{nom}",method = RequestMethod.GET)
	public List<Evenement> findByNomEvenementContains(@PathVariable("nom") String nom) {
	return evenementService.findByNomEvenementContains(nom);
	}
}
