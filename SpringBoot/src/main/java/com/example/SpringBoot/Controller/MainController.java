package com.example.SpringBoot.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringBoot.model.Employee;
import com.example.SpringBoot.repository.EmpRepo;

@RestController
public class MainController {
	
	@Value("${a}")
	private int a;
    @Autowired
    EmpRepo emprepo;
      
    @RequestMapping("/create")
    public String process(){
    	emprepo.save(new Employee("Dharshna", "Mala"));
    	emprepo.save(new Employee("Bala", "Krishnan"));
    	emprepo.save(new Employee("Kani", "Amuthu"));
        emprepo.save(new Employee("Darwin", "Tamil"));
        return "Done";
    }
      
    @RequestMapping("/getemp")
    public String getEmployees(){
        String res = "<html>";
        res+="<p>" +"There can be maximum "+a+" employees.Currently available employees are:" + "</p>";
        for(Employee emp : emprepo.findAll()){
            res += "<div>" + emp.toString() + "</div>";
        }
        return res +"</html>";
    }
      
    @RequestMapping("/getbyid")
    public String getById(@RequestParam("id") long id){
        String res = "";
        res = emprepo.findById(id).toString();
        return res;
    }
      
    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String res = "<html>";
        for(Employee emp: emprepo.findByLastName(lastName)){
            res += "<div>" + emp.toString() + "</div>"; 
        }
		return res+ "</html>";
		
    }
}