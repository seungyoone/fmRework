package deliverySpringProject.service.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import deliverySpringProject.command.OwnerCommand;
import deliverySpringProject.domain.OwnerDTO;
import deliverySpringProject.mapper.OwnerMapper;

@Service
public class OwnerRegistService {
	@Autowired
	OwnerMapper ownerMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(OwnerCommand ownerCommand) {
		OwnerDTO dto = new OwnerDTO();
		dto.setOwnerName(ownerCommand.getOwnerName());
		dto.setOwnerId(ownerCommand.getOwnerId());
		String ownerPw=passwordEncoder.encode(ownerCommand.getOwnerPw());
		dto.setOwnerPw(ownerPw);
		dto.setOwnerPhone(ownerCommand.getOwnerPhone());
		dto.setOwnerNum(ownerCommand.getOwnerNum());
		dto.setOwnerEmail(ownerCommand.getOwnerEmail());
		dto.setOwnerBirth(ownerCommand.getOwnerBirth());
		ownerMapper.ownerRegist(dto);
	}
}
