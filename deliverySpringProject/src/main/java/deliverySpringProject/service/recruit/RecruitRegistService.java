package deliverySpringProject.service.recruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import deliverySpringProject.command.RecruitCommand;
import deliverySpringProject.domain.RecruitDTO;
import deliverySpringProject.mapper.RecruitMapper;

@Service
public class RecruitRegistService {
	@Autowired
	RecruitMapper recruitMapper;
	
	public void execute(RecruitCommand recruitCommand, Model model) {
		RecruitDTO dto = new RecruitDTO();
		dto.setBoardContent(recruitCommand.getBoardContent());
		dto.setBoardSubject(recruitCommand.getBoardSubject());
		dto.setBoardWriter(recruitCommand.getBoardWriter());
		dto.setMenuName(recruitCommand.getMenuName());
		dto.setMenuPrice(recruitCommand.getMenuPrice());
		dto.setQty(recruitCommand.getQty());
		dto.setRecruitNum(recruitCommand.getRecruitNum());
		dto.setRestPrice(recruitCommand.getRestPrice());
		dto.setShopName(recruitCommand.getShopName());
		dto.setTotalPrice(recruitCommand.getTotalPrice());
		
		String shopName = recruitCommand.getShopName();
		dto.setShopLogo(recruitMapper.selectShopLogo(shopName));
		
		model.addAttribute("boardWriter", dto.getBoardWriter());
		model.addAttribute("dto",dto);
		
		recruitMapper.recruitRegist(dto);
	
	}
}
