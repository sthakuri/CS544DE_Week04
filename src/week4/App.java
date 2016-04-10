/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import EntityManager.DBContext;
import EntityManager.MyCRUD;
import Model.Laptop;
import Model.NoteBook;
import Model.Person;
import Model.Student;
import Model.Teacher;

/**
 *
 * @author 500Course
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBContext dbContext = new DBContext();
        System.out.println("Database Contex Created");

        MyCRUD crudService = new MyCRUD(dbContext.getEntityManager());
        System.out.println("CRUD Entity Manager Created.");

        //Create students
        Student jack = new Student(new Person("Jack"), 3.4);
        Student john = new Student(new Person("John"), 3.2);
        Student jill = new Student(new Person("Jill"), 3.6);

        //Create teacher
        Teacher jim = new Teacher(new Person("Jim"), 45000);
        Teacher jasmin = new Teacher(new Person("Jasmin"), 46000);

        //assign notebooks to students
        jack.addNoteBook(new NoteBook(100));
        jack.addNoteBook(new NoteBook(120));
        jack.addNoteBook(new NoteBook(60));

        john.addNoteBook(new NoteBook(200));
        john.addNoteBook(new NoteBook(50));

        jill.addNoteBook(new NoteBook(300));

        //assign laptop to teachers
        jim.setLaptop(new Laptop("Dell"));
        jasmin.setLaptop(new Laptop("Mac"));

        //save records to database
        crudService.save(jack);
        System.out.println(jack.toString() + "successfully created");

        crudService.save(john);
        System.out.println(john.toString() + "successfully created");

        crudService.save(jill);
        System.out.println(jill.toString() + "successfully created");

        crudService.save(jim);
        System.out.println(jim.toString() + "successfully created");

        crudService.save(jasmin);
        System.out.println(jasmin.toString() + "successfully created");

        int studentId = 1;
        boolean chk = crudService.deleteStudent(studentId);
        if (chk) {
            System.out.println("student id " + studentId + " successfully deleted");
        } else {
            System.out.println("student id " + studentId + " delete fail!");
        }
    }

}
