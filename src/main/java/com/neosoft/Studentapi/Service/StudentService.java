package com.neosoft.Studentapi.Service;

import com.neosoft.Studentapi.Entity.Student;


public interface StudentService {
    public Student getStudent(int studentId);

    public Student registerStudent(Student student);
}
