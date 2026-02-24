package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import vn.edu.hcmut.cse.adsoftweng.lab.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // 1. API Lấy danh sách
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAll();
    }

    // 2. API Lấy chi tiết
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return service.getById(id);
    }
}
