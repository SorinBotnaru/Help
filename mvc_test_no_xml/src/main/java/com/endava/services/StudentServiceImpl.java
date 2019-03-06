package com.endava.services;

import com.endava.dao.DaoList;
import com.endava.enity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    DaoList daoList;

    @Override

    public void add(Student student) {
        daoList.add(student);
    }

    @Override
    public List<String> getAllStudents() {
        List<String> helpList=new ArrayList<>();
        for (int i = 0; i <daoList.getSizeOfList() ; i++) {
            helpList.add(String.valueOf(daoList.getById(i)));
        }


        return helpList;
    }

    @Override
    public Student getStudentById(int id) {
        return daoList.getById(id);
    }
}
