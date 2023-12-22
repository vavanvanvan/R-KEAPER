package com.vavano;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SecondSceneController {
	
	@FXML
	private Label inputLbl, outputLbl;
	@FXML
	private Button okBtn;
	@FXML
	private TextArea outputText;
	@FXML 
	private TextField inputText;
	
	@FXML 
	private void btnClicked() throws IOException {

		FxTest.setRoot("/resources/xml/border.fxml");

	}

}
