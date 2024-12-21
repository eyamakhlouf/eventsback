package com.eya.evenements.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.eya.evenements.model.Image;

public interface ImageService {
 Image uplaodImage(MultipartFile file) throws IOException;
 public Image uplaodImageEvnt(MultipartFile file,Long idEvnt)throws IOException;
 Image getImageDetails(Long id) throws IOException;
 ResponseEntity<byte[]> getImage(Long id) throws IOException;
 public List<Image> getImagesParEvnt(Long EvntId);
 void deleteImage(Long id) ;
}
