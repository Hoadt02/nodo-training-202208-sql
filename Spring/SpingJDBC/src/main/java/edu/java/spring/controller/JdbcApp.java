package edu.java.spring.controller;

import edu.java.spring.DAO.StudentJdbcDAO;
import edu.java.spring.model.Student;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JdbcApp {
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(JdbcApp.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
//        jdbc.insert("Đỗ Tất Hòa", 20);
//        LOGGER.info("create bean " + jdbc);

//        LOGGER.info("Total student is " + jdbc.totalRecord());

//        jdbc.loadStudent("A").forEach(student -> {LOGGER.info(student);});

//        jdbc.updateAgeByName("Đỗ Tất Hòa", 22);

//        jdbc.deleteStudent(1);
//        LOGGER.info("delete student id: " + jdbc);

//        List<Student> students = new ArrayList<>();
//        students.add(new Student("Do Tat Hoa", 20));
//        students.add(new Student("Thieu Quang Vinh", 22));
//        students.add(new Student("Nguyen Hong Son", 24));
//
//        int[] values = jdbc.add(students);
//
//        for (int i = 0; i < values.length; i++) {
//            LOGGER.info("add record " + i + ": " + (values[i] == 0 ? "failed":"success"));
//        }
//
//        LOGGER.info("Totabl students is: " + jdbc.totalRecord());

        jdbc.save("DO HOA",56);
    }
}
