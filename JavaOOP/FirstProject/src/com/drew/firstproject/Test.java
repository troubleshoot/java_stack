package com.drew.firstproject;


public class Test{
	
	public static void main(String[] args) {
		User joe = new User();
		joe.setName("Joe");
		System.out.println(joe.getName());
		joe.sayHello();
		System.out.println("Hello World!");

	}

}
