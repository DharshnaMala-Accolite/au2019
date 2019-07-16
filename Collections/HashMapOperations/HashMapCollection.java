package com.accolite.au;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashMapCollection {

	public static void main(String[] args)
	{
		HashMap<Integer,Employee> h=new HashMap<>();
		Employee e1 = new Employee("Dharshna", 2525, 78);
		Employee e2 = new Employee("Siva", 2478, 58);
		Employee e3 = new Employee("Divya", 7689, 68);
		Employee e4 = new Employee("Shrvya", 1225, 58);
		Employee e5 = new Employee("Ps", 2541, 38);
		h.put(1,e1);
		h.put(2,e2);
		h.put(31,e3);
		h.put(4,e4);
		h.put(5,e5);
		//different ways to print a hashmap
		System.out.println(h);
		//for loop
		for (Map.Entry<Integer,Employee> entry : h.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
		//for each
		h.forEach((k,v)->{
			System.out.println("Key : " + k + " Value : " + v);
		});
		//retrieving key
		Set<Integer> ks=h.keySet();
		for(Integer key:ks)
		{
			System.out.println(h.get(key));
		}
		//sorting by key
		Map<Integer,Employee> sortedMap = new TreeMap<Integer,Employee>(h);
		System.out.println("Sorting by key");
		sortedMap.forEach((k,v)->{
			System.out.println("Key : " + k + " Value : " + v);
		});
		//sorting by value
	   List<Map.Entry<Integer, Employee> > list =  new LinkedList<Map.Entry<Integer, Employee> >(h.entrySet()); 
	  
	        // Sort the list 
	        Collections.sort(list, new Comparator<Map.Entry< Integer , Employee> >() 
	        { 
	            public int compare(Map.Entry <Integer , Employee> o1,Map.Entry<Integer , Employee> o2) 
	            { 
	            	Employee e1=o1.getValue();
	            	Employee e2=o2.getValue();
	            	 if(e1.getId()>e2.getId()) 
	            		 return 1; 
	            	 else if(e1.getId()<e2.getId()) 
	            		 return -1;
	            	 return 0; 
	            } 
	        }); 
	        System.out.println(list);
	}
}
