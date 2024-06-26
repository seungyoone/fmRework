package deliverySpringProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import deliverySpringProject.domain.MenuDTO;
import deliverySpringProject.domain.ShopDTO;

@Mapper
public interface ShopMapper {
	
	public void shopInsert(ShopDTO dto);
	
	public String shopNameSelect(String ownerName);
	
	public List<ShopDTO> shopSelectList(String customerAddr);

	public ShopDTO shopSelectOne(String shopOwnerNameorIdorshopName);
	
	public List<MenuDTO> menuSelectList(String shopName);
	
	public int shopUpdate(ShopDTO dto);
	
	public String shopMinSelect(String shopName);
	
	public MenuDTO menuSelectOne(String menuName, String shopName);
	
	public String ShopNameByOwner(String shopOwnerName);
	
	public String getShopOwnerId(String shopName);
	
}
