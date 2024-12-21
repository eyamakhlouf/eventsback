package com.eya.evenements;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import com.eya.evenements.model.Evenement;
import com.eya.evenements.model.Type;
import com.eya.evenements.repos.EvenementRepository;
import com.eya.evenements.service.*;
@SpringBootTest
class EvenementsApplicationTests {

	@Autowired
	private EvenementRepository evenementRepository;
	@Autowired
	private EvenementService evenementService;
	@Test
	public void testCreateEvenement() {
	Evenement Even = new Evenement("Crepto Art",100.00,new Date());
	evenementRepository.save(Even);
	}
	 @Test
	 public void testFindEvenement()
	 {
		 Evenement e = evenementRepository.findById(4L).get();
	 System.out.println(e);
	 }
	 @Test
	 public void testUpdateEvenement()
	 {
		 Evenement e = evenementRepository.findById(2L).get();
	 e.setCapacite(200.0);
	 evenementRepository.save(e);
	 }
	 @Test
	 public void testDeleteEvenement()
	 {
		 evenementRepository.deleteById(1L);;
	 }

	 @Test
	 public void testListerTousEvenement()
	 {
	 List<Evenement> Even = evenementRepository.findAll();
	 for (Evenement e : Even)
	 {
	 System.out.println(e);
	 }
	 }
	 
	 @Test
	 public void testFindByNomEvenemntsContains()
	 {
	 Page<Evenement> even = evenementService.getAllEvenementsParPage(0,2);
	 System.out.println(even.getSize());
	 System.out.println(even.getTotalElements());
	 System.out.println(even.getTotalPages());
	 even.getContent().forEach(e -> {System.out.println(e.toString());
	  });
	 
	 }
	 @Test
	 public void testFindByNomEvenement()
	 {
	 List<Evenement> even = evenementRepository.findByNomEvenement("Crepto Art");
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 }
	 }
	 @Test
	 public void testFindByNomEvenementContains ()
	 {
	 List<Evenement> even=evenementRepository.findByNomEvenementContains("Crepto Art");
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 } }
	 @Test
	 public void testfindByCapacite()
	 {
	 List<Evenement> even = evenementRepository.findByNomCapacite("Isec", 100.0);
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 }
	 }
	 @Test
	 public void testfindByTypeIdType()
	 {
	 List<Evenement> even = evenementRepository.findByTypeIdType(1L);
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 }
	  }
	 @Test
	 public void testfindBytype()
	 {
	 Type type = new Type();
	 type.setIdType(1L);
	 List<Evenement> even = evenementRepository.findByType(type);
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 }
	 }

	 @Test
	 public void testfindByOrderByNomEvenementAsc()
	 {
	 List<Evenement> even =evenementRepository.findByOrderByNomEvenementAsc();
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 }
	 }
	 @Test
	 public void testtrierEvenementsNomsCapacite()
	 {
		 List<Evenement> even = evenementRepository.trierEvenementsNomsCapacite();
		 for (Evenement e : even)
		 {
		 System.out.println(e);
		 }
		 }

}
