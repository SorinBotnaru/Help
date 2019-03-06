package com.endava.dao;

import com.endava.enity.Student;

import java.util.List;

public interface DaoList {

    public void  add(Student student);
    public List<Student> getAllStudents();
    public Student getById(int id);
    public int getSizeOfList();
}
