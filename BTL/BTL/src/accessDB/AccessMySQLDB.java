package accessDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AccessMySQLDB implements AccessDB {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=utf-8";
	private static final String USER = "admin";
	private static final String PASS = "admin123";
	private Connection conn;
	private Statement stmt;
	
	
	public AccessMySQLDB() {
		conn = null;
		stmt = null;
	}
	
	@Override
	public void connectDB() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
	}
	
	@Override
	public void closeDB() throws SQLException {
		if(stmt != null) {
			stmt.close();
		}
		if(conn != null) {
			conn.close();
		}
	}
	
	@Override
	public ResultSet executeQuery(String sql) throws SQLException {
		return stmt.executeQuery(sql);
	}
	
	@Override
	public void executeBatch(String batch) throws SQLException {
		stmt.addBatch(batch);
		stmt.executeBatch();
		stmt.clearBatch();
	}
	
	@Override
	public void executeBatch(String relativePath, boolean isExecutingEveryQuery) throws SQLException, FileNotFoundException {
		File file = new File(relativePath);
		Scanner sc = null;
		sc= new Scanner(file);
		sc.useDelimiter(";");
		
		if (isExecutingEveryQuery) {
			long start = 0, end = 0;
			int i = 0;
			while(sc.hasNext()) {
				start = System.currentTimeMillis();
				
				i++;
				stmt.execute(sc.next() + ";");
				
				end = System.currentTimeMillis();
				System.out.println("- Query " + i + " ... complete in: " + (end - start));
			}
		} else {
			while(sc.hasNext()) {
				stmt.addBatch(sc.next() + ";");
				stmt.executeBatch();
				stmt.clearBatch();
			}
		}
		
		sc.close();
	}
}
