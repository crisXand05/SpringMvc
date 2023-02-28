package com.chr.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirtsController {
	
	@RequestMapping
	public String getPage() {
		return "pageExample";
	}
}
