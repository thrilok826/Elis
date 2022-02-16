package com.eric.elis.controller;

import java.lang.Long;
import java.lang.String;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eric.elis.entity.Environment;
import com.eric.elis.exception.EnvironmentNotFoundException;
import com.eric.elis.service.IEnvironmentService;

@Controller
@RequestMapping("/environment")
public class EnvironmentController {
	@Autowired
	private IEnvironmentService service;

	@GetMapping("/register")
	public String registerEnvironment(Model model) {
		model.addAttribute("environment", new Environment());
		return "EnvironmentRegister";
	}

	@PostMapping("/save")
	public String saveEnvironment(@ModelAttribute Environment environment, Model model) {
		java.lang.Long id = service.saveEnvironment(environment);
		model.addAttribute("message", "Environment created with Id:" + id);
		model.addAttribute("environment", new Environment());
		return "EnvironmentRegister";
	}

	@GetMapping("/all")
	public String getAllEnvironments(Model model, @RequestParam(value = "message", required = false) String message) {
		List<Environment> list = service.getAllEnvironments();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "EnvironmentData";
	}

	@GetMapping("/delete")
	public String deleteEnvironment(@RequestParam Long id, RedirectAttributes attributes) {
		try {
			service.deleteEnvironment(id);
			attributes.addAttribute("message", "Environment deleted with Id:" + id);
		} catch (EnvironmentNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}
		return "redirect:all";
	}

	@GetMapping("/edit")
	public String editEnvironment(@RequestParam Long id, Model model, RedirectAttributes attributes) {
		String page = null;
		try {
			Environment ob = service.getOneEnvironment(id);
			model.addAttribute("environment", ob);
			page = "EnvironmentEdit";
		} catch (EnvironmentNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:all";
		}
		return page;
	}

	@PostMapping("/update")
	public String updateEnvironment(@ModelAttribute Environment environment, RedirectAttributes attributes) {
		service.updateEnvironment(environment);
		attributes.addAttribute("message", "Environment updated");
		return "redirect:all";
	}
}
