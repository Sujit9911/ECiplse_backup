package com.college;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int did;
	public int getDid() {
		return did;
	}



	public void setDid(int did) {
		this.did = did;
	}



	public String getDname() {
		return dname;
	}



	public void setDname(String dname) {
		this.dname = dname;
	}



	public Set<Student> getStudents() {
		return students;
	}



	public void setStudents(Set<Student> students) {
		this.students = students;
	}



	private String dname;
	
	
	
	@OneToMany(mappedBy="department")
	Set<Student> students;
}
