package ee.cgi.kk.petmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ee.cgi.kk.petmanager.domain.Pet;
import ee.cgi.kk.petmanager.exception.RecordNotFoundException;
import ee.cgi.kk.petmanager.service.PetService;
 
@RestController
@CrossOrigin("*")
@RequestMapping("/pet")

public class PetController
{
	@Autowired
    PetService service;
 
    @GetMapping("/All")
    
	public ResponseEntity<List<Pet>> getAllPets() {
		List<Pet> list = service.getAllPets();
 
		return new ResponseEntity<List<Pet>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
	public ResponseEntity<Pet> getPetById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
		Pet entity = service.getPetById(id);
 
		return new ResponseEntity<Pet>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping("/add")
	public ResponseEntity<Pet> addPet(@RequestBody Pet pet) throws RecordNotFoundException {
		System.out.println(pet);
		Pet empl = service.add(pet);
		return new ResponseEntity<Pet>(empl, new HttpHeaders(), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
	public ResponseEntity<Pet> createOrUpdatePet(@RequestBody Pet pet, @PathVariable("id") long id)
                                                    throws RecordNotFoundException {
    	
		Pet updated = service.createOrUpdatePet(pet, id);
		return new ResponseEntity<Pet>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
	public HttpStatus deletePetById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
		service.deletePetById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}