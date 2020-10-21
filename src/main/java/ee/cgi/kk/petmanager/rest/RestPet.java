package ee.cgi.kk.petmanager.rest;

public class RestPet {

	private Long id;

	private String cpetname;

	private String cpetbreed;

	private String cpetgender;

	private String startdate;

	private String enddate;

	public RestPet() {
	}

	/**
	 * For unit testing
	 */
	public RestPet(String petname, String cpetbreed, String cpetgender, 
			String startdate, String enddate) {

		this.cpetname = petname;
		this.cpetbreed = cpetbreed;
		this.cpetgender = cpetgender;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getCpetname() {
		return cpetname;
	}

	public void setCpetname(String cpetname) {
		this.cpetname = cpetname;
	}

	public String getCpetBreed() {
		return cpetbreed;
	}

	public void setCpetBreed(String cpetbreed) {
		this.cpetbreed = cpetbreed;
	}

	public String getCpetgender() {
		return cpetgender;
	}

	public void setCpetgender(String cpetgender) {
		this.cpetgender = cpetgender;
	}

}
