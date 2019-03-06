package com.endava.dao;

import com.endava.enity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoClass implements DaoList {

List<Student> list =new ArrayList<>();

public void  add(Student student){
    list.add(student);
}

public List<Student> getAllStudents(){
    return list;
}

public Student getById(int id){
    return list.get(id);
}

    @Override
    public int getSizeOfList() {
        return list.size();
    }

}
