package com.how2java.service;

import java.util.*;

import com.how2java.bean.Student;
import com.how2java.dao.StudentDAO;
import com.how2java.dao.ConcreteStudentDao;
public class StudentService {

    StudentDAO sd = new ConcreteStudentDao();

    public int add(Student student)
    {
        return this.sd.addStudent(student);
    }

    public int delete(String name)
    {
        return this.sd.deleteStudent(name);
    }

    public int update(String name)
    {
        return this.sd.updateStudent(name);
    }

    public Student find(String name)
    {
        return this.sd.findStudent(name);
    }

    public Set<Student> findAll()
    {
        return this.sd.findAll();
    }

}
