package com.assignment.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accolite.au.Employee;

public class BookHashMap {

	public static void main(String[] args) {
		
			Book b1=new Book("Java",100,"Sharanya");
			Book b2=new Book("Python",111,"Nishant");
			Book b3=new Book("C++",350,"Naveen");
			Book b4=new Book("C",50,"Amit");
			Book b5=new Book("C#",100,"Payal");
			Book b6=new Book("Collections",120,"Payal");
			Book b7=new Book("Oops",200,"Sharanya");
			Book b8=new Book("Dbms",150,"Sharanya");
			Book b9=new Book("HashMap",190,"Payal");
			List<Book> l=new ArrayList<>();
			l.add(b1);
			l.add(b2);
			l.add(b3);
			l.add(b4);
			l.add(b5);
			l.add(b6);
			l.add(b7);
			l.add(b8);
			l.add(b9);
			HashMap<String,Integer> h=new HashMap<>();
			for(Book b:l)
			{
				String s=b.getAuthorName();
				if(h.containsKey(s))
					h.put(s, h.get(s) + 1);
				else
					h.put(s, 1);	
			}
			//HashMap having Author Name and No of Books written greater than 2
			System.out.println("Authors who have written more than 2 books:");
			for (Map.Entry<String,Integer> entry : h.entrySet()) {
				if(entry.getValue()>2)
					System.out.println(entry.getKey());
			}
		

	}

}
