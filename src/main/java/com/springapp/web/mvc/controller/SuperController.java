package com.springapp.web.mvc.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SuperController {
	
	@ModelAttribute("doStuff")
	public void doStuff() throws Exception {
    }

}
