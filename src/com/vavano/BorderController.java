package com.vavano;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class BorderController implements Initializable {
	
	@FXML private Label borderLabel;
	@FXML private Button borderBtn;
	@FXML private FlowPane tableAdd;
	
	Stol stol;
	
	Parent root;
	private static int id = 1;
	
	@FXML private void borderButtonClick() throws IOException {
		
/*		try {
			root = FXMLLoader.load(FxTest.class.getResource("/resources/xml/vhod.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene(root, 400, 400));	
			stage.showAndWait();
			stage.show();
		}
		catch(IOException e){
			System.out.println("Exception in borderButton");
		}
*/		
		stol = new Stol();
		stol.setId(id);
		id++;
		tableAdd.getChildren().add(stol.lbShow());
		
//		FxTest.setRoot("/resources/xml/border.fxml");

	}
					
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){	
		
	
	}

}
