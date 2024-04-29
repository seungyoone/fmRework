package deliverySpringProject.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deliverySpringProject.command.MenuCommand;
import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.MenuDTO;
import deliverySpringProject.mapper.MenuMapper;
import deliverySpringProject.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class MenuUpdateService {
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	ShopMapper shopMapper;
	
	public void execute(MenuCommand menuCommand, HttpSession session) {
		MenuDTO dto = new MenuDTO();
		dto.setMenuName(menuCommand.getMenuName());
		dto.setMenuExplain(menuCommand.getMenuExplain());
		dto.setMenuPrice(menuCommand.getMenuPrice());
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String shopName = shopMapper.shopNameSelect(auth.getUserName());
		dto.setShopName(shopName);
		
		menuMapper.menuUpdate(dto);
	}
}
