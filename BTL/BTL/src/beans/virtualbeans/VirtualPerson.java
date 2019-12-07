package beans.virtualbeans;

import java.util.ArrayList;
import java.util.Random;

public class VirtualPerson {
	private String ID;
	private ArrayList<String> arrName;
	private String name;
	private ArrayList<String> arrDescription;
	private String description;
	private String gender;
	private String countryID;
	private String dateOfBirthID;
	private Random random;
	private StringBuilder personSB;
	
	public VirtualPerson() {
		arrName = new ArrayList<String>();
		arrDescription = new ArrayList<String>();
		random = new Random();
		personSB = new StringBuilder("insert into PERSON (ID, name, description, gender, countryID, dateOfBirthID) values ");
		
		// get paths of files
		String namePath = getClass().getResource("sampledata/person/name.txt").getPath();
		String descriptionPath = getClass().getResource("sampledata/person/description.txt").getPath();
		
		// load data to lists
		LoadSampleData.loadData(namePath, arrName);
		LoadSampleData.loadData(descriptionPath, arrDescription);
	}
	
	public String getBatch() {
		personSB.setLength(personSB.length() - 1);
		personSB.append(";");
		return personSB.toString();
	}
	
	public void addBatch(String ID, String  name, String description, String gender, String countryID, String dateOfBirthID) {
		personSB.append("('" + ID + "', N'" + name + "', N'" + description + "', " + gender + ", '" + countryID + "', '" + dateOfBirthID + "'),");
	}
	
	public void generate(int numberOfRecords) {
		int randName = 0;
		int arrNameLength = arrName.size();
		int randDes = 0;
		int arrDesLength = arrDescription.size();
		int randGen = 0;
		for(Integer i = 0; i < numberOfRecords; i++) {
			// Random
			randName = random.nextInt(arrNameLength);
			randDes = random.nextInt(arrDesLength);
			randGen = random.nextInt(2);
			
			// set attributes for Person
			name = arrName.get(randName);
			description = arrDescription.get(randDes);
			ID = "PERSON" + i.toString();
			gender = ((Integer) randGen).toString();
			countryID = "COUNTRY" + i.toString();
			dateOfBirthID = "DATETIME" + i.toString();
			
			// generate queries
			addBatch(ID, name, description, gender, countryID, dateOfBirthID);
		}
	}
}
