package com.assignment;

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
	
	public long calculateAge(int year,int month,int day){
	       // date of birth
		
//		year = TWO_YEAR_FORMATTER.parse("99").get(ChronoField.YEAR);
  //LocalDate pdate = LocalDate.of(1989, 04, 11);
		year = 1900 + year;
		LocalDate pdate = LocalDate.of(year, month, day);
  // current date
		LocalDate now = LocalDate.now();
  // difference between current date and date of birth
  //Period diff = Period.between(pdate, now);

		long noOfDays = ChronoUnit.DAYS.between(pdate, now);
		
		return noOfDays;
	}

	public long retrieveDateField(String name){
		int countMale=0;
		long age=0;
		//Map<String, Long> map1 = new HashMap<String, Long>();
		//ArrayList<String> list= new ArrayList<String>();//Creating arraylist 
		
     try (FileReader reader = new FileReader("C:\\file\\AddressBook");
             BufferedReader br = new BufferedReader(reader)) {

            // read line by line
            String line;
            
            while ((line = br.readLine()) != null) {
            	String arr[] = line.split(","); 
            	
            	if(arr[0].equals(name)){
        	    	  age = calculateAge(Integer.parseInt(arr[2].substring(7, 9)), Integer.parseInt(arr[2].substring(4, 6)), 
          	    			  Integer.parseInt(arr[2].substring(1, 3)));
            	}
          	    	  //map1.put(arr[0], age);          
            	}

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
     return age;
	}
	
    public static void main(String[] args) {
    	//Map<String, Long> map1 = new HashMap<String, Long>();//Creating arraylist 
    	Task1_Question3 obj = new Task1_Question3();
    	
 	   	long age1=obj.retrieveDateField("Bill McKnight");
 		long age2=obj.retrieveDateField("Paul Robinson");
 	   	
 	   	//Bill McKnight  Paul Robinson
 		
 		System.out.println("THE AGE DIFFERENCE IS : "+(age1-age2)+" DAYS");
    }
}
