package com.assignment;

//How many males are in the address book?

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountMale {

  public static void main(String[] args) {
  	int countMale=0;
      try (FileReader reader = new FileReader("C:\\file\\AddressBook");
           BufferedReader br = new BufferedReader(reader)) {

          // read line by line
          String line;
          while ((line = br.readLine()) != null) {
          	String arr[] = line.split(",");
              
          	//System.out.println(line);
          	
          	for (String temp: arr){
        	      if(temp.equals(" Male")){
        	    	  countMale = countMale + 1;
        	      }
          		//System.out.println(temp);
          	}
          }
          System.out.println("The total number of male is "+countMale);

      } catch (IOException e) {
          System.err.format("IOException: %s%n", e);
      }
  }

}