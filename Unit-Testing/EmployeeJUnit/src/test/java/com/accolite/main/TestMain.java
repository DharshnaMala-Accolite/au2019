package com.accolite.main;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.accolite.main.Main;
import com.accolite.pojo.Employee;

@FixMethodOrder(MethodSorters.DEFAULT)
public class TestMain {

	private Main app = new Main();
	private static Employee emp = new Employee();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emp.setEmpId(3011);
		emp.setEmpName("Dharshna");
		emp.setDept("Fedex");
		emp.setSalary(58000);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Test case being tested...");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(expected=NullPointerException.class)
	public void testIsListEmp()
	{
		assertNotEquals("true",app.isListEmpty());
	}
	

	@Test
	public void testAddEmployee() {
		assertEquals(emp,app.addEmployee(emp));
	}

	@Test(expected=NullPointerException.class)
	public void testListEmployee()
	{
		assertNotEquals("false",app.ListEmployee());
	}
	
	@Test
	public void testGetEmployee() {
		assertEquals(1,app.getEmployee("Dharshna"));
	}
	
	@Test
	public void testUpdateEmployee()
	{
		assertNotEquals(emp.getEmpName(),app.updateEmployee("DharshnaMala", 3011));
		assertNotEquals("not found",app.updateEmployee("DharshnaMala", 3011));
		assertNotNull(app.updateEmployee("DharshnaMala", 3011));
	}
	
	@Test
	public void testDeleteEmployee() {
		assertNotEquals(1,app.deleteEmployee(3011));
	}
	
	@Test
	public void testGetSalaryFromDept()
	{
		assertNotNull(app.getSalaryFromDept("Fedex"));
	}
}
