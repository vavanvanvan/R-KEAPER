package mysqlapp.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vavano.Spisok;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataBaseSpisok {
	
	private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "spisok";
    private final String LOGIN = "root"; 
    private final String PASS = "679204@Vovan";
    
    private Connection connection = null;
    private PreparedStatement preparedStatement;
    
    private Connection getConnection() throws SQLException, ClassNotFoundException{
    	
    	String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(connStr, LOGIN, PASS);      
		return connection;
    	
    }
    // create table in BD
    public void insertTable() throws ClassNotFoundException, SQLException {
    	String table = "create table if not exists SpisokTable ( id int auto_increment primary key,"
    			+ "name varchar(20) not null, age int not null)";
    	preparedStatement = getConnection().prepareStatement(table);
    	preparedStatement.executeUpdate();
    	System.out.println("Created Table.........");
    	
    }
    //add object task in BD
    public void insertTask(Spisok spisok) throws ClassNotFoundException, SQLException {
    	String task = "insert into SpisokTable(name, age) values(?,?)";
    	preparedStatement = getConnection().prepareStatement(task);
    	preparedStatement.setString(1, spisok.getName());
    	preparedStatement.setInt(2, spisok.getAge());
    	preparedStatement.executeUpdate();
    }
    //void for data show
    public ObservableList<Spisok> showSpisok() throws SQLException, ClassNotFoundException{
    	
    	Statement statement = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    			ResultSet.CONCUR_READ_ONLY);
    	String str = "select*from SpisokTable";   	
    	ObservableList<Spisok> items = FXCollections.observableArrayList();
    	ResultSet res = statement.executeQuery(str);
    	
    	while(res.next()) {
    		Spisok spisok = new Spisok();
    		spisok.setName(res.getString(2));
    		spisok.setAge(res.getInt(3));
    		items.add(spisok);    		
    	}    	
    	for(Spisok s : items)
    		System.out.println(s + "DataBase");    	
		return items;
		
    }
    // ********************************************************************************************
    
    public void insertTableStol() throws ClassNotFoundException, SQLException {
    	String table = "create table if not exists stolname ( id int auto_increment primary key,"
    			+ "name varchar(20) not null)";
    	preparedStatement = getConnection().prepareStatement(table);
    	preparedStatement.executeUpdate();
    	
    	System.out.println("Created stolname...");
    	
    }
    
    public void insertTaskStol(String str) throws ClassNotFoundException, SQLException{
    	
    	String task = "insert into stolname(name) value(?)";
    	preparedStatement = getConnection().prepareStatement(task);
    	preparedStatement.setString(1, str);
    	preparedStatement.executeUpdate();
    	System.out.println(str + " eto bd");
    }

}

