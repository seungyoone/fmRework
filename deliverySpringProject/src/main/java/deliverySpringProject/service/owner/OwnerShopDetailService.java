package deliverySpringProject.service.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.ShopDTO;
import deliverySpringProject.mapper.ShopMapper;
import deliverySpringProject.service.customer.CustomerMenuListService;
import jakarta.servlet.http.HttpSession;

@Service
public class OwnerShopDetailService {

	@Autowired
	ShopMapper shopMapper;
	
	@Autowired
	CustomerMenuListService customerMenuListService;
	
	public void execute(HttpSession session,Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String shopOwnerId = auth.getUserName();
		
		ShopDTO dto = new ShopDTO();
		dto = shopMapper.shopSelectOne(shopOwnerId);
		customerMenuListService.execute(dto.getShopName(),model);
		model.addAttribute("dto",dto);
	}
}
