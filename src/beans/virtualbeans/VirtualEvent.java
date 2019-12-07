package beans.virtualbeans;

import java.util.ArrayList;
import java.util.Random;

public class VirtualEvent {
	private String ID;
	private ArrayList<String> arrName;
	private String name;
	private ArrayList<String> arrDescription;
	private String description;
	private String startTimeID;
	private String endTimeID;
	private String locationID;
	private Random random;
	private StringBuilder eventSB;
	
	public VirtualEvent() {
		arrName = new ArrayList<String>();
		arrDescription = new ArrayList<String>();
		random = new Random();
		eventSB = new StringBuilder("insert into EVENT (ID, name, description, startTimeID, endTimeID, locationID) values ");
		
		// get paths of files
		String namePath = getClass().getResource("sampledata/event/name.txt").getPath();
		String descriptionPath = getClass().getResource("sampledata/event/description.txt").getPath();
		
		// load data to lists
		LoadSampleData.loadData(namePath, arrName);
		LoadSampleData.loadData(descriptionPath, arrDescription);
	}
	
	public String getBatch() {
		eventSB.setLength(eventSB.length() - 1);
		eventSB.append(";");
		return eventSB.toString();
	}
	
	public void addBatch(String ID, String name, String description, String startTimeID, String endTimeID, String locationID) {
		eventSB.append("('" + ID + "', N'" + name + "', N'" + description + "', '" + startTimeID + "', '" + endTimeID + "', '" + locationID + "'),");
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
			startTimeID = "DATETIME" + i.toString();
			endTimeID = "DATETIME" + i.toString();
			locationID = "LOCATION" + i.toString();
			
			// generate queries
			addBatch(ID, name, description, startTimeID, endTimeID, locationID);
		}
	}
}
