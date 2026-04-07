package hiberanatetask1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Studentdetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int student_id;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	private String first_name;
	private String last_name;
	private int age;
	private String city;
	private String phone_number;
	@Override
	public String toString() {
		return "Studentdetails [student_id=" + student_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", age=" + age + ", city=" + city + ", phone_number=" + phone_number + ", getStudent_id()="
				+ getStudent_id() + ", getFirst_name()=" + getFirst_name() + ", getLast_name()=" + getLast_name()
				+ ", getAge()=" + getAge() + ", getCity()=" + getCity() + ", getPhone_number()=" + getPhone_number()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
