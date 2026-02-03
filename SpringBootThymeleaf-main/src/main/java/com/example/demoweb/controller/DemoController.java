package com.example.demoweb.controller;

import com.example.demoweb.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    @GetMapping("/demo")
    public String demo(Model model) {
        // Truyền dữ liệu qua Model với phương thức addAttribute
        
        // 1. Truyền String
        model.addAttribute("message", "Welcome Thymeleaf!");
        
        // 2. Truyền số
        model.addAttribute("number", 42);
        
        // 3. Truyền boolean
        model.addAttribute("isActive", true);
        
        // 4. Truyền một Student object
        Student student = new Student(1, "Nguyễn Văn A", 20);
        model.addAttribute("student", student);
        
        // 5. Truyền danh sách Students
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nguyễn Văn A", 20));
        students.add(new Student(2, "Trần Thị B", 22));
        students.add(new Student(3, "Lê Văn C", 21));
        students.add(new Student(4, "Phạm Thị D", 23));
        model.addAttribute("students", students);
        
        // 6. Truyền array
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        model.addAttribute("colors", colors);
        
        // 7. Truyền URL
        model.addAttribute("url", "https://www.thymeleaf.org");
        
        return "demo";
    }
}

