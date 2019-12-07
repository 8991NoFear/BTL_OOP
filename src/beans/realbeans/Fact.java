package beans.realbeans;

import beans.realbeans.entity.DateTime;
import beans.realbeans.entity.Entity;
import beans.realbeans.relationship.Relationship;

public class Fact {
	private DateTime dateTime;
	private Entity subject, object;
	private Relationship relationship;
	private String ID;
	
	public Fact() {
		
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Entity getSubject() {
		return subject;
	}

	public void setSubject(Entity subject) {
		this.subject = subject;
	}

	public Entity getObject() {
		return object;
	}

	public void setObject(Entity object) {
		this.object = object;
	}

	public Relationship getRelationship() {
		return relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}
