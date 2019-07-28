package com.accolite.junit.main;

import java.util.HashSet;
import java.util.Set;

import com.accolite.junit.pojo.Book;
import com.accolite.junit.pojo.Library;

public class Main {

	public static void main(String[] args) {
		
	}
	static Library lib=new Library();
	public Book addBook(Book book)
	{
		Set<Book> books=lib.getBooks();
		if(books==null) {
			books=new HashSet<Book>();
		}
		books.add(book);
		lib.setBooks(books);
		return book;
	}
	public String getBook(String bk_title)
	{   
		Set<Book> b =new HashSet<Book>();
		b=lib.getBooks();
		String title = null ;
		for(Book bk:b)
		{
			System.out.println(bk.getTitle());
			if(bk.getTitle().equals(bk_title))
				title = bk.getTitle();
		}
		if(title == null)
			throw new NullPointerException();
		return title;
	}
}
