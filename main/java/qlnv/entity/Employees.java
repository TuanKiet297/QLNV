package qlnv.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int emp_id;
    
    @Column(name = "personal_id")
    private String personal_id;
 
    @Column(name = "first_name")
    private String first_name;
 
    @Column(name = "last_name")
    private String last_name;
    
    @Column(name = "tin")
    private String tin;
    
    @Column(name = "acc_number")
    private String acc_number;
    
    @Column(name = "start_date")
    private String start_date;
    
    @Column(name = "department_id")
    private int department_id;
    
    @Column(name = "position_id")
    private int position_id;
    
    @Column(name = "salary")
    private int salary;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "user_type")
    private String user_type;
    
    @Column(name = "gender")
    private boolean gender;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "tel")
    private String tel;
    
    @Column(name = "dob")
    private String dob;
    
    @Column(name = "email")
    private String email;
 
    public int getEmp_id() {
        return emp_id;
    }
 
    public void setEmp_id(int id) {
        this.emp_id = id;
    }
 
    public String getPersonal_id() {
        return personal_id;
    }
 
    public void setPersonal_id(String PId) {
        this.personal_id = PId;
    }
    
    public String getFirst_name() {
        return first_name;
    }
 
    public void setFirst_name(String Fname) {
        this.first_name = Fname;
    }
 
    public String getLast_name() {
        return last_name;
    }
 
    public void setLast_name(String Lname) {
        this.last_name = Lname;
    }
    
    public String getTIN() {
        return tin;
    }
 
    public void setTIN(String tin) {
        this.tin = tin;
    }
    
    public String getAcc_number() {
        return acc_number;
    }
 
    public void setAcc_number(String acc_number) {
        this.acc_number = acc_number;
    }
    
    public String getStart_date() {
        return start_date;
    }
 
    public void setStart_date(String StartDate) {
        this.start_date = StartDate;
    }
    
    public int getDepartment_id() {
        return department_id;
    }
 
    public void setDepartment_id(int DepId) {
        this.department_id = DepId;
    }
    
    public int getPosition_id() {
        return position_id;
    }
 
    public void setPosition_id(int PosId) {
        this.position_id = PosId;
    }
    
    public int getSalary() {
        return salary;
    }
 
    public void setSalary(int Salary) {
        this.salary = Salary;
    }
    
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String Password) {
        this.password = Password;
    }
    
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String Status) {
        this.status = Status;
    }
    
    public String getUser_type() {
        return user_type;
    }
 
    public void setUser_type(String UserType) {
        this.user_type = UserType;
    }
    
    public boolean getGender() {
    	return gender;
    }
 
    public void setGender(boolean Gender) {
        this.gender = Gender;
    }
    
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String Address) {
        this.address = Address;
    }
    
    public String getTel() {
        return tel;
    }
 
    public void setTel(String Tel) {
        this.tel = Tel;
    }
    
    public String getDOB() {
        return dob;
    }
 
    public void setDOB(String DOB) {
        this.dob = DOB;
    }
    
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String Email) {
        this.email = Email;
    }
    
    public Employees(String email, String first_name, String last_name, String password, String status, String user_type) { 
    	super(); 
		this.email = email; 
		this.first_name = first_name; 
		this.last_name = last_name; 
		this.password = password; 
		this.status = status;
		this.user_type = user_type;
    } 
	public Employees() { 
		super(); 
	} 
}

