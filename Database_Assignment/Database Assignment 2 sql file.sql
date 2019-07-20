create database assignment;
use assignment;
create table Cricket_Match( matchid int, player varchar(10) , score int );
insert into Cricket_Match(matchid, player ,score) values(1,'A',0),(1,'B',101),(1,'C',55),(1,'D',23),(1,'E',12),(1,'F',100),(2,'A',146),(2,'B',120),(2,'C',104),(2,'D',3),(2,'E',54),(2,'F',111);
select * from Cricket_Match;
select player from Cricket_Match where (score>=100 and matchid=1) and player in (select player from Cricket_Match where (score>=100 and matchid=2));
select player from Cricket_Match where (score>=100 and matchid=1) and player not in (select player from Cricket_Match where (score>=100 and matchid=2)) union
select player from Cricket_Match where (score>=100 and matchid=2) and player not in (select player from Cricket_Match where (score>=100 and matchid=1));



create table friend_list( name varchar(50), friend_name varchar(50));
insert into friend_list( name, friend_name ) values ('Sam','Ram'),('Sam','Vamsi'),('Vamsi','Ram'),('Vamsi','Jhon'),('Ram','Vijay'),('Ram','Anandh');
desc Cricket_Match;

select  f1.name, f2.friend_name as friend_of_friend_of_Sam from friend_list f1,friend_list f2 where f1.name = 'Sam' and f1.friend_name = f2.name;

create table color( colorid int primary key, colorname varchar(20) );  
insert into color(colorid,colorname) values (11,'Black'), (1,'Yellow'), (2,'Pink'), (3,'Blue'), (4,'Red');
create table size( sizecode varchar(10) primary key, des varchar(20));
insert into size(sizecode,des) values ('XS','Extra Small'),('S','Small'),('M','Medium'),('L','Large'),('XL','Extra Large'),('XXL','Double Extra Large');
select a.colorname,  b.sizecode from color as a cross join size as b; 

create table employee(employee_id int primary key, first_name varchar(30), last_name varchar(30), phone int, join_date date, salary int, dept_id int);
insert into employee(employee_id,first_name,last_name,phone,join_date,salary,dept_id) values(11,'Dharshna','Mala',95007,'2003-6-10',58000,3011),(22,'Darwin','Thamil',73338,'2002-5-10',8000,3511),(31,'Kani','Amuthu',11198,'2005-10-10',5000,3031);
insert into employee(employee_id,first_name,last_name,phone,join_date,salary,dept_id) values(18,'Harshitha','Raj',95037,'2000-3-10',5800,3018);
select first_name,join_date from employee where extract(year from join_date) between 2002 and 2005;
desc employee;

alter table employee add jobid int;
select * from employee;
desc employee;
update employee set dept_id=111 where employee_id=11;
update employee set dept_id=222 where employee_id=18;
update employee set dept_id=333 where employee_id=22;
update employee set dept_id=444 where employee_id=31;
insert into employee(employee_id,first_name,last_name,phone,join_date,salary,dept_id,jobid) values(10,'Akshay','Venket',95007,'2008-6-10',7000,111,1),(42,'Divya','Thamil',73338,'2000-5-10',8000,111,1),(30,'Sivagami','Sankaralingam',11198,'2006-10-10',7000,111,1),(15,'Karthi','Keyan',11198,'2003-10-10',7000,111,1);
insert into employee(employee_id,first_name,last_name,phone,join_date,salary,dept_id,jobid) values(8,'Deepak','Kumar',95007,'2003-6-10',5000,111,1);

create table departments (
	department_id INT (11) UNSIGNED NOT NULL,
	department_name VARCHAR(30) NOT NULL,
	manager_id INT (11) UNSIGNED,
	location_id INT (11) UNSIGNED,
	PRIMARY KEY (department_id)
	);
insert into departments values(111,"cs",01,2);
insert into departments values(222,"finance",02,1);
insert into departments values(333,"bfsi",03,4);
insert into departments values(444,"aviation",04,3);

select * from departments;


CREATE TABLE jobs (
	job_id VARCHAR(10) NOT NULL,
	job_title VARCHAR(35) NOT NULL,
	min_salary int,
	max_salary int,
	PRIMARY KEY (job_id)
	);
desc jobs;    
select * from jobs;
insert into jobs values(1,"SSE",30000,60000);
insert into jobs values(2,"Trainee",3000,6000);
insert into jobs values(4,"Intern",3000,6000);
insert into jobs values(3,"Assitant",5000,8000);

select departments.department_id,departments.department_name,departments.manager_id,departments.location_id from departments inner join employee on departments.department_id=employee.dept_id inner join jobs on employee.jobid=jobs.job_id where jobs.max_salary>10000;
select departments.department_name from departments inner join employee on departments.department_id=employee.dept_id;
desc employee;
select departments.department_name from employee join departments on employee.dept_id=departments.department_id where count(employee.emplyee_id) >=5;
create table dept_emp(dept_id int ,EmpCount int);
insert into dept_emp select dept_id,count(*) as EmpCount from employee group by dept_id;

select * from dept_emp;
select departments.department_id as Dept_Id,departments.department_name as Dept_Name,dept_emp.EmpCount as Employee_Count from departments join dept_emp on  departments.department_id=dept_emp.dept_id where dept_emp.EmpCount>5;
desc departments;
select * from departments;
desc employee;
CREATE TABLE locations (
	location_id INT (11) NOT NULL,
	city VARCHAR(30) NOT NULL,
	PRIMARY KEY (location_id)
	);
desc locations;
insert into locations values(1,"Chennai"),(2,"Bangalore"),(3,"Hyderabad"),(4,"Mumbai");
select * from locations;
select * from employee;
desc dept_emp;
desc departments;
desc employee;
select departments.department_id as Dept_Id,departments.department_name as Dept_Name,dept_emp.EmpCount as Employee_Count,locations.city from dept_emp join departments on  departments.department_id=dept_emp.dept_id join locations on locations.location_id=departments.location_id;

delimiter $$
create procedure getNewSalary(IN empId int,IN hike int,OUT sal float)
BEGIN
	declare curSalary int;
    select salary into curSalary from employee where employee_id=empId;
    select (curSalary+((hike*curSalary)/100)) into sal;
END$$

call getNewSalary(11,10,@new_sal);
select @new_sal as New_Salary;

delimiter $$
create procedure updateSal(IN empId int)
BEGIN
	call getNewSalary(empId,13,@new_sal);
	update employee set salary=@new_sal where employee_id=empId;
END$$

call updateSal(11);