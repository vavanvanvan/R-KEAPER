package com.vavano;

import java.io.IOException;
import java.io.InputStream;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Stol {
	
	private static Label lb;
	private ImageView img;
	private int id;
	private Parent root;
	
	public Label lbShow() {
	
	lb = new Label(String.valueOf(id), imageMethod());
	lb.setContentDisplay(ContentDisplay.TOP);
	
	lb.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			img.setOpacity(0.3);
			System.out.println("Img clicked nomer " + id);
			try {
				root = FXMLLoader.load(FxTest.class.getResource("/resources/xml/pulpitmain.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(root, 400, 400));
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.show();
			}
			catch(IOException e){
				System.out.println("Exception in borderButton");
			}
		}
	});
	lb.setOnMouseEntered(EventHandler -> img.setOpacity(0.7));
	lb.setOnMouseExited(EventHandler -> img.setOpacity(1));
	
	return lb;
	
	}
	
	public ImageView imageMethod (){
		InputStream icon = getClass().getResourceAsStream("/resources/images/kub.png");
		Image image = new Image(icon);
		img = new ImageView();
		img.setImage(image);
				
		return img;

	}
	public void setId(int id) {
		this.id = id;
	}

}
