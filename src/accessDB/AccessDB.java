package accessDB;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface AccessDB {
	public void connectDB() throws ClassNotFoundException, SQLException;
	public abstract void closeDB() throws SQLException;
	public abstract void executeBatch(String batch) throws SQLException;
	public abstract void executeBatch(String relativePath, boolean isExecutingEveryQuery) throws SQLException, FileNotFoundException;
	public abstract ResultSet executeQuery(String sql) throws SQLException;
}
