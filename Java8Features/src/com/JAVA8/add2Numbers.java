package com.JAVA8;

interface Add2Numbers
{
	static int add(int a,int b)
	{
		return a+b;
	}
}
 
public class add2Numbers {
 
	public static void main(String[] args) {
	int result=	Add2Numbers.add(3, 5);
		System.out.print(result);
	}
 
}