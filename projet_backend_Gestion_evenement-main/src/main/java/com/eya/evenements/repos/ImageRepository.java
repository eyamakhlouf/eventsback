package com.eya.evenements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eya.evenements.model.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
}
