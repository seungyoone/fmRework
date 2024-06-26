package deliverySpringProject.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import deliverySpringProject.command.CustomerCommand;
import deliverySpringProject.domain.CustomerDTO;
import deliverySpringProject.mapper.CustomerMapper;

@Service
public class CustomerRegistService {
	@Autowired
	CustomerMapper customerMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(CustomerCommand customerCommand) {
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerAddr(customerCommand.getCustomerAddr());
		dto.setCustomerAddrDetail(customerCommand.getCustomerAddrDetail());
		dto.setCustomerBirth(customerCommand.getCustomerBirth());
		dto.setCustomerEmail(customerCommand.getCustomerEmail());
		dto.setCustomerId(customerCommand.getCustomerId());
		dto.setCustomerName(customerCommand.getCustomerName());
		dto.setCustomerPhone(customerCommand.getCustomerPhone());
		String customerPw = passwordEncoder.encode(customerCommand.getCustomerPw());
		dto.setCustomerPw(customerPw);
		customerMapper.customerRegist(dto);
	}
}
