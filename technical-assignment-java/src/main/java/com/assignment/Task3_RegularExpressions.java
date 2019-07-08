package com.assignment;

import java.util.ArrayList;
import java.util.List;

public class Task3_RegularExpressions {
	public static void main(String[] args) {
		List<String> error = new ArrayList<String>();
		List<String> input = new ArrayList<String>();
//		input.add("BWI0520BG6");
//		input.add("DAZ3029XA0");
//		input.add("UES915*GS5");
//		input.add("SJD8|75RZ4");
//		input.add("YMH6360YP0");
		input.add("17000 EUR");
		input.add("1700 EUR");
		input.add("£17000 EURO");
		input.add("ABCDE EUR");
		input.add("0,85 EUR");


		for (String ssn : input) {
//			if (ssn.matches("^[A-Z]{3}[0-9]{4}[A-Z]{2}[0-9]{1}$")) {//"^(\\d{3}-?\\d{2}-?\\d{4})$"
			if (ssn.matches("^[0-9]{1,9}\\s[E][U][R]$")){ //
				System.out.println("Found good SSN: " + ssn);
				
			}else if(ssn.matches("^[0][,][0-9]{1,9}\\s[E][U][R]$")){
				System.out.println("Found good SSN: " + ssn);
			}
			else{
				error.add(ssn);
			}
		}
		for(String obj: error){
			System.out.println(obj);
		}
		
	}
}