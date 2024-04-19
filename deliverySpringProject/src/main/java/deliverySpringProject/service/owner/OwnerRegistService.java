package deliverySpringProject.service.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deliverySpringProject.command.OwnerCommand;
import deliverySpringProject.domain.OwnerDTO;
import deliverySpringProject.mapper.OwnerMapper;

@Service
public class OwnerRegistService {
	@Autowired
	OwnerMapper ownerMapper;
	
	public void execute(OwnerCommand ownerCommand) {
		OwnerDTO dto = new OwnerDTO();
		dto.setOwnerName(ownerCommand.getOwnerName());
		dto.setOwnerId(ownerCommand.getOwnerId());
		dto.setOwnerPw(ownerCommand.getOwnerPw());
		dto.setOwnerPhone(ownerCommand.getOwnerPhone());
		dto.setOwnerNum(ownerCommand.getOwnerNum());
		dto.setOwnerEmail(ownerCommand.getOwnerEmail());
		dto.setOwnerBirth(ownerCommand.getOwnerBirth());
		ownerMapper.ownerRegist(dto);
	}
}
