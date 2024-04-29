package deliverySpringProject.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.MenuDTO;
import deliverySpringProject.mapper.MenuMapper;
import deliverySpringProject.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class MenuDeleteService {
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	ShopMapper shopMapper;
	public void execute(String menuName, String shopName) {
		menuMapper.menuDelete(menuName, shopName);
	}
}
