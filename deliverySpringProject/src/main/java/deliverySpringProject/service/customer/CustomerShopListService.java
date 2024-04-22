package deliverySpringProject.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.ShopDTO;
import deliverySpringProject.mapper.CustomerMapper;
import deliverySpringProject.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class CustomerShopListService {
	@Autowired
	ShopMapper shopMapper;
	@Autowired
	CustomerMapper customerMapper;
	
	public void execute(HttpSession session,Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String customerAddr = customerMapper.customerAddrSelect(auth.getUserId());
		System.out.println(customerAddr);
		List<ShopDTO> list = shopMapper.shopSelectList(customerAddr);
		model.addAttribute("dtos",list);
	}
	
	
}
