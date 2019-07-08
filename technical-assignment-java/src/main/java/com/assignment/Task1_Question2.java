package com.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Task1_Question2 { 
	
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
	
	public Map<String, Long> retrieveDateField(){
		int countMale=0;
		Map<String, Long> map1 = new HashMap<String, Long>();
		//ArrayList<String> list= new ArrayList<String>();//Creating arraylist 
		
     try (FileReader reader = new FileReader("C:\\file\\AddressBook");
             BufferedReader br = new BufferedReader(reader)) {

            // read line by line
            String line;
            long age=0;
            while ((line = br.readLine()) != null) {
            	String arr[] = line.split(","); 
               
          	    	  age = calculateAge(Integer.parseInt(arr[2].substring(7, 9)), Integer.parseInt(arr[2].substring(4, 6)), 
          	    			  Integer.parseInt(arr[2].substring(1, 3)));
          	    	  map1.put(arr[0], age);          
            	}

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
     return map1;
	}
	
	public Map<String, Long> compareAge(Map<String, Long> map1){
		//Map<String, String> map1 = new HashMap<String, String>();
		  for (Map.Entry<String, Long> entry : map1.entrySet()) {
			//	System.out.println("Name :"+entry.getKey()+"\tDate :"+entry.getValue());
			  
				
				//if(entry.getValue()==)
			}
		
		return map1;
	}
	
	public HashMap<String, Long> sortByValue(Map<String, Long> map1) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Long> > list = 
               new LinkedList<Map.Entry<String, Long> >(map1.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Long> >() { 
            public int compare(Map.Entry<String, Long> o1,  
                               Map.Entry<String, Long> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Long> temp = new LinkedHashMap<String, Long>(); 
        for (Map.Entry<String, Long> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
  
	
public static void main(String[] args){
	Map<String, Long> map1 = new HashMap<String, Long>();//Creating arraylist 
	Task1_Question2 obj = new Task1_Question2();
	   map1=obj.retrieveDateField();
//	   System.out.println("Result "+obj.calculateAge(94, 4, 10));
	   
//	   for(int i=0;i<list.size();i++){
// 	   System.out.println(list.get(i));
//    }
	   Map<String, Long> hm1 = obj.sortByValue(map1); 
	
	   
	   
	  for (Map.Entry<String, Long> entry : hm1.entrySet()) {
			System.out.println("Name :"+entry.getKey()+"\tDate :"+entry.getValue());
			
			//if(entry.getValue()==)
		}
	   //System.out.println("The total number of "+list.countField());
	   
}
}