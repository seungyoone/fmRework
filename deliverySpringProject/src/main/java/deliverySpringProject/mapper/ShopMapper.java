package deliverySpringProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import deliverySpringProject.domain.ShopDTO;

@Mapper
public interface ShopMapper {
	
	public void shopInsert(ShopDTO dto);
	
	public String shopNameSelect(String ownerName);
	
	public List<ShopDTO> shopSelectList(String customerAddr);

	public ShopDTO shopSelectOne(String shopOwner);
}
