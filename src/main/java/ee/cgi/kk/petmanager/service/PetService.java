package ee.cgi.kk.petmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.cgi.kk.petmanager.domain.Pet;
import ee.cgi.kk.petmanager.domain.PetDoc;
import  ee.cgi.kk.petmanager.exception.RecordNotFoundException;
import ee.cgi.kk.petmanager.repository.PetRepository;
 
@Service
public class PetService {
     
	@Autowired(required = false)
	PetRepository petRepository;

//	@Autowired
//	PetMongoRepository petMongoRepository;
     
	public List<Pet> getAllPets()
    {
		List<Pet> petList = (List<Pet>) petRepository.findAll();
         
		if (petList.size() > 0) {
			return petList;
        } else {
			return new ArrayList<Pet>();
        }
    }
     
	public Pet getPetById(Long id) throws RecordNotFoundException
    {
		Optional<Pet> pet = petRepository.findById(id);
         
		if (pet.isPresent()) {
			return pet.get();
        } else {
			throw new RecordNotFoundException("No pet record exist for given id");
        }
    }
     
    
    
	public Pet add(Pet pet) {
		System.out.println(pet + " " + "2");
		Pet empl = petRepository.save(pet);
		PetDoc petdoc = convertPetdoc(pet);
		// PetDoc empl1 = petMongoRepository.save(petdoc);
		System.out.println("inserted to mongo db as well");
    	return empl;
    }

	private PetDoc convertPetdoc(Pet pet) {
		return new PetDoc(pet.getName(), pet.getBreed(), pet.getgender(), pet.getBirthDate(), pet.getDeathDate());
	}
    
	public Pet createOrUpdatePet(Pet entity, long id) throws RecordNotFoundException
    {
		Optional<Pet> pet = petRepository.findById(id);
         
		if (pet.isPresent())
        {
			Pet newEntity = pet.get();
			newEntity.setName(entity.getName());
			newEntity.setBreed(entity.getBreed());
			newEntity.setBirthDate(entity.getBirthDate());
 
			newEntity = petRepository.save(newEntity);
             
            return newEntity;
        } else {
			entity = petRepository.save(entity);
             
            return entity;
        }
    }
     
	public void deletePetById(Long id) throws RecordNotFoundException
    {
		Optional<Pet> pet = petRepository.findById(id);
         
		if (pet.isPresent())
        {
			petRepository.deleteById(id);
        } else {
			throw new RecordNotFoundException("No pet record exist for given id");
        }
    }
}