package beans.realbeans.entity;

public class Country extends Entity {
	private double population;
	private String officialLanguage;
	
	public Country() {
		
	}
	
	public double getPopulation() {
		return population;
	}
	
	public void setPopulation(double population) {
		this.population = population;
	}
	
	public String getOfficialLanguage() {
		return officialLanguage;
	}
	
	public void setOfficialLanguage(String officialLanguage) {
		this.officialLanguage = officialLanguage;
	}
}
