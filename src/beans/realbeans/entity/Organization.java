package beans.realbeans.entity;

public class Organization extends Entity {
	private Person leader;
	private Location location;
	private DateTime foundationDate;
	
	public Organization() {
		
	}

	public Person getLeader() {
		return leader;
	}

	public void setLeader(Person leader) {
		this.leader = leader;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public DateTime getFoundationDate() {
		return foundationDate;
	}

	public void setFoundationDate(DateTime foundationDate) {
		this.foundationDate = foundationDate;
	}
}
