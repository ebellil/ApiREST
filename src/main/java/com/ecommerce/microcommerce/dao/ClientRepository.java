package com.ecommerce.microcommerce.dao;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 

import com.ecommerce.microcommerce.modele.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{
	
	public Client findById(long identifiant) ;
	
	public List<Client> findBynomLike(String recherche) ;
 
}
