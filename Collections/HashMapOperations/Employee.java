package com.accolite.au;

public class Employee implements Comparable<Employee>{

	private String name;
	private int id;
	private int salary;
	Employee(String name, int id, int salary)
	{
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public int getSalary() {
		return salary;
	}
	@Override
	public String toString()
	{
		return name+"-"+id+"-"+salary;
	}
	@Override
	public int compareTo(Employee e)
	{
		if(e.salary==0)
			return 1;
		else if(this.salary>e.salary)
			return 1;
		else if(this.salary<e.salary)
			return -1;
		else
			return 0;
	}
}
