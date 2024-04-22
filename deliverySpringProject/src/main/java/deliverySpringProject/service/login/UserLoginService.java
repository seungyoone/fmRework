package deliverySpringProject.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import deliverySpringProject.command.LoginCommand;
import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.mapper.LoginMapper;
import deliverySpringProject.service.customer.CustomerShopListService;
import jakarta.servlet.http.HttpSession;

@Service
public class UserLoginService {

	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public int execute(LoginCommand loginCommand,HttpSession session,Model model) {
		String userId = loginCommand.getUserId();
		String userPw = loginCommand.getUserPw();
		AuthInfoDTO auth = loginMapper.userLogin(userId);
		if(auth!=null) {
			if(passwordEncoder.matches(userPw, auth.getUserPw())) {
				session.setAttribute("auth", auth);
				
				return 1;
			}
			
			
			return 0;
			
		}
		
		return 0;
	}
}
