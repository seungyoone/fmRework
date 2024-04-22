package deliverySpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.service.customer.CustomerShopListService;
import jakarta.servlet.http.HttpSession;

@Controller
@SpringBootApplication
public class DeliverySpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliverySpringProjectApplication.class, args);
	}
	

	
	@GetMapping("/")
	public String index(Model model) {
		int result = 2;
		
		model.addAttribute("result", result);
		return "thymeleaf/index";
	}

}
