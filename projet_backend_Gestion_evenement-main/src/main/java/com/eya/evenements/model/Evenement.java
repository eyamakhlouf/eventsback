package com.eya.evenements.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
public class Evenement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvenement;
	private String nomEvenement;
	private Double capacite;
	private Date dateEvenement;
	
	@ManyToOne
	private Type type;
	
	
	/*@OneToOne
	private Image image;*/
	@OneToMany (mappedBy = "evenement")
	 private List<Image> images;
	
	
	public Evenement() {
		super();
		
	}
	
	public Evenement(String nomEvenement, Double capacite, Date dateEvenement) {
		super();
		this.nomEvenement = nomEvenement;
		this.capacite = capacite;
		this.dateEvenement = dateEvenement;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getIdEvenement() {
		return idEvenement;
	}
	public void setIdEvenement(Long idEvenement) {
		this.idEvenement = idEvenement;
	}
	public String getNomEvenement() {
		return nomEvenement;
	}
	public void setNomEvnement(String nomEvnement) {
		this.nomEvenement = nomEvnement;
	}
	public Double getCapacite() {
		return capacite;
	}
	public void setCapacite(Double capacite) {
		this.capacite = capacite;
	}
	public Date getDateEvenement() {
		return dateEvenement;
	}
	public void setDateEvenement(Date dateEvenement) {
		this.dateEvenement = dateEvenement;
	}
	


	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	

	@Override
	public String toString() {
		return "Evenement [idEvenement=" + idEvenement + ", nomEvnement=" + nomEvenement + ", capacite=" + capacite
				+ ", dateEvenement=" + dateEvenement + "]";
	}
	
	
}
