package com.hihar.service1.controller;

import com.hihar.AbstractController;
import com.hihar.service1.client.Service0Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 */
@RestController
public class Service1Controller extends AbstractController {
    public static class User {
        private int id;
        private String name;

        private Student student;

        public User() {
        }

        public int getId() {
            return id;
        }

        public User setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }

        public Student getStudent() {
            return student;
        }

        public User setStudent(Student student) {
            this.student = student;
            return this;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", student=" + student +
                    '}';
        }
    }

    public static class Student {
        private String stuName;

        public Student() {
        }

        public String getStuName() {
            return stuName;
        }

        public Student setStuName(String stuName) {
            this.stuName = stuName;
            return this;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "stuName='" + stuName + '\'' +
                    '}';
        }
    }

    @Autowired
    Service0Client service0Client;

    @GetMapping("/test/{sleepSec}")
    public String test(
            @PathVariable int sleepSec
    ) {
//        if (1 == 1) {
//            System.out.println(333);
//            throw new RuntimeException("111111111111");
//        }
        return service0Client.test("leo", sleepSec);
    }

    @GetMapping("user")
    public User test() {
//        if (1 == 1) {
//            System.out.println(333);
//            throw new RuntimeException("111111111111");
//        }
        Student stuName = new Student()
                .setStuName("stuName");
        User asd = new User()
                .setId(0)
                .setName("asd")
                .setStudent(stuName);

//        System.out.println(asd.toString());
        return asd;
    }
}
