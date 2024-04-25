package deliverySpringProject.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.MenuDTO;
import deliverySpringProject.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class MenuDetailService {
	@Autowired
	ShopMapper shopMapper;
	
	public void execute(String menuName, String shopName, Model model) {
		MenuDTO dto = new MenuDTO();
		dto = shopMapper.menuSelectOne(menuName, shopName);
		model.addAttribute("dto", dto);
		
	}
}
