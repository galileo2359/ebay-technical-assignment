package com.assignment;

//How many males are in the address book?

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1_Question1 {

	private String field;

	 // Getter
		 public String getField() {
		    return field;
		  }

		  // Setter
		  public void setField(String newName) {
		    this.field = newName;
		  }
		  
		public int countField(){
			int countMale=0;
	        try (FileReader reader = new FileReader("C:\\file\\AddressBook");
	                BufferedReader br = new BufferedReader(reader)) {

	               // read line by line
	               String line;
	               while ((line = br.readLine()) != null) {
	               	String arr[] = line.split(","); 
	                   
	               	//System.out.println(line);
	               	
	               	for (String temp: arr){
	               		  temp = temp.trim();
	             	      if(temp.equals(field)){
	             	    	  countMale = countMale + 1;
	             	      }
	               		//System.out.println(temp);
	               	}
	               }
	               //System.out.println(countMale);

	           } catch (IOException e) {
	               System.err.format("IOException: %s%n", e);
	           }
	        return countMale;
		}
		

	    public static void main(String[] args) {
	    
	    	
	    	Task1_Question1 obj = new Task1_Question1();
	    	obj.setField("Male");
	    	
	    	System.out.println("The total number of "+obj.countField());

	    }

}