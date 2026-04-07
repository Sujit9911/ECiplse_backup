package com.collection;
import java.util.ArrayList;


public class Sir {
	void give() {
		Studdata s=new Studdata();
		ArrayList<Data>list=s.studinfo();
		for(Data data:list) {
			if(data.getName().startsWith("s")){
			System.out.println(data.getRollno());
			}}
		}
	

	public static void main(String[] args) {
		Sir g=new Sir();
		g.give();

	}

}
