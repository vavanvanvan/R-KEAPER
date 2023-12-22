package com.vavano;

public class DataSingleton {
	
	private DataSingleton() {
		
	}	
	private static class SingletonHolder{
		public static final DataSingleton HOLDER_INSTANCE = new DataSingleton();
	}
	public static DataSingleton getInstance() {
		return SingletonHolder.HOLDER_INSTANCE;
	}
	
	private MainSceneController mainController;
	private SpisokController spisokController;
	
	public MainSceneController getMainController() {
		return mainController;
	}
	public void setMainController(MainSceneController mainController) {
		this.mainController = mainController;
	}
	public SpisokController getSpisokController() {
		return spisokController;
	}
	public void setSpisokController(SpisokController spisokController) {
		this.spisokController = spisokController;
	}

}
