package com.endava.demo.dao;

import com.endava.demo.controller.InternController;
import com.endava.demo.entity.Intern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class InternDAOImpl implements InternDAO {

    public static List<Intern> internList = new ArrayList<>();

    private static Session curentSession;


    private static Transaction curentTransacion;


    public static SessionFactory getSessionFactiory() {
        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Intern.class).buildSessionFactory();
        return sessionFactory;
    }

    public static Session opneSession() {
        return curentSession = getSessionFactiory().openSession();
    }

    public static Transaction beginTransaction() {
        curentTransacion = curentSession.beginTransaction();
        return curentTransacion;
    }

    public static void closeTrazaction() {
        beginTransaction().commit();
    }


    @Override
    public List<Intern> findAll() {

        //  curentSession = getSessionFactiory().openSession();

        internList = opneSession().createQuery("SELECT c FROM Intern c", Intern.class).getResultList();

        System.err.println(internList);

        opneSession().close();
        getSessionFactiory().close();

        return internList;
    }

    @Override
    public void save(Intern intern) {
        System.err.println(intern);
        opneSession();
        beginTransaction();
        opneSession().save(intern);
        closeTrazaction();
        opneSession().close();
        getSessionFactiory().close();
        //internList.add(intern);
    }

    @Override
    public int getMaxID() {
        return internList
                .stream()
                .max(Comparator.comparingInt(Intern::getId))
                .get()
                .getId();
    }

    @Override
    public void delete(int id) {
        System.err.println(id);
        curentSession= opneSession();
        curentTransacion =beginTransaction();
        Intern theIntern = curentSession.get(Intern.class, id);
        System.err.println(theIntern);
        curentSession.delete(theIntern);
        curentTransacion.commit();
        curentSession.close();
        getSessionFactiory().close();
    }

    @Override
    public void update(Intern intern,int id) {
        System.err.println("Ipdate trans"+intern);
        curentSession=opneSession();
        curentTransacion=beginTransaction();
        System.err.println("test uptate tr"+intern);
        intern.setId(id);
        curentSession.saveOrUpdate(intern);
        curentTransacion.commit();
        curentSession.close();
        getSessionFactiory().close();

    }


    @Override
    public int getIdOfObjFromList(int id) {
        int index = 0;
        for (Intern i : internList
        ) {
            if (id == i.getId()) {
                index = internList.indexOf(i);
                break;
            }
        }
        return index;
    }

    @Override
    public Intern getObjectById(int id) {
        Intern theNewOne;
        opneSession();
      beginTransaction();
      theNewOne=opneSession().get(Intern.class,id);
      beginTransaction().commit();
      opneSession().close();

        System.err.println("Get Obj By ID: "+theNewOne);
      return theNewOne;


    }

    @Override
    public int ObjectIdFromList(Intern intern) {
        return internList.indexOf(intern);
    }


}
