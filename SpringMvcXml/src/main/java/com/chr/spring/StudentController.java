package com.chr.spring;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String registerStudent(@Valid @ModelAttribute("student") Student student, BindingResult validation) {
		if(validation.hasErrors()) {
			return "registerView";
		}
		return "successRegister";
	}
}
