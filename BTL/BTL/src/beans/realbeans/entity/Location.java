package beans.realbeans.entity;

public class Location extends Entity {
	private Country country;
	private String coordinate;
	
	public Location() {
		
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public String getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
}
