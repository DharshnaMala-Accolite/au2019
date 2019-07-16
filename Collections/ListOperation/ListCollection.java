package com.accolite.au;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListCollection {

	public static void main(String[] args) {
		Employee e1 = new Employee("Dharshna", 2525, 78);
		Employee e2 = new Employee("Siva", 2478, 58);
		Employee e3 = new Employee("Divya", 7689, 68);
		Employee e4 = new Employee("Shrvya", 1225, 58);
		Employee e5 = new Employee("Ps", 2541, 38);
		List<Employee> l = new ArrayList<>();
		l.add(e1);
		l.add(e2);
		l.add(e3);
		l.add(e4);
		l.add(e5);
		System.out.println("Printing the Employee List using several ways:");
		System.out.println(l);
		// general for loop
		for (int i = 0; i < l.size(); i++)
			System.out.println(l.get(i).getName());
		// for loop element
		for (Employee e : l)
			System.out.println(e.toString());
		// forEach loop
		Collections.sort(l);// soting using Comparable
		l.forEach(e -> {
			System.out.println(e.toString());
		});
		// sorting using comparator
		l.sort(new EmployeeComparator());
		for (Employee e : l)
			System.out.println(e.toString());
		// Iteration using iterator
		Iterator iter = l.iterator();
		while (iter.hasNext()) {
			Employee cur = (Employee) iter.next();
			System.out.println(cur.getName());
		}
		//remove in iterator
		Iterator itr=l.iterator();
		if(itr.hasNext())
		{
			itr.next();
			itr.remove();
		}
		System.out.println(l.toString());
		//reversing a list
		Collections.reverse(l);
		System.out.println(l.toString());
	}

}
