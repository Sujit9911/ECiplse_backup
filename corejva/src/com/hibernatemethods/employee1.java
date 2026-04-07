package com.hibernatemethods;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Entity
public class employee1 {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id ;
	private String name;
	private String city;
	private String pos;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	@Override
	public String toString() {
		return "employee1 [id=" + id + ", name=" + name + ", city=" + city + ", pos=" + pos + "]";
	}
	

}
