package beans.realbeans.relationship;

public class Relationship {
	private RelationshipType type;
	
	public Relationship() {
		
	}

	public RelationshipType getType() {
		return type;
	}

	public void setType(RelationshipType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return getType().toString().toLowerCase();
	}
}
