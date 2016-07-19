package com.jasper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Home {
	@RequestMapping(value="/")
	public String home(Model model) {
		
		return "index";
	}
	@RequestMapping(value="/report")
	public String dashboard(Model model) {
		
		return "dashboard";
	}
}
