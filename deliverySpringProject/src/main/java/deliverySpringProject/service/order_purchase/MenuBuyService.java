package deliverySpringProject.service.order_purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import deliverySpringProject.command.PurchaseCommand;
import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.CustomerDTO;
import deliverySpringProject.domain.PurchaseDTO;
import deliverySpringProject.domain.ShopDTO;
import deliverySpringProject.mapper.CustomerMapper;
import deliverySpringProject.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class MenuBuyService {
	@Autowired
	ShopMapper shopMapper;
	
	@Autowired
	CustomerMapper customerMapper;
	
	public void execute(PurchaseCommand purchaseCommand,HttpSession session,Model model) {
		PurchaseDTO pdto = new PurchaseDTO();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String customerId = auth.getUserId();
		CustomerDTO cdto = customerMapper.customerSelectOne(customerId);
		String shopName = purchaseCommand.getShopName();
		//System.out.println(shopName);
		ShopDTO shopdto = shopMapper.shopSelectOne(shopName);
		
		pdto.setCustomerAddr(cdto.getCustomerAddr());
		pdto.setCustomerAddrDetail(cdto.getCustomerAddrDetail());
		pdto.setCustomerName(cdto.getCustomerName());
		pdto.setCustomerPhone(cdto.getCustomerPhone());
		pdto.setMenuContent(purchaseCommand.getMenuContent());
		pdto.setMenuName(purchaseCommand.getMenuName());
		pdto.setQty(purchaseCommand.getQty());
		pdto.setTotalPrice(purchaseCommand.getTotalPrice());
		pdto.setOrderMessage(purchaseCommand.getOrderMessage());
		pdto.setPurchasePrice(Integer.parseInt(purchaseCommand.getTotalPrice())+shopdto.getShopDelivery());
		pdto.setShopName(purchaseCommand.getShopName());
		pdto.setShopDelivery(shopdto.getShopDelivery());
		
		model.addAttribute("pdto", pdto);
		
		
		
		
		
		
	} 
}
