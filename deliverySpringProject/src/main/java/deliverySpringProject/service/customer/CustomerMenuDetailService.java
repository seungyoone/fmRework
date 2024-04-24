package deliverySpringProject.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import deliverySpringProject.domain.MenuDTO;
import deliverySpringProject.mapper.MenuMapper;
import deliverySpringProject.mapper.ShopMapper;

@Service
public class CustomerMenuDetailService {
	
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	ShopMapper shopMapper;
	
	public void execute(String menuName, String shopName,Model model) {
		
		MenuDTO dto = new MenuDTO();
		dto = menuMapper.menuSelectOne(menuName,shopName);
		model.addAttribute("dto",dto);
		
		String shopMin = shopMapper.shopMinSelect(shopName);
		model.addAttribute("shopMin",shopMin);
		
		
	}

}
