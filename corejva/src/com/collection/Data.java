package com.collection;

public class Data {

	private String name;
	private String city;
	private String course;
	private int rollno;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}@Override
	public String toString() {
		return "Data [name=" + name + ", city=" + city + ", course=" + course + ", rollno=" + rollno + "]";
	
	
	}}

