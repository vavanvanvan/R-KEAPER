package mysqlapp.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseStol {
	
	private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "stol";
    private final String LOGIN = "root"; 
    private final String PASS = "679204@Vovan";
    
    private Connection connection = null;
    private PreparedStatement preparedStatement;
    DataBaseSpisok dbSpisok = new DataBaseSpisok();   
    
    private Connection getConnection() throws SQLException, ClassNotFoundException{
    	
    	try {
    	String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(connStr, LOGIN, PASS);
        System.out.println("Cnnection Stol");
		return connection;
    	}
		catch (SQLException e) {
			throw new RuntimeException("Cannot connect to Stol", e);
		}
    	
    }
    
    public void insertTable() throws ClassNotFoundException, SQLException{
    	
    	String table = "create table if not exists stolname2 ( id int auto_increment primary key,"
    			+ "name varchar(20) not null, age int)";
    	preparedStatement = getConnection().prepareStatement(table);
    	preparedStatement.executeUpdate();
    	System.out.println("stolname2 create");
    	getConnection().close();
    }
    
    public void insertTask(String str) throws ClassNotFoundException, SQLException{
    	
    	String task = "insert into stolname2 (name) value (?)";
    	preparedStatement = getConnection().prepareStatement(task);
    	preparedStatement.setString(1, str);
    	preparedStatement.executeUpdate();
    }

}
