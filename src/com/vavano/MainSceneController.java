package com.vavano;

import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import mysqlapp.business.DataBaseSpisok;

public class MainSceneController{
	
	
	DataBaseSpisok dbSpisok;
	
	//Getting SpisokController frue DataSingleton class
	SpisokController spisokController = DataSingleton.getInstance().getSpisokController();
	
	ObservableList<String> items = FXCollections.observableArrayList();
	ObservableList<Spisok> items2 = FXCollections.observableArrayList();
	
	ListView<String> list = new ListView<>();
	ListView<Spisok> list2 = new ListView<>();

	@FXML
	private TilePane tilpane;
	@FXML
	private Button btn, btnSpisok;
	@FXML
	private Label lb1, lb2, kuchnya, bar;
	@FXML
	private VBox mainVBox, scrollBox; 
	
	@FXML
	private void btnClicked(ActionEvent event) throws IOException{
		
		if(event.getSource() == btn) {
					
			System.out.println("Btn cklicked");
			FxTest.setRoot("/resources/xml/second.fxml");
		}
		else if (event.getSource() == btnSpisok) {
			
/*			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/xml/spisok.fxml"));
			Stage stage = new Stage();
			stage.initOwner(btn.getScene().getWindow());
			stage.setScene(new Scene((Parent) loader.load()));
			stage.showAndWait();
*/			FxTest.setRoot("/resources/xml/spisok.fxml");
		}
	}
	
	public void listItemView() {
		char c = 'a';
		for(int i = 0; i < 20; i++) {
			items.add(String.valueOf(c));
			c++;				
		}
		list.setItems(items);
		scrollBox.getChildren().addAll(list);		
		
	}
	
	
	@FXML
	public void initialize() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(3);
		dropShadow.setOffsetY(3);
		dropShadow.setColor(Color.GRAY);
		tilpane.setEffect(dropShadow);
		
		kuchnya.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("URRR!!!");
			}		
		});
		shadow(kuchnya);
		bar.setOnMouseClicked(EventHandler -> System.out.println("POL!!!!"));
		shadow(bar);
				
		dbSpisok = new DataBaseSpisok();
		dbSpisok.insertTable();
		scrollBox.getChildren().clear();
		System.out.println("Initialize......");
		
		items2 =  dbSpisok.showSpisok();
		if(items2 == null)
			return;
				
		for(Spisok s : items2)
			System.out.println(s + " Main ");
				
				list2.setItems(items2);
				scrollBox.getChildren().add(list2);
				list2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
				
			MultipleSelectionModel<Spisok> select = list2.getSelectionModel();			
			select.selectedItemProperty().addListener(ChangeListener -> {
							String setItems = " ";
							for(Spisok s : select.getSelectedItems()) {
								setItems += s;
							}
							System.out.println(setItems);
							});

			
		//Register controller in DataSinglton class
		DataSingleton.getInstance().setMainController(this);
		listItemView();			

	}
	public void shadow(Label lb) {
		lb.setOnMouseEntered(EventHandler -> lb.setOpacity(0.7));
		lb.setOnMouseExited(EventHandler -> lb.setOpacity(1));
	}
	
}
