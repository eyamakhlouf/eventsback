package com.eya.evenements.service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eya.evenements.model.Evenement;
import com.eya.evenements.model.Type;
import com.eya.evenements.repos.EvenementRepository;
import com.eya.evenements.repos.ImageRepository;

@Service
public class EvenementServiceImpl implements EvenementService {

	@Autowired
	EvenementRepository evenementRepository;
	@Autowired
	ImageRepository imageRepository;
	@Override
	public Evenement saveEvenement(Evenement e) {
		return evenementRepository.save(e);
	}

	@Override
	public Evenement updateEvenement(Evenement e) {
		//Long oldEvntImageId = this.getEvenement(e.getIdEvenement()).getImage().getIdImage();
	///	Long newEventImageID = e.getImages().getIdImage();
		Evenement eventUpdated = evenementRepository.save(e);
		//if (oldEvntImageId != newEventImageID)
			//imageRepository.deleteById(newEventImageID);
		return eventUpdated;
	}

	@Override
	public void deleteEvenement(Evenement e) {
		evenementRepository.delete(e);
		
	}

	@Override
	public void deleteEvenementById(Long id) {
		Evenement e = getEvenement(id);
		/*try {
			Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+e.getImagePath()));
			} catch (IOException ex) {
			ex.printStackTrace();
			}*/
		evenementRepository.deleteById(id);
		
	}

	@Override
	public Evenement getEvenement(Long id) {
		return evenementRepository.findById(id).get();
		
	}

	@Override
	public List<Evenement> getAllEvenements() {
		
		return evenementRepository.findAll();
	}
	
	@Override
	public Page<Evenement> getAllEvenementsParPage(int page, int size) {
	return evenementRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Evenement> findByNomEvenement(String nom) {
		
		return evenementRepository.findByNomEvenement(nom);
	}

	@Override
	public List<Evenement> findByNomEvenementContains(String nom) {
		
		return evenementRepository.findByNomEvenementContains(nom);
	}

	@Override
	public List<Evenement> findByNomCapacite(String nom, Double capacite) {
		return evenementRepository.findByNomCapacite(nom, capacite);
	}

	@Override
	public List<Evenement> findByType(Type type) {
		
		return evenementRepository.findByType(type);
	}

	@Override
	public List<Evenement> findByTypeIdType(Long id) {
	
		return evenementRepository.findByTypeIdType(id);
	}

	@Override
	public List<Evenement> findByOrderByNomEvenementAsc() {
		
		return evenementRepository.findByOrderByNomEvenementAsc();
	}

	@Override
	public List<Evenement> trierEvenementsNomsCapacite() {
	
		return evenementRepository.trierEvenementsNomsCapacite();
	}

}
