package deliverySpringProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import deliverySpringProject.command.OwnerCommand;
import deliverySpringProject.command.ShopCommand;
import deliverySpringProject.service.owner.OwnerRegistService;
import deliverySpringProject.service.owner.ShopRegistService;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("owner")
public class OwnerController {
	@Autowired
	ShopRegistService shopRegistService;
	@Autowired
	OwnerRegistService ownerRegistService;

	@GetMapping("ownerForm")
	public String ownerForm() {
		return "thymeleaf/owner/ownerForm";
	}
	
	@PostMapping("ownerRegist")
	public String ownerRegist(OwnerCommand ownerCommand) {
		ownerRegistService.execute(ownerCommand);
		return "redirect:/";
	}
	
	@GetMapping("shopForm")
	public String shopForm() {
		return "thymeleaf/owner/shopForm";
	}
	
	@PostMapping("shopRegist")
	public String shopRegist(ShopCommand shopCommand,HttpSession session) {
		shopRegistService.execute(shopCommand,session);
		return "";
	}
	
}
