package com.vavano;

public class Spisok {
	
	private String name;
	private  int age;
	
	public Spisok(String name, int age){
		this.name = name;
		this.age = age;
		toString();
	}
	public Spisok(){
		toString();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "Name " + getName() + " Age vozvrast " + getAge();
	}

}
