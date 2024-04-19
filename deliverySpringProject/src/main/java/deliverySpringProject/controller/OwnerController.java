package deliverySpringProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import deliverySpringProject.service.owner.ShopRegistService;



@Controller
@RequestMapping("owner")
public class OwnerController {
	
	@Autowired
	ShopRegistService shopRegistService;

	@GetMapping("ownerRegist")
	public String ownerRegist() {
		return "thymeleaf/owner/ownerRegist";
	}
	
	@GetMapping("shopRegist")
	public String shopRegist() {
		return "thymeleaf/owner/shopRegist";
	}
}