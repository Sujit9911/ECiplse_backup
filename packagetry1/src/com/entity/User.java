package com.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
private String profile;
private String email;
private int salary;
private int age;
private int experience;
private LocalDateTime dateOfCreation;
private LocalDateTime getDateOfModification;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getProfile() {
	return profile;
}
public void setProfile(String profile) {
	this.profile = profile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}
public LocalDateTime getDateOfCreation() {
	return dateOfCreation;
}
public void setDateOfCreation(LocalDateTime dateOfCreation) {
	this.dateOfCreation = dateOfCreation;
}
public LocalDateTime getGetDateOfModification() {
	return getDateOfModification;
}
public void setGetDateOfModification(LocalDateTime getDateOfModification) {
	this.getDateOfModification = getDateOfModification;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", profile=" + profile + ", email=" + email + ", salary=" + salary
			+ ", age=" + age + ", experience=" + experience + ", dateOfCreation=" + dateOfCreation
			+ ", getDateOfModification=" + getDateOfModification + ", getId()=" + getId() + ", getName()=" + getName()
			+ ", getProfile()=" + getProfile() + ", getEmail()=" + getEmail() + ", getSalary()=" + getSalary()
			+ ", getAge()=" + getAge() + ", getExperience()=" + getExperience() + ", getDateOfCreation()="
			+ getDateOfCreation() + ", getGetDateOfModification()=" + getGetDateOfModification() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}



}
