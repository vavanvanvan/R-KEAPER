package mysqlapp.business;

public enum MenuList {
	CHIKEN ("Kurica"),
	PORK ("Svinina"),
	BEEF ("Goviadina");
	
	private String title;
	
	MenuList(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	public String toString() {
		return "MenuList + title = " + title + "\n";
	}

}
