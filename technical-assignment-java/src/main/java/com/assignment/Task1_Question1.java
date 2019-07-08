package com.assignment;

//Task 1 Question 1: How many males are in the address book ?

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1_Question1 {
	private String field;

	//Getter
	public String getField() {
		return field;
	}
	
	//Setter
	public void setField(String newName) {
		this.field = newName;
	}
	
	//count the number of males 
	public int countField(){
		int countMale=0;
			
		try (FileReader reader = new FileReader("src/main/resources/AddressBook");
	        		
			BufferedReader br = new BufferedReader(reader)) {

	        // read line by line
			String line;
			while ((line = br.readLine()) != null) {
				String arr[] = line.split(","); 
	                  	               	
				for (String temp: arr){
					temp = temp.trim();
					
					if(temp.equals(field)){
						countMale = countMale + 1;
					}
				}
			}           
        } catch (IOException e) {
        	System.err.format("IOException: %s%n", e);
        }
		return countMale;
	}
		
    public static void main(String[] args) {
    	Task1_Question1 obj = new Task1_Question1();
	    obj.setField("Male");
	    	
	    System.out.println("TOTAL NUMBER OF MALES : "+obj.countField());
    }
}