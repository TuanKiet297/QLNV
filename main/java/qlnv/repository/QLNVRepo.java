package qlnv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import qlnv.entity.Employees;
 
@Repository
public interface QLNVRepo extends JpaRepository<Employees, Integer> {
	@Query(
	        nativeQuery = true,
	        value
	        = "UPDATE EMPLOYEES SET personal_id=:personal_id, first_name=:first_name, last_name=:last_name, acc_number=:acc_number, department_id=:department_id,"
	        		+ " position_id=:position_id, salary=:salary, user_type=:user_type, gender=:gender, address=:address, tel=:tel, dob=:dob, email=:email"
	        		+ " where emp_id=:employeeId")
	       void updateEmployee(@Param("employeeId") int employeeId, @Param("first_name") String first_name, @Param("last_name") String last_name, 
	    		   @Param("acc_number") String acc_number, @Param("department_id") int dep_id, @Param("position") int pos_id, 
	    		   @Param("salary") int salary, @Param("user_type") String user_type, @Param("gender") boolean gender, @Param("address") String address,
	    		   @Param("tel") String tel, @Param("dob") String dob, @Param("email") String email, @Param("personal_id") String personal_id);
	
	@Query(
	        nativeQuery = true,
	        value
	        = "UPDATE EMPLOYEES SET personal_id=:personal_id, first_name=:first_name, last_name=:last_name, acc_number=:acc_number,"
	        		+ " gender=:gender, address=:address, tel=:tel, dob=:dob, email=:email where emp_id=:employeeId")
	       void updateMyInfo(@Param("employeeId") int employeeId, @Param("personal_id") String personal_id, @Param("first_name") String first_name, 
	    		   @Param("last_name") String last_name, @Param("acc_number") String acc_number, @Param("gender") boolean gender, 
	    		   @Param("address") String address, @Param("tel") String tel, @Param("dob") String dob, @Param("email") String email);
	
	@Query(
	        nativeQuery = true,
	        value
	        = "SELECT personal_id, first_name, last_name, acc_number, gender, address, tel, dob, email from employees where emp_id=:employeeId")
	       Optional<Employees> getMyInfo(@Param("employeeId") int employeeId);
	@Query(
	        nativeQuery = true,
	        value
	        = "SELECT emp_id, first_name, last_name, user_type where email=:email and password=:password")
	       Optional<Employees> logIn(@Param("email") String email, @Param("password") String password);
}
