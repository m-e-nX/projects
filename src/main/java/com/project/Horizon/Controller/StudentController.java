package com.project.Horizon.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Horizon.Model.Student;
import com.project.Horizon.Service.StudentService;
import com.project.Horizon.usernameGenerator.userNameGenerator;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;
    @Autowired
    private final userNameGenerator generator;

   public StudentController(userNameGenerator generator){
    this.generator = generator;
   }

    @GetMapping("/students")
    public List<Student> getStudents() {
       return service.getStudents();
    }

    @PostMapping("/student")
    public String saveStudent(Student student, String username) {
       
        String generatedUsername = generator.generateUsername(username);
        student.setUsername(generatedUsername);
         service.save(student);
        return ("your username is " + generatedUsername);
    }

    @GetMapping("/students/{username}")
    public ResponseEntity<Student> getStudentByUsername(@PathVariable String username){
        try{
            Student student = service.getStudentByUsername(username);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{password}")
    public ResponseEntity<Student> deleteStudent(@PathVariable String password){
        try{
            Student student = service.deleteByPassword(password);
            return new ResponseEntity<Student>(student, HttpStatus.GONE);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        
       
    }
   /*  @GetMapping("/studoc/{format}")
    public String generateReport(@PathVariable String format){
        return  service.exportReport(format);
    }*/


}
