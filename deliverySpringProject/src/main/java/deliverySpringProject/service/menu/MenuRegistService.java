package deliverySpringProject.service.menu;

import org.springframework.stereotype.Service;

import deliverySpringProject.command.MenuCommand;
import deliverySpringProject.domain.MenuDTO;
import jakarta.servlet.http.HttpSession;

@Service
public class MenuRegistService {
	public void execute(MenuCommand menuCommand, HttpSession session) {
		MenuDTO dto = new MenuDTO();
		dto.setMenuExplain(menuCommand.getMenuExplain());
		dto.setMenuName(menuCommand.getMenuName());
		dto.setMenuPrice(menuCommand.getMenuPrice());
		dto.setShopName(menuCommand.getShopName());
		
	}
}
