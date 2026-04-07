package com.contruct;


public class Product {
int productId;
String productName;
Double price;
int quantityInStock;

public Product(int productId, String productName, Double price, int quantityInStock) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.price = price;
	this.quantityInStock = quantityInStock;
}
Product(){
}
void Recevied() {
	quantityInStock=quantityInStock+1;
}
	
void Deliverd() {
quantityInStock=quantityInStock-1;
		
	}

void show() {
	System.out.println("Productid="+productId);
	System.out.println("ProductName="+productName);
	System.out.println("Price="+price);
	System.out.println("Current Stock="+quantityInStock);
	
	
}
public static void main(String[] args) {
	Product product0=new Product();
	Product product1=new Product(1,"book",55.55,20);
	
	product0.Deliverd();
	product0.show();
	System.out.println("********************************");
	
	product1.Recevied();
	product1.show();
}
}
