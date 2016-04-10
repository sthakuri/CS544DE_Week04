/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author 500Course
 */
@Entity(name = "Student")
public class Student extends Person implements Serializable {
    
    private double gpa;
    
    @OneToMany(cascade = CascadeType.PERSIST, targetEntity = NoteBook.class)
    private Collection<NoteBook> notebooks;
    
    public Student()
    {}
    
    public Student(Person p, double gpa)
    {
        super(p.getName());
        this.gpa= gpa;
        this.notebooks = new ArrayList<NoteBook>();
    }
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Collection<NoteBook> getNotebooks() {
        return notebooks;
    }

    public void addNoteBook(NoteBook noteBook) {
        this.notebooks.add(noteBook);
    }
    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the name fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if(this.getName().equalsIgnoreCase(other.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Model.Student[ name=" + this.getName() + " ]";
    }
    
}
