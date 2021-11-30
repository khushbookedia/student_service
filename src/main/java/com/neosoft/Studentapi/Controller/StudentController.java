package com.neosoft.Studentapi.Controller;

import com.neosoft.Studentapi.Entity.Project;
import com.neosoft.Studentapi.Entity.Student;
import com.neosoft.Studentapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;



//    private static final List<Student> STUDENTS = Arrays.asList(
//            new Student(1, "Harry", "Potter", "9876543210", "harry@gmail.com",)
//    )
//
//    private static final List<Project> projects = Arrays.asList(
//            new Project(1, "Project 1", 30, STUDENTS.get(0))
//    );

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentDetails(@PathVariable int id){
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @PostMapping(value = "/register" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> registerStudent(@RequestBody Student student){
        Project project1 = new Project("Project 1", 23);
        Project project2 = new Project("Project 2", 30);
        Project project3 = new Project("Project 3", 35);

        project1.setStudent(student);
        project2.setStudent(student);
        project3.setStudent(student);

        List<Project> projectList = new ArrayList<>();

        projectList.add(project1);
        projectList.add(project2);
        projectList.add(project3);

        student.setProject(projectList);

        return ResponseEntity.ok(studentService.registerStudent(student));
    }


}
