package deliverySpringProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import deliverySpringProject.domain.CustomerDTO;

@Mapper
public interface CustomerMapper {
	public void customerRegist(CustomerDTO dto);
	
	public String customerAddrSelect(String userId);
	
	public CustomerDTO customerSelectOne(String customerId);
}
