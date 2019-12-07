package application;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import accessDB.AccessDB;
import accessDB.AccessMySQLDB;
import beans.virtualbeans.*;

public class Runner {
	private final String initDBFilePath;
	private final String basicQueriesFilePath;
	private final String advancedQueriesFilePath;
	
	private AccessDB accessDB;
	private VirtualCountry country;
	private VirtualDateTime dateTime;
	private VirtualPerson person;
	private VirtualLocation location;
	private VirtualOrganization organization; 
	private VirtualAgreement agreement; 
	private VirtualEvent event ;
	private VirtualFact fact;
	private VirtualArticle article; 
	
	private long start;
	private long end;
	private int numberOfRecords;
	
	public Runner(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
		
		initDBFilePath = "src/accessDB/initDB.sql";
		basicQueriesFilePath = "src/accessDB/basicQueries.sql";
		advancedQueriesFilePath = "src/accessDB/advancedQueries.sql";
		
		accessDB = new AccessMySQLDB();
		country = new VirtualCountry();
		dateTime = new VirtualDateTime();
		person = new VirtualPerson();
		location = new VirtualLocation();
		organization =  new VirtualOrganization();
		agreement = new VirtualAgreement();
		event = new VirtualEvent();
		fact = new VirtualFact();
		article = new VirtualArticle();
	}
	
	private void initDB() throws FileNotFoundException, SQLException, ClassNotFoundException {
		start = System.currentTimeMillis();
		
		accessDB.connectDB();
		accessDB.executeBatch(initDBFilePath, false);
		
		end = System.currentTimeMillis();
		System.out.println("[#1] Connect to MySQL Server and create database ... complete in: " + (end - start));
	}
	
	private void generateData() {
		start = System.currentTimeMillis();
		
		country.generate(numberOfRecords);
		dateTime.generate(numberOfRecords);
		person.generate(numberOfRecords);
		location.generate(numberOfRecords);
		organization.generate(numberOfRecords);
		agreement.generate(numberOfRecords);
		event.generate(numberOfRecords);
		fact.generate(numberOfRecords);
		article.generate(numberOfRecords);
		
		end = System.currentTimeMillis();
		System.out.println("[#2] Create local data ... complete in: " + (end - start));
	}
	
	private void sendDataToDB() {
		start = System.currentTimeMillis();
		
		try {
			accessDB.executeBatch(country.getBatch());
			accessDB.executeBatch(dateTime.getBatch());
			accessDB.executeBatch(person.getBatch());
			accessDB.executeBatch(location.getBatch());
			accessDB.executeBatch(organization.getBatch());
			accessDB.executeBatch(agreement.getBatch());
			accessDB.executeBatch(event.getBatch());
			accessDB.executeBatch(article.getBatch());
			accessDB.executeBatch(fact.getBatch());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
		
		end = System.currentTimeMillis();
		System.out.println("[#3] Send virtual data to database ... complete in : " + (end - start));
	}
	
	public void run() {
		try {
			initDB();
			generateData();
			sendDataToDB();
			
			System.out.println("[#4] Basic Queries: ");
			queryDB(basicQueriesFilePath);
			System.out.println("[#5] Advanced Queries: ");
			queryDB(advancedQueriesFilePath);
			System.out.print("---------------------------------------------------\n\n");
			
			accessDB.closeDB();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void queryDB(String relativePath) throws FileNotFoundException, SQLException {
		accessDB.executeBatch(relativePath, true);
	}
}
