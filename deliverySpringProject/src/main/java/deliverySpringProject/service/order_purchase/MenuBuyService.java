package deliverySpringProject.service.order_purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deliverySpringProject.mapper.MenuMapper;

@Service
public class MenuBuyService {
	@Autowired
	MenuMapper menuMapper;
	
	public void execute(String qty, String totalPrice, String menuName, String shopName) {
		
	} 
}
