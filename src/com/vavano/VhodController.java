package com.vavano;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import mysqlapp.business.DataBaseSpisok;
import mysqlapp.business.DataBaseStol;

public class VhodController implements Initializable{
	
	@FXML
	private PasswordField passField;
	@FXML
	private Button vhodBtn;
	@FXML
	private Text vhodText;
	@FXML
	private TextField passText, dbText;
	@FXML
	private CheckBox checkBox;
	@FXML
	private ImageView imageView;
	@FXML
	private StackPane stackPane;
	@FXML
	private HBox hBox;
	
	DataBaseSpisok dbSpisok;
	DataBaseStol dbStol;

	static int pas = 0;
	private static String str;
	
	
	@FXML
	private void vhodBtnAction() throws IOException, ClassNotFoundException, SQLException {
		
		str = dbText.getText();
		System.out.println("Stol " + str);
		dbSpisok.insertTaskStol(str);
		dbStol.insertTask(str);
		
				
/*		if(passField.getText().equals("Tataniko")) {
			FxTest.setRoot("/resources/xml/main.fxml");
		} else if(pas > 0 && pas <=3) {
			vhodText.setText("Baranichiko!!!");
			pas++;
		} else if(pas > 3)vhodText.setText("Mega Baranichiko!!!");
		else{			
			vhodText.setText("Enter a Pasword");	
			pas++;			
		}		
*/	
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		dbStol = new DataBaseStol();
		dbSpisok = new DataBaseSpisok();
		
		
		try {
			dbSpisok.insertTableStol();
			dbStol.insertTable();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
// Sviazivanie Text + paswordField dla otobrazenia pri vvode parolya		
		passField.textProperty().bindBidirectional(passText.textProperty());
		StackPane.setAlignment(imageView, Pos.CENTER_RIGHT);
		
		vhodBtn.setDefaultButton(true);
	
		checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
						
			if(newValue)
				passText.toFront();
			else {
				passField.toFront();
				imageView.toFront();
			}	
		});
		imageView.setOnMousePressed((event) -> {
			passText.toFront();
			imageView.setImage(new Image("/resources/images/eye-pass.png"));
			imageView.toFront();
			
		});
		imageView.setOnMouseReleased((event) -> {
			imageView.setImage(new Image("/resources/images/eye-no-pass.png"));
			passField.toFront();
			imageView.toFront();
		});
		
		
	}

}
