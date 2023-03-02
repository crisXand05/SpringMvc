package com.chr.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/student")
public class StudentController {
	@RequestMapping("/register")
	public String showRegister(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "registerView";
	}
	@RequestMapping("/registerstudent")
	public String registerStudent(@ModelAttribute("student") Student student) {
		return "successRegister";
	}
}
