package com.drew.projectclass;

public class ProjectTest {

	public static void main(String[] args) {
		Project first = new Project("Title", "Desc");
		System.out.println(first.getName());
		first.setDescription("This is one cool description");
		System.out.println(first.getDescription());
	}

}
