package beans.virtualbeans;

import java.util.ArrayList;
import java.util.Random;

public class VirtualDateTime {
	private String ID;
	private String name;
	private String description;
	private ArrayList<String> arrDateTime;
	private String dateTime;
	private Random random;
	private StringBuilder dateTimeSB;
	
	public VirtualDateTime() {
		arrDateTime = new ArrayList<String>();
		dateTimeSB = new StringBuilder("insert into DATETIME (ID, name, description, dateTime) values ");
		random = new Random();
		
		// get paths of files
		String path = getClass().getResource("sampledata/datetime/dateTime.txt").getPath();
		
		// load data to lists
		LoadSampleData.loadData(path, arrDateTime);
	}
	
	public String getBatch() {
		dateTimeSB.setLength(dateTimeSB.length() - 1);
		dateTimeSB.append(";");
		return dateTimeSB.toString();
	}
	
	public void addBatch(String ID, String name, String description, String dateTime) {
		String str = "('" + ID + "', N'" + name + "', N'" + description + "', '" + dateTime + "'),";
		dateTimeSB.append(str);
	}
	
	public void generate(int numberOfRecords) {
		int randDateTime = 0;
		int arrDateTimeLength = arrDateTime.size();
		for (Integer i = 0; i < numberOfRecords; i++) {
			randDateTime = random.nextInt(arrDateTimeLength);
			
			// set attributes for DateTime
			dateTime = arrDateTime.get(randDateTime);
			ID = "DATETIME" + i.toString();
			name = dateTime;
			description = dateTime;
			
			// generating queries
			addBatch(ID, name, description, dateTime);
		}
	}
}
