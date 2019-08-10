package com.example.SpringBoot.repository;
import org.springframework.data.repository.CrudRepository;
import com.example.SpringBoot.model.Address;

public interface AddRepo extends CrudRepository<Address, Long>{

}