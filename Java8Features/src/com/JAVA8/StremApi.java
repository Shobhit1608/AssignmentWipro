package com.JAVA8;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
 
public class StremApi {
 
	public static void main(String[] args) {
		
		List<Integer> nums=Arrays.asList(4,5,6,1,0,7,15);
		//creating stream
		Stream<Integer> data=nums.stream();
		
//		Stream<Integer> s1=nums.stream()
//				.filter(n->n%2==1)
//		       .sorted()
//	           .map(n->n*4);
		int finalResult =nums.stream()
				.filter(n->n%2==1)
		       .sorted()
	           .map(n->n*4)
	           .reduce(0,(x,y)->x+y);
		System.out.println(finalResult);
//		s1.forEach(n->System.out.println(n));
		//3 stream
				//creating stream
//				nums.stream()
//						.sorted()
//						.map(n->n*4)
//						.forEach(n->System.out.println(n));
		//count fucntion
		 //Long countElements=  data.count();
		// System.out.println(countElements);
		
		 Stream<Integer> sortedStream = data.sorted();
		 sortedStream.forEach(n->System.out.println(n));
		
		 System.out.println(sortedStream);
		//consuming
	   //data.forEach(n->System.out.println(n));
		
	  //data.forEach(n->System.out.println(n));
		 //mapfunction
		Stream<Integer> mappedvalues=data.map(n->n*5);
		mappedvalues.forEach(n->System.out.println(n));
	   
	
	}
 
}
 