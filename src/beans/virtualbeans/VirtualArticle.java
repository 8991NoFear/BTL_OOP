package beans.virtualbeans;

import java.util.ArrayList;
import java.util.Random;

public class VirtualArticle {
	private String ID;
	private ArrayList<String> arrLink;
	private String link;
	private Random random;
	private StringBuilder articleSB;
	
	public VirtualArticle() {
		arrLink = new ArrayList<String>();
		random = new Random();
		articleSB = new StringBuilder("insert into ARTICLE (ID, link) values");
		
		// get paths of files
		String linkPath = getClass().getResource("sampledata/article/link.txt").getPath();
		
		// load data to lists
		LoadSampleData.loadData(linkPath, arrLink);
	}
	
	public String getBatch() {
		articleSB.setLength(articleSB.length() - 1);
		articleSB.append(";");
		return articleSB.toString();
	}
	
	public void addBatch(String ID, String link) {
		articleSB.append("('" + ID + "', N'" + link + "'),");
	}
	
	public void generate(int numberOfRecords) {
		int rand = 0;
		int linkLength = arrLink.size();
		
		for(Integer i = 0; i < numberOfRecords; i++) {
			// random
			rand = random.nextInt(linkLength);
			
			// set attributes for article
			ID = "ARTICLE" + i.toString();
			link = arrLink.get(rand);
			
			// generate queries
			addBatch(ID, link);
		}
	}
}
