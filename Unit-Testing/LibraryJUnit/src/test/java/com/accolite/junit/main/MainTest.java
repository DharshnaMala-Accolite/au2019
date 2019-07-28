package com.accolite.junit.main;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.accolite.junit.pojo.Book;

@FixMethodOrder(MethodSorters.DEFAULT)
public class MainTest {

	private Main app = new Main();
	private static Book b = new Book();
	private static Book b1 = new Book();
	private static String bk_title="Stranger Things";
	
	//will run once before the class starts
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		b.setBookId(3011);
		b.setAuthor("Dharshna");
		b.setNoOfPages(3011);
		b.setTitle("Stranger Things");
		b.setPrice(111);
		b.setPublishedOn(new Date());
		
		b1.setBookId(3511);
		b1.setAuthor("Darwin");
		b1.setNoOfPages(3511);
		b1.setTitle("Java");
		b1.setPrice(100);
		b1.setPublishedOn(new Date());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	//will run before every test case starts
	@Before
	public void setUp() throws Exception {
		System.out.println("Before test cases");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddBook() {
		//fail("Not yet implemented");
		assertEquals(b,app.addBook(b));
		assertEquals(b1,app.addBook(b1));
//		Book b2=new Book();
//		b2.setTitle("Stranger Things");
//		assertEquals(bk_title,b2.getTitle());
	}
	
	@Test//(expected=NullPointerException.class)
	public void testGetBook()
	{
		assertEquals(b1.getTitle(),app.getBook("Java"));
	}
	
	@Test
	public void testGetAuthor() {
		assertFalse(b1.getAuthor().equals("Sivagami"));
	}
	
}
