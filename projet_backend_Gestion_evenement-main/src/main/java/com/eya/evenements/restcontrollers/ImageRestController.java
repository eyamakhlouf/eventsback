package com.eya.evenements.restcontrollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eya.evenements.model.Evenement;
import com.eya.evenements.model.Image;
import com.eya.evenements.service.EvenementService;
import com.eya.evenements.service.ImageService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	 @Autowired
	 ImageService imageService ;
	 @Autowired
	 EvenementService evenementService;

	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 @PostMapping(value = "/uplaodImageEvnt/{idEvent}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
			 @PathVariable("idEvent") Long idEvnt) 
					 throws IOException {
		 return imageService.uplaodImageEvnt(file,idEvnt);
	 }
	 @RequestMapping(value = "/getImagesEvnt/{idEvnt}" , method = RequestMethod.GET)
	 public List<Image> getImagesProd(@PathVariable("idEvnt") Long idEvnt) 
			 throws IOException {
		 return imageService.getImagesParEvnt(idEvnt);
	 }
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;
	 }
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException
	{
	 return imageService.getImage(id);
	 }


	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);
	 }
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	/* @RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile
	file,@PathVariable("id") Long id) throws IOException {
	 Evenement e = evenementService.getEvenement(id);
	 e.setImagePath(id+".jpg");
     System.out.println(e.getImagePath());
	Files.write(Paths.get(System.getProperty("user.home")+"/images/"+e.getImagePath())
	, file.getBytes());
	 evenementService.saveEvenement(e);}*/

	 
	 /*@RequestMapping(value = "/loadfromFS/{id}" ,method = RequestMethod.GET, produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

	 Evenement e = evenementService.getEvenement(id);
	 return
	Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+e.getImagePath()));
	 }*/

	}
