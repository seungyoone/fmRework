package deliverySpringProject.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import deliverySpringProject.domain.ShopDTO;
import deliverySpringProject.mapper.ShopMapper;

@Service
public class CustomerShopDetailService {
	
	@Autowired
	ShopMapper shopMapper;
	
	@Autowired
	CustomerMenuListService customerMenuListService;
	
	public void execute(String shopOwnerId,Model model) {
		ShopDTO dto = new ShopDTO();
		dto = shopMapper.shopSelectOne(shopOwnerId);
		customerMenuListService.execute(dto.getShopName(),model);
		model.addAttribute("dto",dto);
		
		
		
	}
}
