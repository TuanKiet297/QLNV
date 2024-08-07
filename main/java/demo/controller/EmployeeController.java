package demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import demo.entity.Employees;
import demo.repository.EmployeeRepo;
import demo.service.EmployeeService;

import org.springframework.stereotype.Controller;
@RestController
@Controller
@RequestMapping(path="/employees") // This means URL's start with /demo (after Application path)
public class EmployeeController {
	
	@Autowired
    private EmployeeRepo employeeRepo;
	
    @Autowired
    private EmployeeService employeeService;
    @PostConstruct
    protected void iamAlive(){
    	System.out.println("Hello AppEcosystemController");
    }
    @GetMapping(path="/all")
    public ResponseEntity<Iterable<Employees>> getAllEmployee() {
//    	Iterable<Employees> employee = employeeRepo.findAll();
//        return ResponseEntity.status(HttpStatus.OK).body(employee);
    	try {
            Iterable<Employees> employees = employeeService.getAllEmployee();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            // Handle exception, e.g., log error, return appropriate status code
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    	//return employeeRepo.findAll();
    }
}
