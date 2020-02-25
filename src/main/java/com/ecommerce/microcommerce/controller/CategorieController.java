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

 
import com.ecommerce.microcommerce.dao.CategorieRepository;
import com.ecommerce.microcommerce.modele.Categorie;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("Categorie Controlleur")
@RequestMapping(value="api")
public class CategorieController {
	
	@Autowired
	CategorieRepository categorieRepository ;
	
	@ApiOperation("Afficher la liste des categories")
	@RequestMapping(value="categories", method = RequestMethod.GET)
	public List<Categorie> getAllCategorie(){
		
		return categorieRepository.findAll() ;
		
	}
	
	@ApiOperation("Afficher une categorie selon son ID")
	@RequestMapping(value="/categories/{id}", method = RequestMethod.GET,
                    produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categorie> AfficherUneCategorie(@PathVariable long id){
		
		return Optional.ofNullable(categorieRepository.findById(id))
				.map(categorie -> new ResponseEntity<>(
						categorie,
						HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)) ;
 
	}
	
	@ApiOperation("Enregister une categorie ")
	@RequestMapping(value="/categories", method = RequestMethod.POST,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categorie> enregistrerUneCategorie(@RequestBody Categorie categorie){		
		categorieRepository.save(categorie) ;
		return new ResponseEntity<>(HttpStatus.CREATED) ;
		     		     
	}
	
	@ApiOperation("Supprimer une categorie selon son ID")
	@RequestMapping(value="/categories/{identifiant}", method = RequestMethod.DELETE)
	public ResponseEntity<Categorie> supprimerUneCategorie(@PathVariable long identifiant) {
		categorieRepository.deleteById(identifiant);
		return new ResponseEntity<>(HttpStatus.OK) ;
		
	}
	
	@ApiOperation("Mise à jour de la collection ")
	@RequestMapping(value="/categories/{id}", method = RequestMethod.PUT,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categorie> update(@PathVariable long id, @RequestBody Categorie newCategorie) {
		
		Categorie categorie = categorieRepository.findById(id) ;
		
			if(categorie == null) {
				categorieRepository.save(categorie) ;
		
		return new ResponseEntity<>(HttpStatus.CREATED) ;
	  }		
					categorie.setCodeCategorie(newCategorie.getCodeCategorie());
					categorie.setNomCategorie(newCategorie.getNomCategorie());
					categorieRepository.save(categorie) ;
			
		return new ResponseEntity<>(HttpStatus.OK) ;
		
	}
	
	@ApiOperation("Chercher une categorie par mot clé ")
	@RequestMapping(value="/categories/mc/{recherche}", method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Categorie> rechercheParMc(@PathVariable String recherche){
		
		return categorieRepository.findBynomCategorieLike(recherche) ;
	}

}
