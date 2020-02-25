package com.ecommerce.microcommerce.modele;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produit implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long idProduit ;
	private String designation ;
	private double prix ;
	private int quantite ;
	private String photo ;
	
	@ManyToOne()
	@JoinColumn(name ="id_categorie")
	@JsonBackReference
	private Categorie categories ;
	
	@ManyToOne()
	@JoinColumn(name = "id_commande")
	@JsonBackReference
	@JsonIgnore
	private CommandeClient commandes ;
	
	public Produit() {
		super();
	}

	public Produit(String designation, double prix, int quantite, String photo, Categorie categories) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.photo = photo;
		this.categories = categories;
	}

	public Produit(Produit findById) {
		// TODO Auto-generated constructor stub
	}

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Categorie getCategories() {
		return categories;
	}

	public void setCategories(Categorie categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", designation=" + designation + ", prix=" + prix + ", quantite="
				+ quantite + ", photo=" + photo + ", categories=" + categories + "]";
	}
 
	

}
