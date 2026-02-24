package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import vn.edu.hcmut.cse.adsoftweng.lab.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentWebController {

    @Autowired
    private StudentService service;

    // Trang danh sách
    @GetMapping
    public String getAllStudents(@RequestParam(required = false) String keyword,
                                 Model model) {

        List<Student> students;

        if (keyword != null && !keyword.isEmpty()) {
            students = service.searchByName(keyword);
        } else {
            students = service.getAll();
        }

        model.addAttribute("dsSinhVien", students);
        return "students/list";  
    }

    // Trang chi tiết
    @GetMapping("/{id}")
    public String getStudentDetail(@PathVariable String id, Model model) {
        Student student = service.getById(id);
        model.addAttribute("student", student);
        return "students/detail";
    }

    // Trang tạo mới
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("isEdit", false);
        return "students/form";
    }

    // Lưu sinh viên mới
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        service.save(student);
        return "redirect:/students";
    }

    // Trang chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Student student = service.getById(id);
        model.addAttribute("student", student);
        model.addAttribute("isEdit", true);
        return "students/form";
    }

    // Cập nhật
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable String id,
                                @ModelAttribute Student student) {
        service.save(student);
        return "redirect:/students";
    }

    // Xóa
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.delete(id);
        return "redirect:/students";
    }
}
