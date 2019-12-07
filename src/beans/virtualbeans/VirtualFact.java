package beans.virtualbeans;

import java.util.Random;

import beans.realbeans.relationship.RelationshipType;

public class VirtualFact {
	private String ID;
	private String subjectID;
	private String objectID;
	private String relationship;
	private String timeID;
	private String articleID;
	private Random random;
	private StringBuilder factSB;
	
	public VirtualFact() {
		random = new Random();
		factSB = new StringBuilder("insert into FACT (ID, subjectID, objectID, relationship, timeID, articleID) values");
	}
	
	public String getBatch() {
		factSB.setLength(factSB.length() - 1);
		factSB.append(";");
		return factSB.toString();
	}
	
	public void addBatch(String ID, String subjectID, String objectID, String relationship, String timeID, String articleID) {
		factSB.append("('" + ID + "', '" + subjectID + "', '" + objectID + "', '" + relationship + "', '" + timeID + "', '" + articleID + "')," );
	}
	
	public void generate(int numberOfRecords) {
		int rand = 0;
		for(Integer i = 0; i < numberOfRecords; i++) {
			ID = "FACT" + i.toString();
			timeID = "DATETIME" + i.toString();
			articleID = "ARTICLE" + i.toString();
			
			rand = random.nextInt(11);
			RelationshipType[] arrRelaType = RelationshipType.values();
			RelationshipType type = arrRelaType[rand];
			switch(type) {
			case MEET:
				subjectID = "PERSON" + i.toString();
				objectID = "PERSON" + ((Integer) rand).toString();
				relationship = "MEET";
				break;
			case ORGANIZE:
				subjectID = "ORGANIZATION" + i.toString();
				objectID = "EVENT" + i.toString();
				relationship = "ORGANIZE";
				break;
			case CONTRACT:
				subjectID = "COUNTRY" + i.toString();
				objectID = "COUNTRY" + ((Integer) rand).toString();
				relationship = "CONTRACT";
				break;
			case JOINT:
				subjectID = "PERSON" + i.toString();
				objectID = "EVENT" + i.toString();
				relationship = "JOINT";
				break;
			case TAKEPLACE:
				subjectID = "EVENT" + i.toString();
				objectID = "LOCATION" + i.toString();
				relationship = "TAKEPLACE";
				break;
			case SUPPORT:
				subjectID = "COUNTRY" + i.toString();
				objectID = "AGREEMENT" + i.toString();
				relationship = "SUPPORT";
				break;
			case OPPOSE:
				subjectID = "PERSON" + i.toString();
				objectID = "AGREEMENT" + i.toString();
				relationship = "OPPOSE";
				break;
			case EXPRESS:
				subjectID = "PERSON" + i.toString();
				objectID = "EVENT" + i.toString();
				relationship = "EXPRESS";
				break;
			case TENSE:
				subjectID = "COUNTRY" + i.toString();
				objectID = "COUNTRY" + ((Integer) rand).toString();
				relationship = "TENSE";
				break;
			case CANCEL:
				subjectID = "COUNTRY" + i.toString();
				objectID = "AGREEMENT" + i.toString();
				relationship = "CANCEL";
				break;
			case BARGAIN:
				subjectID = "COUNTRY" + i.toString();
				objectID = "COUNTRY" + ((Integer) rand).toString();
				relationship = "BARGAIN";
				break;
			}
			
			// generate queries
			addBatch(ID, subjectID, objectID, relationship, timeID, articleID);
		}
	}
}
