package deliverySpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import deliverySpringProject.command.MenuCommand;
import deliverySpringProject.service.menu.MenuDetailService;
import deliverySpringProject.service.menu.MenuRegistService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("menu")
public class MenuController {
	@GetMapping("menuForm")
	public String menuForm() {
		return "thymeleaf/menu/menuForm";
	}
	
	@Autowired
	MenuRegistService menuRegistService;
	@PostMapping("menuRegist")
	public String menuRegist(MenuCommand menuCommand,HttpSession session) {
		menuRegistService.execute(menuCommand,session);
		return "redirect:/";
	}
	
	@Autowired
	MenuDetailService menuDetailService;
	@GetMapping("menuUpdate")
	public String menuUpdate(String menuName, String shopName, Model model) {
		menuDetailService.execute(menuName, shopName, model);
		return "thymeleaf/owner/menuModify";
	}
	
	@PostMapping("menuModify")
	public String menuModify() {
		return "";
	}
}
