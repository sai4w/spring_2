package com.example.inventory.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Skin {
	
     	@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	    private Long idSkin;
     	@NotNull
     	@Size (min = 4,max = 40)
	    private String nameSkin ;
     	@Min(value = 10)
     	@Max(value = 10000)
	    private double priceSkin ;
	    @Temporal(TemporalType.DATE)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @PastOrPresent
	    private Date dateSkin;
	    
	    @ManyToOne
	    private Type type;
	    
	    
		
		public Skin() {
			super();
		}



		public Skin(Long idSkin, @NotNull @Size(min = 4, max = 40) String nameSkin,
				@Min(10) @Max(10000) double priceSkin, @PastOrPresent Date dateSkin, Type type) {
			this.idSkin = idSkin;
			this.nameSkin = nameSkin;
			this.priceSkin = priceSkin;
			this.dateSkin = dateSkin;
			this.type = type;
		}



		public Long getIdSkin() {
			return idSkin;
		}



		public void setIdSkin(Long idSkin) {
			this.idSkin = idSkin;
		}



		public String getNameSkin() {
			return nameSkin;
		}



		public void setNameSkin(String nameSkin) {
			this.nameSkin = nameSkin;
		}



		public double getPriceSkin() {
			return priceSkin;
		}



		public void setPriceSkin(double priceSkin) {
			this.priceSkin = priceSkin;
		}



		public Date getDateSkin() {
			return dateSkin;
		}



		public void setDateSkin(Date dateSkin) {
			this.dateSkin = dateSkin;
		}



		public Type getType() {
			return type;
		}



		public void setType(Type type) {
			this.type = type;
		}



		@Override
		public String toString() {
			return "Skin [idSkin=" + idSkin + ", nameSkin=" + nameSkin + ", priceSkin=" + priceSkin + ", dateSkin="
					+ dateSkin + ", type=" + type + "]";
		}



	    
}
