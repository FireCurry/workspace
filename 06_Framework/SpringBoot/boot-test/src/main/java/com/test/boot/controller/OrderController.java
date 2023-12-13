package com.test.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

	@PostMapping("orderProduct.do")
	public String order(Model model,@RequestParam("blackPen") int blackPen,@RequestParam("redPen") int redPen,@RequestParam("bluePen") int bluePen 
			,@RequestParam("white") int white ,@RequestParam("name") String name) {
		
		int total = blackPen * 500 + redPen * 700 + bluePen * 700 + white * 1000;
		
		if(total == 0) {
			return "redirect:error.do";
		} else {
			model.addAttribute("blackPen", blackPen);
			model.addAttribute("redPen", redPen);
			model.addAttribute("bluePen", bluePen);
			model.addAttribute("white", white);
			model.addAttribute("total", total);
			model.addAttribute("name", name);
		}
		return "resultPage";
	}
	
	@GetMapping("error.do")
	public String error() {
		return "errorPage";
	}
}
