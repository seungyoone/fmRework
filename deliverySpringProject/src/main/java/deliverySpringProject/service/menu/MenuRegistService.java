package deliverySpringProject.service.menu;

import java.io.File;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import deliverySpringProject.command.MenuCommand;
import deliverySpringProject.domain.MenuDTO;
import deliverySpringProject.mapper.MenuMapper;
import deliverySpringProject.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class MenuRegistService {
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	ShopMapper shopMapper;
	
	public void execute(MenuCommand menuCommand) {
		MenuDTO dto = new MenuDTO();
		dto.setMenuExplain(menuCommand.getMenuExplain());
		dto.setMenuName(menuCommand.getMenuName());
		dto.setMenuPrice(menuCommand.getMenuPrice());
		
		/*
		
		String shopName = shopMapper.getShopName(auth.getUserId());
		dto.setShopName(shopName);
		*/
		
		URL resource = getClass().getClassLoader().getResource("static/upload");
		String fileDir = resource.getFile();  // 이 파일 경로는 실제 파일 시스템에서의 경로
		MultipartFile mf = menuCommand.getMenuContent();
		String originalFile = mf.getOriginalFilename();
		String extension = originalFile.substring(originalFile.lastIndexOf("."));  //확장자 추출
		String foodName = UUID.randomUUID().toString().replace("-", "");  //랜덤 문자열 생성 후 파일명으로 쓰기 위해 "-" 제거
		String foodFileName = foodName + extension;
		File file = new File(fileDir+"/"+foodFileName);
		try {
			mf.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setMenuContent(foodFileName);
		dto.setMenuContentImg(originalFile);
		
		menuMapper.menuInsert(dto);
	}
}
