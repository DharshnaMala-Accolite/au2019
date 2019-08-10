package com.example.SpringBoot.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.SpringBoot.model.Employee; 
public interface EmpRepo extends CrudRepository<Employee, Long>
{
    List<Employee> findByLastName(String lastName);
}
 

