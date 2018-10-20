package com.learn.algos.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.learn.algos.entity.Setting;

@Controller
public class HomeController {

    @GetMapping("/showHome")
    public String showHome(Model model) {
	Setting attributeValue = new Setting();
	model.addAttribute("setting", attributeValue);
	return "home";
    }

    @ModelAttribute("countryList")
    public Map<String, String> getCountryList() {
	Map<String, String> countryList = new HashMap<String, String>();
	countryList.put("US", "United States");
	countryList.put("CH", "China");
	countryList.put("SG", "Singapore");
	countryList.put("MY", "Malaysia");
	return countryList;
    }
}
