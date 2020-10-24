package com.episen.android.mem.back.controller;

import com.episen.android.mem.back.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(Student.getStudentList());
    }

    @PostMapping("/student")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student){
        Student.insertStudent(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") String id){
        Student student = Student.getById(Integer.parseInt(id));
        return ResponseEntity.ok(student);

    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("id") Integer id){
        boolean b = Student.deleteStudent(id);
        return ResponseEntity.ok(b);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student){
        student.setId(id);
        Student student1 = Student.editStudent(student);
        return ResponseEntity.ok(student1);
    }
}
