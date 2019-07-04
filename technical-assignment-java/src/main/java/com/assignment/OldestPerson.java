package com.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class OldestPerson { 
	
	public long calculateAge(int year,int month,int day){
	       // date of birth
     //LocalDate pdate = LocalDate.of(1989, 04, 11);
		LocalDate pdate = LocalDate.of(year, month, day);
     // current date
     LocalDate now = LocalDate.now();
     // difference between current date and date of birth
     //Period diff = Period.between(pdate, now);

		long noOfDays = ChronoUnit.DAYS.between(pdate, now);
		
		return noOfDays;
	}
	
	public ArrayList<String> retrieveDateField(){
		int countMale=0;
		ArrayList<String> list= new ArrayList<String>();//Creating arraylist 
		
     try (FileReader reader = new FileReader("C:\\file\\AddressBook");
             BufferedReader br = new BufferedReader(reader)) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
            	String arr[] = line.split(","); 
                
            	//System.out.println(line);
            	
            	for (String temp: arr){
            		  temp = temp.trim();

          	      if(temp.charAt(2)=='/'){
          	    	  countMale = countMale + 1;
          	    	  list.add(temp);
          	      }
            		//System.out.println(temp);
          	    // String arr1[] = temp.split("/");
          
            	}
            }
           
           // System.out.println(countMale);
            
         

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
     return list;
	}
	
	
	
public static void main(String[] args)
 {
	   ArrayList<String> list=new ArrayList<String>();//Creating arraylist 
	   OldestPerson obj = new OldestPerson();
	   list = obj.retrieveDateField();
	   
	   for(int i=0;i<list.size();i++){
 	   System.out.println(list.get(i));
    }
	   //System.out.println("The total number of "+list.countField());
	   
/*      
     // date of birth
     LocalDate pdate = LocalDate.of(1989, 04, 11);
     // current date
     LocalDate now = LocalDate.now();
     // difference between current date and date of birth
     Period diff = Period.between(pdate, now);
     

  System.out.printf("\nI am  %d years, %d months and %d days old.\n\n", 
                 diff.getYears(), diff.getMonths(), diff.getDays());
  
  System.out.print(diff.getDays());
  */
}
}