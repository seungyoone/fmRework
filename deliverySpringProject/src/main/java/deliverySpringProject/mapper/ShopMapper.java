package deliverySpringProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import deliverySpringProject.domain.ShopDTO;

@Mapper
public interface ShopMapper {
	
	public void shopInsert(ShopDTO dto);
	
	public String shopNameSelect(String ownerName);
}
