package com.drew.firstproject;

public class User {
	private String name;
	private String hairColor;
	private int age;
	private int height;
	
	//Constructor
	public Human(String name, String hairColor, int age, int height) {
		this.name = name;
		this.hairColor = hairColor;
		this.age = age;
		this.height = height;
	}
	//Methods
	public void sayHello() {
		System.out.println("Hello my name is "+ this.name);
	}
	
	//Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


}
