package com.kiranacadm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Hello {
@RequestMapping("abcs")
	public String test() {
		return "My first api";
		
	}
}
