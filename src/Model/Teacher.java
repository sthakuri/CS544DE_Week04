/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 500Course
 */
@Entity(name = "Teacher")
public class Teacher extends Person implements Serializable {

    private double salary;
    
    @OneToOne(cascade = CascadeType.PERSIST, targetEntity = Laptop.class)
    private Laptop laptop;
    
    public Teacher()
    {
        
    }
    
    public Teacher(Person person, double salary)
    {
        super(person.getName());
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the name fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if(this.getName().equalsIgnoreCase(other.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Model.Teacher[ name=" + this.getName() + " ]";
    }
    
}
