package beans.realbeans.entity;

public class Agreement extends Entity {
	private DateTime dateTime;
	private Location location;
	
	public Agreement() {
		
	}
	
	public DateTime getTime() {
		return dateTime;
	}
	
	public void setTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
}
