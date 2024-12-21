package com.eya.evenements.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.eya.evenements.model.Type;

@RepositoryRestResource(path = "type")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular 
public interface TypeRepository extends JpaRepository<Type, Long> {

}
