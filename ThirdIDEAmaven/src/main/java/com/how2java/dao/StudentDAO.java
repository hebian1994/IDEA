package com.how2java.dao;

import com.how2java.bean.Student;

import java.util.Set;

public interface StudentDAO {  //分离interface和impl

    public int addStudent(Student student) ;

    public int deleteStudent(String name);

    public int updateStudent(String name);

    public Student findStudent(String name);

    public Set<Student> findAll();






}
