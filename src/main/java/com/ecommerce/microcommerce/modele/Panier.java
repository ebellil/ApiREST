package com.ecommerce.microcommerce.modele;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id; 
 
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
 
@Entity
public class Panier implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long idPanier ;
	
	@OneToMany (targetEntity =CommandeClient.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference
	  private List<CommandeClient> commandes;
	  
	  public Panier() { super(); }
	  
	  public Panier(List<CommandeClient> commandes) { super(); this.commandes =
	  commandes; }
	  
	  public long getIdPanier() { return idPanier; }
	  
	  public void setIdPanier(long idPanier) { this.idPanier = idPanier; }
	  
	  public List<CommandeClient> getCommandes() { return commandes; }
	  
	  public void setCommandes(List<CommandeClient> commandes) { this.commandes =
	  commandes; }
	  
	  public String toString() { return "Panier [idPanier=" + idPanier + ", commandes=" + commandes + "]";
	  
	  }
	 
}
