package qlnv.service;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import qlnv.entity.Employees;
//import qlnv.feignclient.AddressClient;
import qlnv.repository.QLNVRepo;

import java.util.List;
import java.util.Optional;
 
@Service
public class QLNVService {
 
    @Autowired
    private QLNVRepo employeeRepo;
 
//    @Autowired
//    private ModelMapper mapper;
 
    // Spring will create the implementation
    // for this class
    // and will inject the bean here (proxy)
//    @Autowired
//    private AddressClient EmployeeClient;
    public Optional<Employees> getMyInfo(int id){
    	return employeeRepo.getMyInfo(id);
    }
    public Optional<Employees> logIn(String email, String password){
    	return employeeRepo.logIn(email, password);
    }
    public Employees addEmployee(Employees emp){
    	return employeeRepo.save(new Employees(emp.getEmail(),emp.getFirst_name(), emp.getLast_name(), emp.getPassword(), emp.getUser_type(), emp.getStatus()));
    }
    public Employees updateEmployee(Employees emp) {
    	return employeeRepo.save(emp);
    }
    public void updateMyInfo(Employees emp) {
    	employeeRepo.updateMyInfo(emp.getEmp_id(), emp.getPersonal_id(), emp.getFirst_name(), emp.getLast_name(), emp.getAcc_number(), emp.getGender(), emp.getAddress(), emp.getTel(), emp.getDOB(), emp.getEmail());
    }
    public void deleteById(int id) {
    	employeeRepo.deleteById(id);
    }
    public boolean existById(int id) {
    	return employeeRepo.existsById(id);
    }
    public Optional<Employees> getEmpById(int id) {
    	return employeeRepo.findById(id);
    }
    public Iterable<Employees> getAllEmployee() {       
    	Iterable<Employees> employees = employeeRepo.findAll();
        return employees;
    }
 
}
