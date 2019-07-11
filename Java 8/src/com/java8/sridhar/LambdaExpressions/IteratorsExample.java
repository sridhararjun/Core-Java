/**
 * 
 */
package com.java8.sridhar.LambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/**
 * @author Sribi
 *
 */
public class IteratorsExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> integersList = new ArrayList<Integer>();
		integersList.addAll(Arrays.asList(1,2,3,4,5,6,7,9,8,0));
		
		//external iterator
		for(int i=0;i<integersList.size();i++) {
			System.out.println(integersList.get(i));
		}
		
		Set<Integer> integersSet = new TreeSet<Integer>(integersList);
		System.out.println(integersSet);
		
		//external iterator also
		for(Integer i:integersList) {
			System.out.println(i);
		}
		
//		Iterator<Integer> iterator = Iterator.
		
		
/*//		Internal Iterators
//	The benefit of calling a function on an object rather than passing the object onto the function is
 * YOU GET THE BENEFITS OF POLYMORPHISM	
 * 
		*/
		integersList.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer value) {
				// TODO Auto-generated method stub
				System.out.println("-----------\n"+value);
			}
		});
//	Java 8 has type inference,but only for lambda expresssions
		integersList.forEach((value) -> System.out.println("-----------\n"+value));

//		Paranthesis is optional,but only for single parameter lambdas
		integersList.forEach(value -> System.out.println("-----------\n"+value));
		
		//Method reference used
		/*Method references are useful only in the simplest ways
		 * Like if you just get and argument and pass it witout doing anything else
		 * and that's where method references are useful in place
		*/
//		It can be used for instance methods like PRINTLN
		integersList.forEach(System.out::println);
System.out.println("\n-----------------\n");
//it can also be used for static methods like VALUEOF
		integersList.stream()
//					.map(value -> String.valueOf(value))
					.map(String::valueOf)
					.forEach(value -> System.out.println(value));
		
		integersList.stream()
		.map(value -> String.valueOf(value))
		
//		.map(value -> value.toString())
		
/*		Here value is of type String.So we have written the method reference like below.
		And also here the target is the variable,since the method is called on the variable,
		rather than passing the variable to a function*/

		.map(String::toString)
		.forEach(value -> System.out.println(value));

/* METHOD REFERENCES FOR TWO ARGUMENTS		
*/		
		
		integersList.stream()
					.reduce(0, (total,e) -> Integer.sum(total, e));
		
		Integer sum = integersList.stream()	
					.reduce(0, new BinaryOperator<Integer>() {

						@Override
						public Integer apply(Integer t, Integer u) {
							// TODO Auto-generated method stub
							return Integer.sum(t, u);
						}
					});
		System.out.println(sum);
		integersList.stream()
					.reduce(0, (total,e) -> Integer.sum(total, e));
//		This can be written as 
		integersList.stream()
					.reduce(0, Integer::sum);
	}

}
