package deliverySpringProject.service.recruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import deliverySpringProject.domain.RecruitDTO;
import deliverySpringProject.mapper.RecruitMapper;

@Service
public class RecruitDetailService {

	@Autowired
	RecruitMapper recruitMapper;	
	
	public void execute(String boardWriter,Model model) {
		RecruitDTO dto = recruitMapper.recruitSelectOne(boardWriter);
		model.addAttribute("dto", dto);
	}
}
