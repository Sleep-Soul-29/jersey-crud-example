//Create Sample StudService class

package com.java.jersey.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import com.java.jersey.model.Student;

public class StudService {

    private List<Student> stud = new ArrayList<Student>();

    public List<Student> fetchAll() {

        stud.add(new Student(34, "pooja", "2000-03-02","2022-01-21"));
        stud.add(new Student(36, "Amruta", "1999-05-23","2022-01-22"));
        stud.add(new Student(100, "Sudha", "2003-01-24","2022-01-19"));
        return stud;
    }

    public Student fetchBy(long no) throws NotFoundException {
        for (Student stud2 :  fetchAll()) {
             if (no == stud2.getNo()) {
                return stud2;
             }else{
                throw new NotFoundException("Resource not found with No :: " + no);
             }
         }
         return null;
     }

    public void create(Student stud) {
         stud.add(stud);
    }

    public void update(Student stud) {
         for (Student stud2 : stud) {
            if (stud.getNo() == stud2.getNo()) {
                stud.remove(stud2);
                stud.add(stud);
            }
         }
    }

    public void delete(long no) throws NotFoundException {
      // TODO: delete operation
    }
}