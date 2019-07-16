package com.assignment.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.accolite.au.Employee;


public class BookList {

	public static void main(String[] args) {
		Book b1=new Book("Java",100,"Sharanya");
		Book b2=new Book("Python",111,"Nishant");
		Book b3=new Book("C++",350,"Naveen");
		Book b4=new Book("C",50,"Amit");
		Book b5=new Book("C#",100,"Payal");
		Book b6=new Book("Collections",120,"Payal");
		Book b7=new Book("Oops",200,"Sharanya");
		Book b8=new Book("Dbms",150,"Aravindh");
		Book b9=new Book("HashMap",190,"Payal");
		List<Book> bl=new ArrayList<>();
		bl.add(b1);
		bl.add(b2);
		bl.add(b3);
		bl.add(b4);
		bl.add(b5);
		bl.add(b6);
		bl.add(b7);
		bl.add(b8);
		bl.add(b9);
		System.out.println("List of Books,");
		for(Book b:bl)
			System.out.println(b);
		//sorting based on price using comparable
		Collections.sort(bl);
		System.out.println("Sorted List-Based on Price,using comparable");
		for(Book b:bl)
			System.out.println(b);
		//sorting based on price using comparator
		bl.sort(new BookComparator());
		System.out.println("Sorted List-Based on Price and name,using comparable");
		for(Book b:bl)
			System.out.println(b);
		Iterator iter = bl.iterator();
		while (iter.hasNext()) {
			Book cur = (Book) iter.next();
			cur.decreaseCost();
		}
		System.out.println("Books after discount of 20%,");
		for(Book b:bl)
			System.out.println(b);
		
	}

}
