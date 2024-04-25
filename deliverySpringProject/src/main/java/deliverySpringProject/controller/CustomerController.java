package deliverySpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import deliverySpringProject.command.CustomerCommand;
import deliverySpringProject.command.RecruitCommand;
import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.MenuDTO;
import deliverySpringProject.domain.RecruitDTO;
import deliverySpringProject.mapper.MenuMapper;
import deliverySpringProject.mapper.ShopMapper;
import deliverySpringProject.service.customer.CustomerMenuDetailService;
import deliverySpringProject.service.customer.CustomerRegistService;
import deliverySpringProject.service.customer.CustomerShopDetailService;
import deliverySpringProject.service.customer.CustomerShopListService;
import deliverySpringProject.service.recruit.RecruitRegistService;
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

	@Autowired
	CustomerMenuDetailService customerMenuDetailService;

	@Autowired
	RecruitRegistService recruitRegistService;

	@Autowired
	ShopMapper shopMapper;

	@Autowired
	MenuMapper menuMapper;

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
	public String shopList(HttpSession session, Model model) {
		customerShopListService.execute(session, model);
		return "thymeleaf/customer/shopList";
	}

	@GetMapping("shopDetail")
	public String detail(String shopOwner, Model model) {
		customerShopDetailService.execute(shopOwner, model);
		return "thymeleaf/customer/shopDetailView";
	}

	@RequestMapping("menuDetail")
	public String menuDetail(String menuName, String shopName, Model model) {
		customerMenuDetailService.execute(menuName, shopName, model);
		model.addAttribute("shopName", shopName);
		return "thymeleaf/customer/menuDetailView";
	}

	@RequestMapping("directOrder")
	public String directOrder(String qty, String totalPrice, String menuName, String shopName) {
		return "thymeleaf/customer/directOrder";
	}

	@RequestMapping("recruitOrder")
	public String recruitOrder(String qty, String totalPrice, String menuName, String shopName, String shopMin,
			HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		MenuDTO mdto = menuMapper.menuSelectOne(menuName, shopName);
		model.addAttribute("mdto", mdto);
		model.addAttribute("auth", auth);
		model.addAttribute("menuName", menuName);
		model.addAttribute("qty", qty);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("shopMin", shopMin);
		int restPrice = Integer.parseInt(shopMin) - Integer.parseInt(totalPrice);
		model.addAttribute("restPrice", restPrice);

		return "thymeleaf/recruit/recruitForm";
	}

	@RequestMapping("registRecruit")
	public String registRecruit(RecruitCommand recruitCommand, Model model) {
		recruitRegistService.execute(recruitCommand, model);

		return "thymeleaf/recruit/recruitInfo";
	}
}
