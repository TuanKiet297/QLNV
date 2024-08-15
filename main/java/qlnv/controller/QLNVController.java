package qlnv.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import qlnv.entity.Employees;
import qlnv.repository.QLNVRepo;
import qlnv.service.QLNVService;

import org.springframework.stereotype.Controller;
@RestController
@Controller
@RequestMapping(path="/employees")
public class QLNVController {
	
    @Autowired
    private QLNVService employeeService;
    @PostConstruct
    protected void iamAlive(){
    	System.out.println("Hello AppEcosystemController");
    }
    
    
    @PostMapping("/add") 
	public ResponseEntity<Employees> addEmployee(@RequestBody Employees employee) { 
		try { 
			Employees _employee = employeeService.addEmployee(employee); 
			return new ResponseEntity<>(_employee, HttpStatus.CREATED); 
		} catch (Exception e) { 
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		} 
	}
	@PutMapping("/{id}") 
	 public ResponseEntity<Employees> CapNhatNhanVien(@PathVariable("id") int id, @RequestBody Employees emp) { 
	  Optional<Employees> nhanvienData = employeeService.getEmpById(id); 
	 
	  if (nhanvienData.isPresent()) { 
//	   Employees _nhanvien = nhanvienData.get(); 
//	   _nhanvien.setId(emp.getId()); 
//	   _nhanvien.setFName(emp.getFName()); 
//	   _nhanvien.setLName(emp.getLName()); 
//	   _nhanvien.setAccNumber(emp.getAccNumber()); 
//	   _nhanvien.setDepId(emp.getDepId()); 
//	   _nhanvien.setPosId(emp.getPosId()); 
//	   _nhanvien.setSalary(emp.getSalary()); 
//	   _nhanvien.setUserType(emp.getUserType()); 
//	   _nhanvien.setGender(emp.getGender()); 
//	   _nhanvien.setAddress(emp.getAddress()); 
//	   _nhanvien.setTel(emp.getTel()); 
//	   _nhanvien.setDOB(emp.getDOB()); 
//	   _nhanvien.setEmail(emp.getEmail()); 
//	   _nhanvien.setPId(emp.getPId());
	   return new ResponseEntity<>(employeeService.updateEmployee(emp), HttpStatus.OK); 
	  } else { 
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	  } 
	 }
	@DeleteMapping("/{id}") 
	public ResponseEntity<HttpStatus> XoaMotNhanVien(@PathVariable("id") int id) { 
	  try { 
		  employeeService.deleteById(id); 
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
	    } catch (Exception e) { 
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	    } 
	 } 

	@PostMapping(path="/login")
	public ResponseEntity<Optional<Employees>> login(@RequestBody String email, String password) { 
		try { 
			Optional<Employees> _employee = employeeService.logIn(email, password); 
			return new ResponseEntity<Optional<Employees>>(_employee, HttpStatus.CREATED); 
		} catch (Exception e) { 
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		} 
	}
    
    
    @GetMapping(path="/me/{id}")
    public ResponseEntity<Optional<Employees>> getMyInfo(@PathVariable("id") int id){
    	try {
    		System.out.println(id);
            Optional<Employees> employee = employeeService.getMyInfo(id);
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        } catch (Exception e) {
        	System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping(path="/{id}")
    public ResponseEntity<Optional<Employees>> getEmployeeInfo(@PathVariable("id") int id){
    	try {
            Optional<Employees> employee = employeeService.getEmpById(id);
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        } catch (Exception e) {
        	System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping(path="/all")
    public ResponseEntity<List<Employees>> getAllEmployee() {
    	try {
            List<Employees> employees = new ArrayList<Employees>();
            employeeService.getAllEmployee().forEach(employees::add);
            if(employees.isEmpty()) {
            	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.status(HttpStatus.OK).body(employees);
        } catch (Exception e) {
        	System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}

