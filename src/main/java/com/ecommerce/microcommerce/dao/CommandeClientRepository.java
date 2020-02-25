package com.ecommerce.microcommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.microcommerce.modele.CommandeClient;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Long>{
	
	public CommandeClient findById(long id) ;

}
