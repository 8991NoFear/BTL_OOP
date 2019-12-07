package beans.virtualbeans;

import java.util.ArrayList;
import java.util.Random;

public class VirtualAgreement  {
	private String ID;
	private ArrayList<String> arrName;
	private String name;
	private ArrayList<String> arrDescription;
	private String description;
	private String timeID;
	private String locationID;
	private Random random;
	private StringBuilder agreementSB;
	
	public VirtualAgreement() {
		arrName = new ArrayList<String>();
		arrDescription = new ArrayList<String>();
		random = new Random();
		agreementSB = new StringBuilder("insert into AGREEMENT (ID, name, description, timeID, locationID) values ");
		
		// get paths of files
		String namePath = getClass().getResource("sampledata/agreement/name.txt").getPath();
		String descriptionPath = getClass().getResource("sampledata/agreement/name.txt").getPath();
		
		// load data to lists
		LoadSampleData.loadData(namePath, arrName);
		LoadSampleData.loadData(descriptionPath, arrDescription);
	}
	
	public String getBatch() {
		agreementSB.setLength(agreementSB.length() - 1);
		agreementSB.append(";");
		return agreementSB.toString();
	}
	
	public void addBatch(String ID, String name, String description, String timeID, String locationID) {
		agreementSB.append("('" + ID + "', N'" + name + "', N'" + description + "', '" + timeID + "', '" + locationID + "'),");
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
			ID = "AGREEMENT" + i.toString();
			timeID = "DATETIME" + i.toString();
			locationID = "LOCATION" + i.toString();
			
			// generate queries
			addBatch(ID, name, description, timeID, locationID);
		}
	}
}
