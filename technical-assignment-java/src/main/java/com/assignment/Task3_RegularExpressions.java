package com.assignment;

import java.util.ArrayList;
import java.util.List;

public class Task3_RegularExpressions {
	public static void main(String[] args) {
		List<String> error = new ArrayList<String>();
		List<String> input = new ArrayList<String>();

		input.add("17000 EUR");
		input.add("1700 EUR");
//		input.add("£17000 EURO");
//		input.add("ABCDE EUR");
		input.add("0,85 EUR");


		for (String ssn : input) {
			if (ssn.matches("^[0-9]{1,9}\\s[E][U][R]$")){ //
				System.out.println("Greater than > 1 EURO : " + ssn);
				
			}else if(ssn.matches("^[0][,][0-9]{1,9}\\s[E][U][R]$")){
				System.out.println("Less Than < 1 EURO : " + ssn);
			}
			else{
				error.add(ssn);
			}
		}
		for(String obj: error){
			System.out.println("Values that cannot be matched : "+ obj);
		}
		
	}
}