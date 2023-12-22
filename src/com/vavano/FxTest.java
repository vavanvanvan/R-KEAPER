package com.vavano;


import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mysqlapp.business.MenuList;

public class FxTest extends Application{
	
	private static Scene scene;
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub	
		
		InputStream icon = getClass().getResourceAsStream("/resources/images/bat.png");
		Image image = new Image(icon);
		stage.getIcons().add(image);
		
		stage.setTitle("TATANICHIKO");
		stage.setWidth(1200);
		stage.setHeight(900);	
		
		System.out.println(Arrays.toString(MenuList.values()));
		System.out.println(MenuList.valueOf("CHIKEN"));
		
		scene = new Scene(loadFxml("/resources/xml/keaper.fxml"));
							
		stage.setScene(scene);
		stage.show();
	}
	
	static void setRoot(String fxml) throws IOException{
		
		scene.setRoot(loadFxml(fxml));
	}
	
	private static Parent loadFxml(String fxml) throws IOException{
		
		FXMLLoader fxmlLoader = new FXMLLoader(FxTest.class.getResource(fxml));
		return fxmlLoader.load();
		
	}
	

}
