package com.student;



public class Student {
int studentId;
String name;
String course;
double marks;

Student(){
	this. name="Unknown";
	this. course="Not Assigned";
	
}

Student(int studentId, String name, String course, double marks) {
	super();
	this.studentId = studentId;
	this.name = name;
	this.course = course;
	this.marks = marks;
}

void show() {
	System.out.println("********STUDENT RECORD SYSTEM***********");
	System.out.println("Name="+name);
	System.out.println("ID="+studentId);
	System.out.println("Course="+course);
	System.out.println("Marks="+marks);
}
public static void main (String[] args) {
	Student student1=new Student();
	student1.show();
	
	Student student2=new Student(12,"sujit","java",100.00);
	student2.show();
	
	
}
}
