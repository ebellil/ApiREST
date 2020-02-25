package com.ecommerce.microcommerce;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ecommerce.microcommerce.dao.CategorieRepository;
import com.ecommerce.microcommerce.dao.ClientRepository;
import com.ecommerce.microcommerce.dao.CommandeClientRepository;
import com.ecommerce.microcommerce.dao.LigneCommandeRepository;
import com.ecommerce.microcommerce.dao.ProduitRepository;

import com.ecommerce.microcommerce.modele.Categorie;
import com.ecommerce.microcommerce.modele.Client;
import com.ecommerce.microcommerce.modele.CommandeClient;
import com.ecommerce.microcommerce.modele.Produit;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication 
@CrossOrigin("*")
@EnableSwagger2
public class ProjetAosApiRestApplication implements CommandLineRunner{
	
	@Autowired
	ProduitRepository produitRepository ;
	@Autowired
	CategorieRepository categorieRepository ;
	@Autowired
	ClientRepository clientRepository ;
	@Autowired
	CommandeClientRepository commandeClientRepository ;
	@Autowired
	LigneCommandeRepository ligneCommandeRepository ;

	public static void main(String[] args) {
		SpringApplication.run(ProjetAosApiRestApplication.class, args);
	} 

	@Override
	public void run(String... args) throws Exception {
		
		  List<Produit> listProduits = new ArrayList<>() ;
		  
		  Categorie categorie1 = categorieRepository.save(new Categorie("AAA001",
		  "ORDINATEUR")) ; Categorie categorie2 = categorieRepository.save(new
		  Categorie("AAA001", "TELEPHONE")) ; Categorie categorie3 =
		  categorieRepository.save(new Categorie("AAA001", "ACCESSOIR NUMERIQUE")) ;
		  
		  
		  for(int compteur = 0 ; compteur <=20 ; compteur++ ) {
		  produitRepository.save(new Produit("Ordinateur HP", 850.99, 4000, "img",
		  categorie1)) ; produitRepository.save(new Produit("Ordinateur ACCER", 600.99,
		  1500, "img", categorie1)) ; produitRepository.save(new
		  Produit("Ordinateur TOSHIBA", 1665.99, 1300, "img", categorie1)) ;
		  produitRepository.save(new Produit(" Iphone 10 pro", 1200.99, 8000, "img",
		  categorie2)) ; produitRepository.save(new Produit("Honor 10 P-Lit", 400.70,
		  6000, "img", categorie2)) ; produitRepository.save(new
		  Produit("Impriment Milti-fonction", 350.85, 2000, "img", categorie3)) ;
		  produitRepository.save(new Produit("Scanneur X-360", 850.45, 3000, "img",
		  categorie3)) ;
		  
		  }
		  
		  for(int compteur = 0 ; compteur < 10 ; compteur++) {
		  
		  clientRepository.save(new Client("DIALLO", "Thierno", "Paris", 752145,
		  "img")) ; clientRepository.save(new Client("ERWAN", "Bellil", "Evry", 124578,
		  "photo")) ; clientRepository.save(new Client("JEAN", "Dupond", "Angers",
		  752457, "img")) ; clientRepository.save(new Client("BARRY", "Mamadou",
		  "Paris 13è", 621445, "photo")) ;
		  
		  }
		  
		  Produit prod = produitRepository.findById(18) ; Produit prod2 =
		  produitRepository.findById(38) ; Produit prod3 =
		  produitRepository.findById(8) ; Produit prod4 = produitRepository.findById(9)
		  ;
		  
		  Client client1 = clientRepository.findById(151) ;
		  
		  listProduits.add(prod) ; listProduits.add(prod2) ; listProduits.add(prod3) ;
		  listProduits.add(prod4) ;
		  
		  commandeClientRepository.save(new CommandeClient("Cmd1", new Date(),
		  listProduits, client1)) ;
		 
	}

}
