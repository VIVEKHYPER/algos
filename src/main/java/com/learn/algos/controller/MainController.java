package com.learn.algos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// @RequestMapping("/")
public class MainController {

    @GetMapping("/showMain")
    public String showHome(Model model) {
	return "main";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(Model model) {
	return "plain-login";
    }

    @GetMapping("/access-denied")
    public String accessDeniedpage(Model model) {
	return "access-denied";
    }
}
