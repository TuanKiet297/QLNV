package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.entity.Employees;
 
@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Integer> {
 
}
