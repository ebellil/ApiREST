package com.ecommerce.microcommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.microcommerce.modele.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long>{

}
