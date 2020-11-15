package ee.cgi.kk.petmanager.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PetDoc {


	@Id
	private String id;

	private String name;

	private String breed;

	private String gender;

	private String birthDate;

	private String deathDate;

	public PetDoc() {
	}

	/**
	 * For unit testing
	 */
	public PetDoc(String petname, String breed, String gender, String birthDate, String deathDate) {

		this.name = petname;
		this.breed = breed;
		this.gender = gender;
		this.birthDate = birthDate;
		this.deathDate = deathDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getgender() {
		return gender;
	}

	public void setgender(String gender) {
		this.gender = gender;
	}

}
