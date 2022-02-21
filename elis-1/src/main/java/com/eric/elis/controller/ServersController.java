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

import com.eric.elis.entity.Servers;
import com.eric.elis.exception.ServersNotFoundException;
import com.eric.elis.service.IEnvironmentService;
import com.eric.elis.service.IServersService;

@Controller
@RequestMapping("/servers")
public class ServersController {
	@Autowired
	private IServersService service;
	
	@Autowired
	private IEnvironmentService envService;
	
	private void createDynamicUi(Model model) {
		model.addAttribute("environments", envService.getEnvIdAndName());
	}

	@GetMapping("/register")
	public String registerServers(Model model) {
		model.addAttribute("servers",new Servers());
		createDynamicUi(model);
		return "ServersRegister";
	}

	@PostMapping("/save")
	public String saveServers(@ModelAttribute Servers servers, Model model) {
		java.lang.Long id=service.saveServers(servers);
		model.addAttribute("message","Servers created with Id:"+id);
		model.addAttribute("servers",new Servers()) ;
		createDynamicUi(model);
		return "SaveServerRegister";
	}

	@GetMapping("/all")
	public String getAllServerss(Model model,
			@RequestParam(value = "message", required = false) String message) {
		List<Servers> list=service.getAllServerss();
		model.addAttribute("list",list);
		model.addAttribute("message",message);
		return "ServersData";
	}

	@GetMapping("/delete")
	public String deleteServers(@RequestParam Long id, RedirectAttributes attributes) {
		try {
			service.deleteServers(id);
			attributes.addAttribute("message","Servers deleted with Id:"+id);
		} catch(ServersNotFoundException e) {
			e.printStackTrace() ;
			attributes.addAttribute("message",e.getMessage());
		}
		return "redirect:all";
	}

	@GetMapping("/edit")
	public String editServers(@RequestParam Long id, Model model, RedirectAttributes attributes) {
		String page=null;
		try {
			Servers ob=service.getOneServers(id);
			model.addAttribute("servers",ob);
			page="ServersEdit";
		} catch(ServersNotFoundException e) {
			e.printStackTrace() ;
			attributes.addAttribute("message",e.getMessage());
			page="redirect:all";
		}
		return page;
	}

	@PostMapping("/update")
	public String updateServers(@ModelAttribute Servers servers, RedirectAttributes attributes) {
		service.updateServers(servers);
		attributes.addAttribute("message","Servers updated");
		return "redirect:all";
	}
	
	@GetMapping("/search")
	public String getServersByEnvironment(
			Model model) {
		createDynamicUi(model);
		return "Search";
	}
	
	@GetMapping("/view")
	public String getServersByEnvironment(
			@RequestParam(required = false, defaultValue = "0") Long envName,
			Model model) {
		/*
		 * System.out.println(envName); Environment env =
		 * envService.getEnvironmentIdByEnvName(envName);
		 */
		List<Object[]> list=service.getServersByEnvironment(envName);
		System.out.println("getting data");
		list.forEach(row->{
			for(Object obj:row) {
				System.out.println(obj);
			}	
		});
		//System.out.println(list.get(1));
		model.addAttribute("list",list);
		createDynamicUi(model);
		return "ServersSearch";
	}
}
