package com.example.SpringBoot.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.model.Address;
import com.example.SpringBoot.repository.AddRepo;


@RestController
@RequestMapping(value ="home")
public class AddService {
	@Autowired
	AddRepo addrepo;
	
	@RequestMapping("/insert")
    public String process(){
		addrepo.save(new Address("Theni","625531","TN"));
		addrepo.save(new Address("Kottaim","638765","Kerela"));
		addrepo.save(new Address("Bangalore","601021","Karnataka"));
		addrepo.save(new Address("Hyderabad","699021","AP"));
        return "Done";
    }
	
	@RequestMapping("/getpin")
    public String getByPinCode(){
        String res = "<html>";
        for(Address addrs : addrepo.findAll()){
            res += "<div>" + addrs.toString() + "</div>";
        }
        return res + "</html>";
    }
	
}

