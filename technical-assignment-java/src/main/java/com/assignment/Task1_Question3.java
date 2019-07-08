package com.assignment;

//Task 1 Question 3: How many days older is Bill than Paul ?

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Task1_Question3 {
	// reads data from file and returns the age of the person
	public long getAgeFromFile(String name){
		long age=0;

		try (FileReader reader = new FileReader("src/main/resources/AddressBook");
				BufferedReader br = new BufferedReader(reader)) {

			// read line by line
			String line;
			while ((line = br.readLine()) != null) {
				String arr[] = line.split(","); 

				if(arr[0].equals(name)){
					age = Task1_Question2.calculateAge(Integer.parseInt(arr[2].substring(7, 9)), 
							Integer.parseInt(arr[2].substring(4, 6)), 
							Integer.parseInt(arr[2].substring(1, 3)));
				}        
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		return age;
	}
	
	public static void main(String[] args) {
		Task1_Question3 obj = new Task1_Question3();

		long age1=obj.getAgeFromFile("Bill McKnight");
		long age2=obj.getAgeFromFile("Paul Robinson");

		System.out.println("THE AGE DIFFERENCE IS : "+(age1-age2)+" DAYS");
	}
}
