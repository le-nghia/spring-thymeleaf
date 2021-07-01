package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.entity.Student;
import com.example.demothymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getAll(Model model){
//        model.addAttribute("student", studentService.getAll());
        return findPaginated(1, model);
    }

    @RequestMapping(value = "/add")
    public String addUser(Model model){
        model.addAttribute("student",new Student());
        return "addStudent";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Long id, Model model ){
        Optional<Student> studentEdit = studentService.findUserById(id);
        studentEdit.ifPresent(student -> model.addAttribute("student",student));

        return "editStudent";
    }

    @RequestMapping(value = "/findId", method = RequestMethod.GET)
    public String find(@Param("keyword") String keyword, Model model){
        if(keyword == null){
            return findPaginated(1,model);
        }else {
            List<Student> student = studentService.searchUser(keyword);
            model.addAttribute("student",student);
        }
        return "find";
    }
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(@Valid Student user, BindingResult bindingResult, RedirectAttributes model){
        if (bindingResult.hasErrors()){
            return "addStudent";
        }else {
            studentService.saveStudent(user);
            model.addFlashAttribute("success","Thêm mới thành công!");
            return "redirect:/";
        }
    }
    @RequestMapping(value = "saveUpdate", method = RequestMethod.POST)
    public String saveUpdate(@Valid Student user, BindingResult bindingResult, RedirectAttributes model){
        if (bindingResult.hasErrors()){
            return "addStudent";
        }else{
            studentService.saveStudent(user);
            model.addFlashAttribute("success","Cập nhật thành công!");
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Long id, RedirectAttributes model){
        studentService.deleteUser(id);
        model.addFlashAttribute("success","Xóa thành công !");
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    private String findPaginated(@PathVariable("pageNo") int pageNo, Model model) {
        int pageSize = 3;

        Page<Student> page = studentService.findPaginated(pageNo,pageSize);
        List<Student> students = page.getContent();

        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("student",students);

        return "index";
    }
}
