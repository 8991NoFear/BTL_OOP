package beans.realbeans;

import java.util.LinkedList;

public class Article {
	private String link;
	private String ID;
	private LinkedList<Fact> listFact;
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}
	
	public LinkedList<Fact> getListFact() {
		return listFact;
	}
	
	public void setListFact(LinkedList<Fact> listFact) {
		this.listFact = listFact;
	}
}
