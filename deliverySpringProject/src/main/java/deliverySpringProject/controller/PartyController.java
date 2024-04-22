package deliverySpringProject.controller;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Alias("party")
public class PartyController {
	@GetMapping("party")
	public String party() {
		return "thymeleaf/party/customerParty";
	}
}
