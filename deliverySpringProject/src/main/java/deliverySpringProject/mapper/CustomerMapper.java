package deliverySpringProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import deliverySpringProject.domain.CustomerDTO;

@Mapper
public interface CustomerMapper {
	public void customerRegist(CustomerDTO dto);
}
