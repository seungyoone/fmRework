package deliverySpringProject.service.recruit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.RecruitDTO;
import deliverySpringProject.mapper.CustomerMapper;
import deliverySpringProject.mapper.RecruitMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class RecruitListService {
	@Autowired
	RecruitMapper recruitMapper;
	
	@Autowired
	CustomerMapper customerMapper;
	
	public void execute(HttpSession session,Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String customerAddr = customerMapper.customerAddrSelect(auth.getUserId());
		List<RecruitDTO> list = recruitMapper.recruitSelectList(customerAddr);
		model.addAttribute("list", list);
		model.addAttribute("listAddr", customerAddr);
	}
	
}
