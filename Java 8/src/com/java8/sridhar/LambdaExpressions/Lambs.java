package com.java8.sridhar.LambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list =Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(list);
		System.out.println("Ascending \n"+list);
		Collections.sort(list, new Sorter());
		System.out.println(list);
	}

}
