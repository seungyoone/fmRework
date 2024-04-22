package deliverySpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import deliverySpringProject.command.LoginCommand;
import deliverySpringProject.service.customer.CustomerShopListService;
import deliverySpringProject.service.login.UserLoginService;
import deliverySpringProject.service.login.UserLogoutService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	UserLoginService userLoginService;
	
	@Autowired
	UserLogoutService userLogoutService;
	
	
	@PostMapping("login")
	public String login(LoginCommand loginCommand,HttpSession session,Model model) {
		int result = userLoginService.execute(loginCommand,session,model);//성공시 1, 실패시 0
		model.addAttribute("result", result);
		return "redirect:/";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		
		userLogoutService.execute(session);
		return "redirect:/";
	}
}
