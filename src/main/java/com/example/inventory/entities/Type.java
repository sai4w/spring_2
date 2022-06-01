package com.example.inventory.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idType;
	private String nameType;
	private String descriptionType;
	
	
	@OneToMany(mappedBy="type")
	@JsonIgnore
	private List<Skin> skins;


	public Long getIdType() {
		return idType;
	}


	public void setIdType(Long idType) {
		this.idType = idType;
	}


	public String getNameType() {
		return nameType;
	}


	public void setNameType(String nameType) {
		this.nameType = nameType;
	}


	public String getDescriptionType() {
		return descriptionType;
	}


	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}


	public List<Skin> getSkins() {
		return skins;
	}


	public void setSkins(List<Skin> skins) {
		this.skins = skins;
	}


	@Override
	public String toString() {
		return "Type [idType=" + idType + ", nameType=" + nameType + ", descriptionType=" + descriptionType + ", skins="
				+ skins + "]";
	} 
	
}	
	
	