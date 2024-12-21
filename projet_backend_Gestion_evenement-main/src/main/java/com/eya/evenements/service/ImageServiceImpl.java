package com.eya.evenements.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eya.evenements.model.Evenement;
import com.eya.evenements.model.Image;
import com.eya.evenements.repos.EvenementRepository;
import com.eya.evenements.repos.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImageRepository imageRepository;
	@Autowired
	EvenementService evenementService;
	@Autowired
	EvenementRepository evenementRepository;
	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		/*
		 * Ce code commenté est équivalent au code utilisant le design pattern Builder
		 * Image image = new Image(null, file.getOriginalFilename(),
		 * file.getContentType(), file.getBytes(), null);
		 *   return imageRepository.save(image);
		 */
		return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(file.getBytes()).build());
	}
	@Override
	public Image uplaodImageEvnt(MultipartFile file,Long idEvnt)throws IOException {
		Evenement e = new Evenement();
			e.setIdEvenement(idEvnt);
			return imageRepository.save(Image.builder()
			 .name(file.getOriginalFilename())
			 .type(file.getContentType())
			 .image(file.getBytes())
			 .evenement(e).build() );
			}

	@Override
	public Image getImageDetails(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return Image.builder().idImage(dbImage.get().getIdImage()).name(dbImage.get().getName())
				.type(dbImage.get().getType()).image(dbImage.get().getImage()).build();
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
				.body(dbImage.get().getImage());
	}
	@Override
	public List<Image> getImagesParEvnt(Long EvntId) {
	Evenement e = evenementRepository.findById(EvntId).get();
	return e.getImages();
	}

	@Override
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}
}