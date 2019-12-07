package beans.virtualbeans;

import java.util.ArrayList;
import java.util.Random;

public class VirtualCountry {
	private String ID;
	private ArrayList<String> arrName;
	private String name;
	private ArrayList<String> arrDescription;
	private String description;
	private ArrayList<String> arrPopulation;
	private String population;
	private ArrayList<String> arrOfficialLanguage;
	private String officialLanguage;
	private Random random;
	private StringBuilder countrySB;
	
	public VirtualCountry() {
		arrName = new ArrayList<String>();
		arrDescription = new ArrayList<String>();
		arrPopulation = new ArrayList<String>();
		arrOfficialLanguage = new ArrayList<String>();
		random = new Random();
		countrySB = new StringBuilder("insert into COUNTRY (ID, name, description, population, officialLanguage) values ");
		
		// get paths of files
		String namePath = getClass().getResource("sampledata/country/name.txt").getPath();
		String descriptionPath = getClass().getResource("sampledata/country/description.txt").getPath();
		String officialLanguagePath = getClass().getResource("sampledata/country/officialLanguage.txt").getPath();
		String populationPath = getClass().getResource("sampledata/country/population.txt").getPath();
		
		// load data to lists
		LoadSampleData.loadData(namePath, arrName);
		LoadSampleData.loadData(descriptionPath, arrDescription);
		LoadSampleData.loadData(officialLanguagePath, arrOfficialLanguage);
		LoadSampleData.loadData(populationPath, arrPopulation);
	}
	
	public String getBatch() {
		countrySB.setLength(countrySB.length() - 1);
		countrySB.append(";");
		return countrySB.toString();
	}
	
	public void addBatch(String ID, String name, String description, String population, String officialLanguage) {
		String str = "('" + ID + "', N'" + name + "', N'" + description + "', " + population + ", N'" + officialLanguage + "') ,";
		countrySB.append(str);
	}
	
	public void generate(int numberOfRecords) {
		int randName = 0;
		int arrNameLength = arrName.size();
		int randDes = 0;
		int arrDesLength = arrDescription.size();
		int randPop = 0;
		int arrPopLength = arrPopulation.size();
		int randOffLang = 0;
		int arrOffLangLength = arrOfficialLanguage.size();
		for(Integer i = 0; i < numberOfRecords; i++) {
			// Random
			randName = random.nextInt(arrNameLength);
			randDes = random.nextInt(arrDesLength);
			randPop = random.nextInt(arrPopLength);
			randOffLang = random.nextInt(arrOffLangLength);
			
			// set attributes for Country
			name = arrName.get(randName);
			description = arrDescription.get(randDes);
			population = arrPopulation.get(randPop);
			officialLanguage = arrOfficialLanguage.get(randOffLang);
			ID = "COUNTRY" + i.toString();
			
			// generating queries
			addBatch(ID, name, description, population, officialLanguage);
		}
	}
	
}
