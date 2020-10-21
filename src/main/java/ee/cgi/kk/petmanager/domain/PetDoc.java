package ee.cgi.kk.petmanager.domain;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PetDoc {


	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_Sequence")
//	@SequenceGenerator(name = "id_Sequence", sequenceName = "PET_SEQ", allocationSize = 1)
//	@GenericGenerator(name = "id_Sequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
//			@Parameter(name = "PET_SEQ", value = "SEQUENCE") })
	@Column(name = "ID")
	private Long id;

	@Column(name = "V_NAME")
	private String name;

	@Column(name = "V_BREED")
	private String breed;

	@Column(name = "C_GENDER")
	private String gender;

	@Column(name = "N_BIRTH_DATE")
	private String birthDate;

	@Column(name = "N_DEATH_DATE")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
