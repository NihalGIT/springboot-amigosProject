package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path = "api/v1/student")
public class studentcontroller {
    private final studentservice studentService;
    //constructor
    @Autowired
    public studentcontroller(studentservice studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "all")
	public List<student> getStudents() {
        return studentService.getStudents();
	}

    @PostMapping(path = "add")
    public void registerStudent(@RequestBody student Student){
        studentService.addNewStudent(Student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(
        @PathVariable("studentId") Long studentId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

    
}
