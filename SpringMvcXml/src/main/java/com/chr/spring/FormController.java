package com.chr.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/basics")
public class FormController {
	@RequestMapping("/formexample")
	public String showForm() {
		return "formExample";
	}
	
	@RequestMapping("/viewexample")
	public String showView() {
		return "viewExample";
	}
	@RequestMapping("/formmodel")
	public String getFormModelView() {
		return "formForModelExample";
	}
	@PostMapping("/addmodel")
	//public String addToModel(HttpServletRequest req, Model model) {
	public String addToModel(@RequestParam("name") String name, Model model) {
		//String name = req.getParameter("name");
		name += " agregado al modelo";
		model.addAttribute("parameter1", name);
		return "showModel";
	}
}
