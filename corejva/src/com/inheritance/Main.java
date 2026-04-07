package com.inheritance;

public class Main {

	public static void main(String[] args) {
		System.out.println("-----------ELECTRONICS---------");
		Electronics E1=new Electronics();
		E1.name="MOUSE";
		E1.description="Wired";
		E1.price=500.00;
		E1.warrantyPeriod="1year";
		E1.brand="Logitech";
		E1.displayinfo();
		E1.calculateDiscount(100.00);
		
		System.out.println("-----------Clothing---------");
		Clothing c1=new Clothing();
		c1.name="Tshirt";
		c1.description="Baggy";
		c1.price=1000.00;
		c1.size=28;
		c1.color="White";
		c1.material="Cotton";
		c1.displayinfo();
		c1.calculateDiscount(200.00);
		

	}

}
