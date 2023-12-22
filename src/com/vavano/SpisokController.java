package com.vavano;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import mysqlapp.business.DataBaseSpisok;



public class SpisokController implements Initializable{
	
	private  String spisokname;
	private  int spisokage;
	
	Spisok spisok;
	MainSceneController mcontroller;
	
	@FXML
	private TextField spisokName, spisokAge;
	@FXML
	private Button btnConfirm;
	@FXML
	private Label worning;
	
	DataBaseSpisok dbSpisok;
	
	@FXML
	private void onClicked(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
			
		spisokname = spisokName.getText();
		spisokage = Integer.parseInt(spisokAge.getText());	
		
		spisok = new Spisok(spisokname, spisokage);
		dbSpisok.insertTask(spisok);
		
		System.out.println("Added to table: " + spisok.getName() + spisok.getAge());
		
	// Check that provided name	
		if(spisokname.matches(""))
			worning.setText("Insert Name!!!");
		else
//			btnConfirm.getScene().getWindow().hide();
			FxTest.setRoot("/resources/xml/main.fxml");
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbSpisok = new DataBaseSpisok();
		try {
			dbSpisok.insertTable();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mcontroller = DataSingleton.getInstance().getMainController();
		DataSingleton.getInstance().setSpisokController(this);
		
		spisokAge.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
	         public void handle( KeyEvent t ) {
	             char ar[] = t.getCharacter().toCharArray();
	             char ch = ar[t.getCharacter().toCharArray().length - 1];
	             if (!(ch >= '0' && ch <= '9')) {
	                System.out.println("The char you entered is not a number");
	                worning.setText("Please insert the number!!");
	                t.consume();
	             }
	          }
	       });
		spisokName.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
	         public void handle( KeyEvent t ) {
	             char ar[] = t.getCharacter().toCharArray();
	             char ch = ar[t.getCharacter().toCharArray().length - 1];
	             if (ch >= '0' && ch <= '9') {
	                System.out.println("The char you entered is not a number");
	                worning.setText("Please insert your real name!!");
	                t.consume();
	             }
	          }
	       });		
			
	}

}
