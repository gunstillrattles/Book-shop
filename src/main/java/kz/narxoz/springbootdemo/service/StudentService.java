package kz.narxoz.springbootdemo.service;

import kz.narxoz.springbootdemo.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> findAllStudents();
    Student findOneById(Long id);
    void deleteStudent(Long id);
}