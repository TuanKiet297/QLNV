package demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import demo.entity.Employees;
import demo.feignclient.AddressClient;
import demo.repository.EmployeeRepo;
import demo.response.EmployeeResponse;

import java.util.List;
import java.util.Optional;
 
@Service
public class EmployeeService {
 
    @Autowired
    private EmployeeRepo employeeRepo;
 
    @Autowired
    private ModelMapper mapper;
 
    // Spring will create the implementation
    // for this class
    // and will inject the bean here (proxy)
    @Autowired
    private AddressClient EmployeeClient;
    
    public Iterable<Employees> getAllEmployee() {
 
        //Optional<Employees> employee = ;
        //EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
 
        // Using FeignClient
        //ResponseEntity<EmployeeResponse> addressResponse = EmployeeClient.getAllEmployee();
        
 
        return employeeRepo.findAll();
    }
 
}
