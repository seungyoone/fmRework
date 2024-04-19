package deliverySpringProject.mapper;


import org.apache.ibatis.annotations.Mapper;

import deliverySpringProject.domain.OwnerDTO;

@Mapper
public interface OwnerMapper {
	
	public void ownerRegist(OwnerDTO dto);
	
	
}
