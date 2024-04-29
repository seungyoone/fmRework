package deliverySpringProject.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.MenuDTO;
import deliverySpringProject.mapper.MenuMapper;
import deliverySpringProject.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class MenuDetailService {
	@Autowired
	ShopMapper shopMapper;
	@Autowired
	MenuMapper menuMapper;
	
	public void execute(HttpSession session, String menuName, String shopName, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String shopOwnerName=shopMapper.shopNameSelect(auth.getUserName());
			
		MenuDTO dto = new MenuDTO();
		dto.setShopName(shopOwnerName);
		dto = shopMapper.menuSelectOne(menuName, shopName);
		model.addAttribute("dto", dto);
	}
}
