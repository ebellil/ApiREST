package com.ecommerce.microcommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.microcommerce.modele.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
	public Produit findById(long id) ;
	public List<Produit> findBydesignationLike(String recherche) ;
	
	public List<Produit> findByPrixGreaterThan(double limite) ;

}
