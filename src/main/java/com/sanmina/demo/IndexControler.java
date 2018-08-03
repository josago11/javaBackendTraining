package com.sanmina.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControler {
	@RequestMapping("/")
	public String getIndexPage() {
		return "index";
	}
}
