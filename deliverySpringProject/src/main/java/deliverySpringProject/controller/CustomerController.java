package deliverySpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import deliverySpringProject.command.CustomerCommand;
import deliverySpringProject.command.PurchaseCommand;
import deliverySpringProject.command.RecruitCommand;
import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.MenuDTO;
import deliverySpringProject.mapper.MenuMapper;
import deliverySpringProject.mapper.ShopMapper;
import deliverySpringProject.service.IniPayReqService;
import deliverySpringProject.service.customer.CustomerMenuDetailService;
import deliverySpringProject.service.customer.CustomerRegistService;
import deliverySpringProject.service.customer.CustomerShopDetailService;
import deliverySpringProject.service.customer.CustomerShopListService;
import deliverySpringProject.service.order_purchase.MenuBuyService;
import deliverySpringProject.service.recruit.RecruitDetailService;
import deliverySpringProject.service.recruit.RecruitListService;
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
	RecruitListService recruitListService;

	@Autowired
	RecruitDetailService recruitDetailService;
	
	@Autowired
	IniPayReqService iniPayReqService;
	
	
	@Autowired
	ShopMapper shopMapper;

	@Autowired
	MenuMapper menuMapper;
	
	@Autowired
	MenuBuyService menuBuyService;
	
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
	public String detail(String shopOwnerId, Model model) {
		customerShopDetailService.execute(shopOwnerId, model);
		return "thymeleaf/customer/shopDetailView";
	}

	@RequestMapping("menuDetail")
	public String menuDetail(String menuName, String shopName, Model model) {
		customerMenuDetailService.execute(menuName, shopName, model);
		model.addAttribute("shopName", shopName);
		return "thymeleaf/customer/menuDetailView";
	}

	@RequestMapping("directOrder")
	public String directOrder(PurchaseCommand purchaseCommand,HttpSession session,Model model) {
		menuBuyService.execute(purchaseCommand,session,model);
		return "thymeleaf/customer/directOrder";
	}
	
	@RequestMapping("menuOrder")
	public String menuOrder(PurchaseCommand purchaseCommand,Model model)throws Exception {
		iniPayReqService.execute(purchaseCommand, model);
		return "thymeleaf/customer/payment";
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
	public String registRecruit(RecruitCommand recruitCommand, Model model,HttpSession session) {
		recruitRegistService.execute(recruitCommand, model);
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String userId = auth.getUserId();
		model.addAttribute("userId", userId);
		return "thymeleaf/recruit/recruitInfo";
	}
	
	@RequestMapping("recruitList")
	public String recruitList(HttpSession session,Model model) {
		recruitListService.execute(session,model);
		return "thymeleaf/recruit/recruitList";
	}
	
	@RequestMapping("recruitDetail")
	public String recruitDetail(String boardWriter,Model model) {
		recruitDetailService.execute(boardWriter,model);
		return "thymeleaf/recruit/recruitDetail";
	}
	
	@RequestMapping("recruitAttend")
	public String recruitAttend(String shopName,HttpSession session,Model model) {
		System.out.println(shopName);
		String shopOwnerId = shopMapper.getShopOwnerId(shopName);
		customerShopDetailService.execute(shopOwnerId, model);
		return "thymeleaf/customer/shopAttendView";
	}
	
	@RequestMapping("menuAttendDetail")
	public String menuAttendDetail(String menuName, String shopName, Model model) {
		customerMenuDetailService.execute(menuName, shopName, model);
		model.addAttribute("shopName", shopName);
		return "thymeleaf/customer/menuAttendView";
	}
}
