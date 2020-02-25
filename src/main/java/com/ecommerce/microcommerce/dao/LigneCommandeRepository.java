package com.ecommerce.microcommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.microcommerce.modele.LigneCommandeClient;

public interface LigneCommandeRepository extends JpaRepository<LigneCommandeClient, Long>{
	
	public LigneCommandeClient findById(long id) ;

}
