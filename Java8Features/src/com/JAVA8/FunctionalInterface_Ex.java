package com.JAVA8;

@FunctionalInterface
interface Greeting
{
	void greet();
	//void run();
	
}
 
public class FunctionalInterface_Ex {
 
	public static void main(String[] args) {
     
		
		Greeting g= ()->System.out.println("good Mrng");
		g.greet();
	}
 
}
