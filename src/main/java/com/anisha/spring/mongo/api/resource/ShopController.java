package com.anisha.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;
//
//import com.javatechie.spring.mongo.api.model.DescriptionModel;
//import com.javatechie.spring.mongo.api.repository.DescriptionRepository;
import com.anisha.spring.mongo.api.model.DocumentType;
import com.anisha.spring.mongo.api.model.ProductPrice;
import com.anisha.spring.mongo.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.anisha.spring.mongo.api.repository.ShopRepository;

@RestController
public class ShopController {

	@Autowired
	private ShopRepository repository;

	@Autowired
	private service s;
//
//	@Autowired
//	private DescriptionRepository drepository;

	@RequestMapping("/")
	public String hello(){
		return "Hello World";
	}

	@CrossOrigin("http://localhost:57624/")
	@PostMapping("/addShop")
	public String saveShop(@RequestBody DocumentType documentType) {
		if(repository.findById((int) documentType.getId()).isPresent()){
			return "Product already added!";
		}
		repository.save(documentType);
		return "Added product";
	}

	@CrossOrigin("http://localhost:57624/")
	@PutMapping("/findAllShops/{id}")
	public String putShop(@RequestBody DocumentType documentType, @PathVariable int id) {
		Optional<DocumentType> d = repository.findById(id);
		if(d.isPresent()){
			DocumentType document = d.get();
			ProductPrice p = new ProductPrice(documentType.getProductPrice().getCurrencyCode(),documentType.getProductPrice().getCurrentPrice());
			document.setProductPrice(p);
			if (repository.save(document).getId() == (id)) {
				return "Success";
			}
		}
		return "Failure";
	}

	@CrossOrigin("http://localhost:57624/")
	@GetMapping("/findAllShops")
	public List<DocumentType> getShops() {
		return repository.findAll();
	}

	@CrossOrigin("http://localhost:57624/")
	@GetMapping("/findAllShops/{id}")
	public Optional<DocumentType> getShops(@PathVariable int id) {
		return repository.findById(id);
	}

	@CrossOrigin("http://localhost:57624/")
	@DeleteMapping("/delete/{id}")
	public List<DocumentType> deleteShops(@PathVariable int id) {
		repository.deleteById(id);
		return repository.findAll();
	}

	@CrossOrigin("http://localhost:57624/")
	@GetMapping("/findAll/{id}")
	public List<DocumentType> findall(@PathVariable int id){
		return s.allTheDescription(id);
	}

	@CrossOrigin("http://localhost:57624/")
	@GetMapping("/findNameId/{id}/{name}")
	public List<DocumentType> findNameId(@PathVariable int id,@PathVariable String name){
		return s.queryNameId(id,name);
	}

}
