package com.endava.controller;

import com.endava.enity.Field;
import com.endava.enity.Student;
import com.endava.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;
//http://j4sq.blogspot.com/2011/09/jstl-jsp-standard-tag-library.html
@org.springframework.stereotype.Controller
@EnableWebMvc
@RequestMapping("/")
public class Controller {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm() {
        return "show_form";
    }

    @RequestMapping(value = "/procesForm", method = RequestMethod.POST)
    public String procesFormVersionTwo(@RequestParam("studentName") String studentName,
                                       @RequestParam("lastName") String lastName, Model theModel) {

        //  studentName = studentName.toUpperCase();
        //  String result = "Yo " + studentName;
        String firstName = studentName;
        String lastN = lastName;

        studentService.add(new Student(firstName, lastN));
        System.out.println(studentService.getAllStudents());

        return "show_form";
    }


//    @RequestMapping(value = "/display", method = RequestMethod.GET)
//    public String procesForm(Model theModel) {
//
//        theModel.addAttribute("message1", studentService.getAllStudents());
//
//        return "proces_form";
//    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public ModelAndView getdata() {

        List<String> list = studentService.getAllStudents();
        System.out.println(list);
        //return back to index.jsp
        ModelAndView model = new ModelAndView("proces_form");
        model.addObject("lists", list);

        return model;

    }
//
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public ModelAndView get() {
//
//        List<String> list = getList();
//
//        //return back to index.jsp
//        ModelAndView model = new ModelAndView("test");
//        model.addObject("lists", list);
//
//        return model;
//
//    }

    private List<String> getList() {

        List<String> list = new ArrayList<String>();
        list.add("List A");
        list.add("List B");
        list.add("List C");
        list.add("List D");
        list.add("List 1");
        list.add("List 2");
        list.add("List 3");

        return list;

//
//    @RequestMapping(value = "/showForm",method = RequestMethod.GET)
//    public String showForm() {
//        return "show_form";
//    }
//
//    @RequestMapping(value = "/procesForm",method = RequestMethod.GET)
//    public String procesForm() {
//        return "proces_form";
//    }
//
//    @RequestMapping(value = "/procesFormTwo",method = RequestMethod.GET)
//    public String procesFormVersionTwo(@RequestParam("studentName")String studentName, Model theModel){
//
//
//        studentName =studentName.toUpperCase();
//        String  result="Yo "+studentName;
//        theModel.addAttribute("message",result);
//        return "helloworld";

    }
}


