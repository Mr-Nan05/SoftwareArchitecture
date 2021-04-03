package com.nan.manager.controller;

import javax.validation.Valid;


import com.nan.manager.model.Student;
import com.nan.manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller // This means that this class is a Controller
@RequestMapping(path="/manager") // This means URL's start with /demo (after Application path)
public class StudentController {

    private final StudentService studentService;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


//    @InitBinder
//    public void setAllowedFields(WebDataBinder dataBinder) {
//        dataBinder.setDisallowedFields("id");
//    }

    @GetMapping("/")
    public String Welcome(){
        return "home_page";
    }

    @GetMapping("/add")
    public String addNewStudent(Model student) {
        student.addAttribute("student", new Student());
        return "add_student";
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public String addNewStudent (@ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        } else {
            try {
                studentService.saveStudent(student);
            } catch (Exception exception){
                return "error";
            }
        }
        return "redirect:/manager/select_by_id/?id=" + student.getId();
    }

    @GetMapping("/update")
    public String alterStudent(Model student) {
        student.addAttribute("student", new Student());
        return "update_student";
    }

    @PostMapping(path="/update")
    public String alterStudent(@ModelAttribute Student student, BindingResult result){
        if (result.hasErrors()) {
            return "error";
        } else {
            try {
                System.out.println("update student:"+student.getId());
                studentService.updateStudent(student);

            } catch (Exception exception){
                System.out.println("something wrong:" + exception.toString());
                return "error";
            }
            return "redirect:/manager/select_by_id/?id=" + student.getId();
        }
    }

    @GetMapping("/select")
    public String selectStudent(Model student) {
        student.addAttribute("student", new Student());
        return "select_student";
    }

    @PostMapping("/select")
    public String selectStudent(@ModelAttribute Student student) {
        if(student.getId() != null)
            return "redirect:/manager/select_by_id/?id=" + student.getId();
        if(student.getName() != null)
            return "redirect:/manager/select_by_name/?name=" + student.getName();
        return "error";
    }

    @GetMapping(path="/select_by_id")
    public  @ResponseBody Iterable<Student> selectStudentById(@RequestParam Integer id){
        return studentService.findStudentById(id);
    }

    @GetMapping(path="/select_by_name")
    public  @ResponseBody Iterable<Student> selectStudentByName(@RequestParam String name){
        return studentService.findStudentByName(name);
    }

    @GetMapping("/delete")
    public String deleteStudent(Model student) {
        student.addAttribute("student", new Student());
        return "delete_student";
    }

    @PostMapping(path="/delete")
    public String deleteStudent(@ModelAttribute Student student){
        if(studentService.deleteStudent(student.getId()))
            return "redirect:/manager/students";
        return "error";
    }

    @GetMapping(path="/students")
    public @ResponseBody Iterable<Student> getAllStudents() {
        return studentService.findAllStudents();
    }
    // clear all cache using cache manager
    @RequestMapping(value = "clearCache")
    public void clearCache() {
        for (String name : cacheManager.getCacheNames()) {
            cacheManager.getCache(name).clear();
        }
    }
}
