/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityManager;

import Model.Person;
import Model.Student;
import Model.Teacher;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author 500Course
 */
public class MyCRUD {

    private javax.persistence.EntityManager em;

    public MyCRUD(javax.persistence.EntityManager em) {
        this.em = em;
    }

    public void save(Person person) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //em.persist(car);
        if (person instanceof Student) {
            em.persist((Student) person);
            //save student
        } else if (person instanceof Teacher) {
            //save teacher
            em.persist((Teacher) person);
        } else {
            //save person
            em.persist(person);
        }
        tx.commit();
    }

    public boolean Exist(int id) {
        return em.find(Person.class, id) != null;
    }

    public boolean deleteStudent(int studentId) {
        Student s = new Student();
        if (Exist(studentId)) {
            s = em.find(Student.class, studentId);
                     
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(s); 
            //em.detach(s);
            tx.commit();
        }
        return s != null;
    }
}
