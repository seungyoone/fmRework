package deliverySpringProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import deliverySpringProject.command.OwnerCommand;
import deliverySpringProject.command.ShopCommand;
import deliverySpringProject.service.menu.MenuDetailService;
import deliverySpringProject.service.owner.OwnerRegistService;
import deliverySpringProject.service.owner.OwnerShopDetailService;
import deliverySpringProject.service.owner.OwnerShopUpdateService;
import deliverySpringProject.service.owner.ShopRegistService;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("owner")
public class OwnerController {
	@Autowired
	ShopRegistService shopRegistService;
	@Autowired
	OwnerRegistService ownerRegistService;
	@Autowired
	OwnerShopDetailService ownerShopDetailService;
	@Autowired
	OwnerShopUpdateService ownerShopUpdateService;

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
		return "redirect:/";
	}
	
	@RequestMapping("shopInfo")
	public String shopInfo(HttpSession session,Model model){
		ownerShopDetailService.execute(session,model);
		return "thymeleaf/owner/shopInfo";
	}
	
	@GetMapping("shopUpdate")
	public String shopUpdate(HttpSession session,Model model) {
		ownerShopDetailService.execute(session,model);
		return "thymeleaf/owner/shopUpdate";
	}
	
	@PostMapping("shopModify")
	public String shopModify(ShopCommand shopCommand, BindingResult result, HttpSession session,Model model) {
		ownerShopUpdateService.execute(shopCommand, result, session, model);
		ownerShopDetailService.execute(session,model);
		return "redirect:shopInfo";
	}
}
