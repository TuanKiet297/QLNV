package demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employees {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;
 
    @Column(name = "first_name")
    private String first_name;
 
    @Column(name = "last_name")
    private String last_name;
 
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getFName() {
        return first_name;
    }
 
    public void setFName(String Fname) {
        this.first_name = Fname;
    }
 
    public String getLName() {
        return last_name;
    }
 
    public void setLName(String Lname) {
        this.last_name = Lname;
    }
}
