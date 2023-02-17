package com.example.demo.student;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentservice {

    private final studentrepository studentrepository;
    // constructor
    @Autowired
    public studentservice(studentrepository studentrepository) {
        this.studentrepository = studentrepository;
    }

    public List<student> getStudents() {

        return studentrepository.findAll();

    }

    public void addNewStudent(student student) {
        Optional <student> studentOptional = studentrepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentrepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentrepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
        studentrepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        boolean exists = studentrepository.existsById(studentId);
        if(exists){
            studentrepository.updatestudent(name, email,studentId);
        }
        else{
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
    }
}
