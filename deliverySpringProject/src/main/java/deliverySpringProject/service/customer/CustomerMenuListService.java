package deliverySpringProject.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import deliverySpringProject.domain.MenuDTO;
import deliverySpringProject.mapper.ShopMapper;

@Service
public class CustomerMenuListService {
	
	@Autowired
	ShopMapper shopMapper;
	
	public void execute(String shopName,Model model) {
		List<MenuDTO> list = shopMapper.menuSelectList(shopName);
		model.addAttribute("list",list);
	}
}
