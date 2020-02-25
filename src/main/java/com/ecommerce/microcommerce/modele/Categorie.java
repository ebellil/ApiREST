package com.ecommerce.microcommerce.modele;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Categorie implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long idCategorie ;
	private String codeCategorie ;
	private String nomCategorie ;
	
	@OneToMany (targetEntity =Produit.class, mappedBy="categories", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Produit> produits ;
	
	public Categorie() {
		super();
	}
	
	

	public Categorie(String codeCategorie, String nomCategorie, List<Produit> produits) {
		super();
		this.codeCategorie = codeCategorie;
		this.nomCategorie = nomCategorie;
		this.produits = produits;
	}

    

	public Categorie(String codeCategorie, String nomCategorie) {
		super();
		this.codeCategorie = codeCategorie;
		this.nomCategorie = nomCategorie;
	}



	public Categorie(long idCategorie, String codeCategorie, String nomCategorie, List<Produit> produits) {
		super();
		this.idCategorie = idCategorie;
		this.codeCategorie = codeCategorie;
		this.nomCategorie = nomCategorie;
		this.produits = produits;
	}



	public long getIdCategorie() {
		return idCategorie;
	}



	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}



	public String getCodeCategorie() {
		return codeCategorie;
	}



	public void setCodeCategorie(String codeCategorie) {
		this.codeCategorie = codeCategorie;
	}



	public String getNomCategorie() {
		return nomCategorie;
	}



	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}



	public List<Produit> getProduits() {
		return produits;
	}



	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}



	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", codeCategorie=" 
	           + codeCategorie + ", nomCategorie="+ nomCategorie + ", produits=" 
			   + produits + "]";
	}
	
	
	
	

}
