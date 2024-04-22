package deliverySpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import deliverySpringProject.command.CustomerCommand;
import deliverySpringProject.service.customer.CustomerRegistService;
import deliverySpringProject.service.customer.CustomerShopDetailService;
import deliverySpringProject.service.customer.CustomerShopListService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	CustomerRegistService customerRegistService;
	
	@Autowired
	CustomerShopListService customerShopListService;
	
	@Autowired
	CustomerShopDetailService customerShopDetailService;
	
	@GetMapping("customerForm")
	public String customerForm() {
		return "thymeleaf/customer/customerForm";
	}
	@PostMapping("customerRegist")
	public String customerRegist(CustomerCommand customerCommand) {
		customerRegistService.execute(customerCommand);
		return "redirect:/";
	}
	

	@RequestMapping("shopList")
	public String shopList(HttpSession session,Model model) {
		customerShopListService.execute(session, model);
		return "thymeleaf/customer/shopList";
	}

	@GetMapping("shopDetail")
	public String detail(String shopOwner,Model model) {
		customerShopDetailService.execute(shopOwner,model);
		return "thymeleaf/customer/shopDetailView";
	}
}
