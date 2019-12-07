package beans.virtualbeans;

import java.util.ArrayList;
import java.util.Random;

public class VirtualLocation {
	private String ID;
	private ArrayList<String> arrName;
	private String name;
	private ArrayList<String> arrDescription;
	private String description;
	private ArrayList<String> arrCoordinate;
	private String coordinate;
	private String countryID;
	private Random random;
	private StringBuilder locationSB;
	
	public VirtualLocation() {
		arrName = new ArrayList<String>();
		arrDescription = new ArrayList<String>();
		arrCoordinate = new ArrayList<String>();
		random = new Random();
		locationSB = new StringBuilder("insert into LOCATION (ID, name, description, coordinate, countryID) values ");
		
		// get paths of files
		String namePath = getClass().getResource("sampledata/location/name.txt").getPath();
		String descriptionPath = getClass().getResource("sampledata/location/name.txt").getPath();
		String coordinatePath = getClass().getResource("sampledata/location/coordinate.txt").getPath();
		
		// load data to lists
		LoadSampleData.loadData(namePath, arrName);
		LoadSampleData.loadData(descriptionPath, arrDescription);
		LoadSampleData.loadData(coordinatePath, arrCoordinate);
	}
	
	public String getBatch () {
		locationSB.setLength(locationSB.length() - 1);
		locationSB.append(";");
		return locationSB.toString();
	}
	
	public void addBatch(String ID, String name, String description, String coordinate, String countryID) {
		String str = "('" + ID + "', N'" + name + "', N'" + description + "', N'" + coordinate + "', '" + countryID + "'),";
		locationSB.append(str);
	}
	
	public void generate(int numberOfRecords) {
		int randName = 0;
		int arrNameLength = arrName.size();
		int randDes = 0;
		int arrDesLength = arrDescription.size();
		int randCoor = 0;
		int arrCoorLength = arrCoordinate.size();
		
		for(Integer i = 0; i < numberOfRecords; i++) {
			// Random
			randName = random.nextInt(arrNameLength);
			randDes = random.nextInt(arrDesLength);
			randCoor = random.nextInt(arrCoorLength);
			
			// set attributes for Location
			name = arrName.get(randName);
			description = arrDescription.get(randDes);
			coordinate = arrCoordinate.get(randCoor);
			ID = "LOCATION" + i.toString();
			countryID = "COUNTRY" + i.toString();
			
			// generate queries
			addBatch(ID, name, description, coordinate, countryID);
		}
	}
}
