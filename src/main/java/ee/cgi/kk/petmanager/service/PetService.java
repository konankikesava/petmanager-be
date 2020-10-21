package ee.cgi.kk.petmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.cgi.kk.petmanager.domain.Pet;
import  ee.cgi.kk.petmanager.exception.RecordNotFoundException;
import ee.cgi.kk.petmanager.repository.PetMongoRepository;
import ee.cgi.kk.petmanager.repository.PetRepository;
 
@Service
public class PetService {
     
    @Autowired
    PetRepository repository;

	@Autowired
	PetMongoRepository petMongoRepository;
     
	public List<Pet> getAllPets()
    {
		List<Pet> petList = (List<Pet>) repository.findAll();
         
		if (petList.size() > 0) {
			return petList;
        } else {
			return new ArrayList<Pet>();
        }
    }
     
	public Pet getPetById(Long id) throws RecordNotFoundException
    {
		Optional<Pet> pet = repository.findById(id);
         
		if (pet.isPresent()) {
			return pet.get();
        } else {
			throw new RecordNotFoundException("No pet record exist for given id");
        }
    }
     
    
    
	public Pet add(Pet pet) {
		System.out.println(pet + " " + "2");
		Pet empl = repository.save(pet);
    	return empl;
    }
    
	public Pet createOrUpdatePet(Pet entity, long id) throws RecordNotFoundException
    {
		Optional<Pet> pet = repository.findById(id);
         
		if (pet.isPresent())
        {
			Pet newEntity = pet.get();
			newEntity.setName(entity.getName());
			newEntity.setBreed(entity.getBreed());
			newEntity.setBirthDate(entity.getBirthDate());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
	public void deletePetById(Long id) throws RecordNotFoundException
    {
		Optional<Pet> pet = repository.findById(id);
         
		if (pet.isPresent())
        {
            repository.deleteById(id);
        } else {
			throw new RecordNotFoundException("No pet record exist for given id");
        }
    }
}