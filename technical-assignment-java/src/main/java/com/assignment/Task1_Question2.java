package com.assignment;

//Task 1 Question 3: Who is the oldest person in the address book ?
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Task1_Question2 { 
	//calculates persons age - difference between current date and date of birth
	public static long calculateAge(int year,int month,int day){
		year = 1900 + year;
		LocalDate pdate = LocalDate.of(year, month, day);
		LocalDate now = LocalDate.now();

		long noOfDays = ChronoUnit.DAYS.between(pdate, now);

		return noOfDays;
	}

	public Map<String, Long> getAgeFromFile(){
		Map<String, Long> map1 = new HashMap<String, Long>();

		try (FileReader reader = new FileReader("src/main/resources/AddressBook");
				BufferedReader br = new BufferedReader(reader)) {

			// read line by line
			String line;
			long age=0;
			while ((line = br.readLine()) != null) {
				String arr[] = line.split(","); 

				age = calculateAge(Integer.parseInt(arr[2].substring(7, 9)), 
						Integer.parseInt(arr[2].substring(4, 6)), 
						Integer.parseInt(arr[2].substring(1, 3)));
				map1.put(arr[0], age);          
			}

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		return map1;
	}

	//sorts elements of the hash map by value i.e. the age
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
	
	//displaying the oldest person in the address book
	public void display(Map<String, Long> map1){
		int count=1;
		for (Map.Entry<String, Long> entry : map1.entrySet()) {
			if(map1.size()==count)
				System.out.println("ADDRESS BOOK'S OLDEST PERSON : "+entry.getKey());
			count = count + 1;
		}  
	}
  
	public static void main(String[] args){
		Map<String, Long> map1 = new HashMap<String, Long>();//Creating arraylist 
		Task1_Question2 obj = new Task1_Question2();
		map1=obj.getAgeFromFile();

		Map<String, Long> hm1 = obj.sortByValue(map1); //sorting hashmap
		obj.display(hm1);
	}
}