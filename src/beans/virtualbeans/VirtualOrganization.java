package beans.virtualbeans;

import java.util.ArrayList;
import java.util.Random;

public class VirtualOrganization {
	private String ID;
	private ArrayList<String> arrName;
	private String name;
	private ArrayList<String> arrDescription;
	private String description;
	private String leaderID;
	private String locationID;
	private String foundationDateID;
	private Random random;
	private StringBuilder organizationSB;
	
	public VirtualOrganization() {
		arrName = new ArrayList<String>();
		arrDescription = new ArrayList<String>();
		random = new Random();
		organizationSB = new StringBuilder("insert into ORGANIZATION (ID, name, description, leaderID, locationID, foundationDateID) values ");
		
		// get paths of files
		String namePath = getClass().getResource("sampledata/organization/name.txt").getPath();
		String descriptionPath = getClass().getResource("sampledata/organization/description.txt").getPath();
		
		// load data to lists
		LoadSampleData.loadData(namePath, arrName);
		LoadSampleData.loadData(descriptionPath, arrDescription);
	}
	
	public String getBatch() {
		organizationSB.setLength(organizationSB.length() - 1);
		organizationSB.append(";");
		return organizationSB.toString();
	}
	
	public void addBatch(String ID, String name, String description, String leaderID, String locationID, String foundationDateID) {
		String str = "('" + ID + "', N'" + name + "', N'" + description + "', '" + leaderID + "', '" + locationID + "', '" + foundationDateID + "'),";
		organizationSB.append(str);
	}
	
	public void generate(int numberOfRecords) {
		int randName = 0;
		int arrNameLength = arrName.size();
		int randDes = 0;
		int arrDesLength = arrDescription.size();
		
		for(Integer i = 0; i < numberOfRecords; i++) {
			// random
			randName = random.nextInt(arrNameLength);
			randDes = random.nextInt(arrDesLength);
			
			// set attributes for Location
			name = arrName.get(randName);
			description = arrDescription.get(randDes);
			ID = "ORGANIZATION" + i.toString();
			leaderID = "PERSON" + i.toString();
			locationID = "LOCATION" + i.toString();
			foundationDateID = "DATETIME" + i.toString();
			
			// generate queries
			addBatch(ID, name, description, leaderID, locationID, foundationDateID);
		}
	}
}
