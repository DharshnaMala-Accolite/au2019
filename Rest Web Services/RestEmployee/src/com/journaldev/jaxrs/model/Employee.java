package com.journaldev.jaxrs.model;

import javax.xml.bind.annotation.XmlRootElement;
//Basic Employee object
@XmlRootElement (name="Employee")
public class Employee {
	private String name;
	private int age;
	private int id;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return "Id:"id+"-"+"Name:"+name+"-"+"Age:"+age;
	}

}
