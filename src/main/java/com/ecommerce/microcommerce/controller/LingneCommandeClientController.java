package com.ecommerce.microcommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.dao.LigneCommandeRepository;
 
import com.ecommerce.microcommerce.modele.LigneCommandeClient;


import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api")
public class LingneCommandeClientController {
	
	@Autowired
	LigneCommandeRepository ligneCommandeRepository ;
 	
	@ApiOperation("Afficher la liste des lignes de commandes clients")
	@RequestMapping(value="/ligneCommandes", method = RequestMethod.GET)
	public List<LigneCommandeClient> getAll(){	 
		return ligneCommandeRepository.findAll() ;
	}
	
	@ApiOperation("Supprimer une ligne de commande")
	@RequestMapping(value="/ligneCommandes/delete/{id}", method = RequestMethod.DELETE,
	                produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LigneCommandeClient> supprimerUneLigneCmd(@PathVariable long id){
	
		LigneCommandeClient ligneCommande = ligneCommandeRepository.findById(id) ;
		ligneCommandeRepository.delete(ligneCommande);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@ApiOperation("Chercher une ligne de commande selon son ID")
	@RequestMapping(value="/ligneCommandes/{id}", method = RequestMethod.GET,
	                produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<LigneCommandeClient> rechercheParId(@PathVariable long id){
		
		return Optional.ofNullable(ligneCommandeRepository.findById(id))
				.map(ligneCommande -> new ResponseEntity<>(
						ligneCommande,
						HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)) ;
	}
	@ApiOperation("Enregistrer une ligne de commande")
	@RequestMapping(value="/ligneCommandes", method = RequestMethod.POST,
	                produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<LigneCommandeClient> enregistrer(@RequestBody LigneCommandeClient ligneCmd){
		ligneCommandeRepository.save(ligneCmd) ;
		return new ResponseEntity<>(HttpStatus.OK) ;
	}
	

}
 