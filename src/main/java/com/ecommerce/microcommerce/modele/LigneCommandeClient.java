package com.ecommerce.microcommerce.modele;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class LigneCommandeClient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idLigneCommandeClient;
	/*
	 * @ManyToOne (cascade = {CascadeType.PERSIST},fetch= FetchType.EAGER)
	 * 
	 * @JoinColumn(name ="id_produit")
	 * 
	 * @JsonBackReference private Produit produits ;
	 * 
	 * 
	 * @ManyToOne(cascade = {CascadeType.PERSIST},fetch= FetchType.EAGER)
	 * 
	 * @JoinColumn(name ="id_commande")
	 * 
	 * @JsonBackReference private CommandeClient commandeClient ;
	 * 
	 * 
	 * public LigneCommandeClient() { super(); }
	 * 
	 * public LigneCommandeClient(long idLigneCommandeClient, Produit produits) {
	 * super(); this.idLigneCommandeClient = idLigneCommandeClient; this.produits =
	 * produits; }
	 * 
	 * public LigneCommandeClient(Produit produits) { super(); this.produits =
	 * produits; }
	 * 
	 * public long getIdLigneCommandeClient() { return idLigneCommandeClient; }
	 * 
	 * public void setIdLigneCommandeClient(long idLigneCommandeClient) {
	 * this.idLigneCommandeClient = idLigneCommandeClient; }
	 * 
	 * public Produit getProduits() { return produits; }
	 * 
	 * public void setProduits(Produit produits) { this.produits = produits; }
	 * 
	 * @Override public String toString() { return
	 * "LigneCommandeClient [idLigneCommandeClient=" + idLigneCommandeClient +
	 * ", produits=" + produits + "]"; }
	 */
}
