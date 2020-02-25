package com.ecommerce.microcommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.microcommerce.modele.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	
	public Categorie findById(long id) ;
	public List<Categorie> findBynomCategorieLike (String recherche) ;

}
