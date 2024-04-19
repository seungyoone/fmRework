package deliverySpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import deliverySpringProject.command.CustomerCommand;
import deliverySpringProject.service.customer.CustomerRegistService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	CustomerRegistService customerRegistService;
	
	@GetMapping("customerForm")
	public String customerForm() {
		return "thymeleaf/customer/customerForm";
	}
	@PostMapping("customerRegist")
	public String customerRegist(CustomerCommand customerCommand) {
		customerRegistService.execute(customerCommand);
		return "redirect:/";
	}
}
