package beans.realbeans.entity;

public class Person extends Entity {
	private String gender;
	private Country country;
	private DateTime dateOfBirth;
	
	public Person() {
		
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public DateTime getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(DateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
