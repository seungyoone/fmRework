package deliverySpringProject.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.mapper.LoginMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class UserLogoutService {
	@Autowired
	LoginMapper loginMapper;
	
	public void execute(HttpSession session) {
		session.invalidate();
		
	}
}
