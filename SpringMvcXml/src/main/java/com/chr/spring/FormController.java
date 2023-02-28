package com.chr.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	@RequestMapping("/formexample")
	public String showForm() {
		return "formExample";
	}
	
	@RequestMapping("/viewexample")
	public String showView() {
		return "viewExample";
	}
}
