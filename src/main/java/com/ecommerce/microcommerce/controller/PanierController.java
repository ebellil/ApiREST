package com.ecommerce.microcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.dao.PanierRepository;

@RestController
public class PanierController {
	
	@Autowired
	PanierRepository panierRepository ;

}
