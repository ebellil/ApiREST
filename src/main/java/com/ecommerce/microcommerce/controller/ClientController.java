package com.ecommerce.microcommerce.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.microcommerce.dao.ClientRepository;
import com.ecommerce.microcommerce.modele.Client;
 

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api")
public class ClientController {
	
	@Autowired
	ClientRepository clientRepository ;
	
	   @RequestMapping(value = "/login", method = RequestMethod.GET)
	   public String welcomePage(Model model) {
	       model.addAttribute("title", "Welcome");
	       model.addAttribute("message", "This is welcome page!");
	       return "loginPage";
	   }

	
	@ApiOperation("Afficher la liste de tout les clients")
	@RequestMapping(value="/clients", method = RequestMethod.GET)
	public List<Client> getAllClient(){
			return clientRepository.findAll() ;
		}
	
	@ApiOperation("Enregistrer un client dans la base de données")
	@RequestMapping(value="/clients", method = RequestMethod.POST,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> enregistrerUnClient(@RequestBody Client newClient){
		
		Client client = clientRepository.save(newClient) ;
		
			if(client == null )
				return  ResponseEntity.noContent().build() ;
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(client.getIdClient())
				.toUri() ;
		
		return ResponseEntity.created(location).build() ;
				
	}

	/*
	 * @RequestMapping(value = "/clients/save", method = RequestMethod.POST) public
	 * ResponseEntity<Client> enregistrerClient2(@Valid Client client, BindingResult
	 * bindingResult,
	 * 
	 * @RequestParam(name = "picture") MultipartFile file) throws Exception,
	 * IOException {
	 * 
	 * if (bindingResult.hasErrors()) {
	 * 
	 * return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 * 
	 * if (!(file.isEmpty())) { client.setPhoto(file.getOriginalFilename());
	 * 
	 * } clientRepository.save(client) ; if (!(file.isEmpty())) {
	 * client.setPhoto(file.getOriginalFilename()); file.transferTo(new
	 * File(System.getProperty("user.home") + "/ProjetPhoto/" +
	 * client.getIdClient())); }
	 * 
	 * return new ResponseEntity<>(HttpStatus.CREATED) ; }
	 * 
	 * @RequestMapping(value="/voirPhoto",
	 * produces=org.springframework.http.MediaType.IMAGE_PNG_VALUE, method =
	 * RequestMethod.GET)
	 * 
	 * @ResponseBody public byte[] voirPhoto(Long id) throws Exception, IOException
	 * { File f = new File(System.getProperty("user.home")+"/ProjetPhoto/"+id) ;
	 * 
	 * return IOUtils.toByteArray(new FileInputStream(f)) ; }
	 * 
	 */	
	@ApiOperation("Supprimer un client à partir de son ID ")
	@RequestMapping(value="/clients/delete/{id}", method = RequestMethod.DELETE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Client> supprimerUnClient(@PathVariable long id){
		Client client = clientRepository.findById(id) ;
		clientRepository.delete(client);
		
		return new ResponseEntity<>(HttpStatus.OK) ;
	}
	
	@ApiOperation("Chercher un client à partir de son identifiant ")
	@RequestMapping(value="/clients/{identifiant}", method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> rechercheParId(@PathVariable long identifiant){
		return Optional.ofNullable(clientRepository.findById(identifiant))
				.map(client -> new ResponseEntity<>(
						client,
						HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)) ;
		
	}
	
	@ApiOperation("Mise a jour d'un client")
	@RequestMapping(value="/clients/update/{id}", method = RequestMethod.PUT,
			      produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> update(@RequestBody Client newClient, @PathVariable long id){
		
		Client client = clientRepository.findById(id) ;
		if(client != null) {
			
			client.setNom(newClient.getNom());
			client.setPrenom(newClient.getPrenom());
			client.setAdresse(newClient.getAdresse());
			client.setTelephone(newClient.getTelephone());
			client.setPhoto(newClient.getPhoto());
			clientRepository.save(client);
			return new ResponseEntity<>(HttpStatus.OK) ;
		}
		
		clientRepository.save(newClient) ;
		return new ResponseEntity<>(HttpStatus.CREATED) ;
	}
	
	@ApiOperation("Recherche de clients par mot clé  ")
	@RequestMapping(value="/clients/mc/{recherche}", method = RequestMethod.GET)
	public List<Client> rechercheParMotCle(@PathVariable String recherche){
		return clientRepository.findBynomLike("%"+recherche+"%") ;
	}
	
}
