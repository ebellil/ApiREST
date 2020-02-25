package com.ecommerce.microcommerce.modele;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class CommandeClient implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long idCommande ;
	private String codeCommande ;
	private Date dateCommande ; 
 
	@OneToMany//(targetEntity = Produit.class , mappedBy="commandes", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Produit> produits ;
	
	@ManyToOne 
	@JoinColumn(name ="id_client")
	@JsonBackReference
	private Client client ;
	
	public CommandeClient() {
		super();
	}

	public CommandeClient(long idCommande, String codeCommande, Date dateCommande, List<Produit> produits,
			Client client) {
		super();
		this.idCommande = idCommande;
		this.codeCommande = codeCommande;
		this.dateCommande = dateCommande;
		this.produits = produits;
		this.client = client;
	}

	public CommandeClient(String codeCommande, Date dateCommande, List<Produit> produits, Client client) {
		super();
		this.codeCommande = codeCommande;
		this.dateCommande = dateCommande;
		this.produits = produits;
		this.client = client;
	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	public String getCodeCommande() {
		return codeCommande;
	}

	public void setCodeCommande(String codeCommande) {
		this.codeCommande = codeCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "CommandeClient [idCommande=" + idCommande + ", codeCommande=" + codeCommande + ", dateCommande="
				+ dateCommande + ", produits=" + produits + ", client=" + client + "]";
	}
 	
	

}
