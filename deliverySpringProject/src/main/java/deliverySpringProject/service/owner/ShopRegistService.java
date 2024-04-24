package deliverySpringProject.service.owner;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import deliverySpringProject.command.ShopCommand;
import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.ShopDTO;
import deliverySpringProject.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;




@Service
public class ShopRegistService {
	@Autowired
	ShopMapper shopMapper;
	
	public void execute(ShopCommand shopCommand,HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		ShopDTO dto = new ShopDTO();
		dto.setShopAddr(shopCommand.getShopAddr());
		dto.setShopAddrDetail(shopCommand.getShopAddrDetail());
		dto.setShopDelivery(shopCommand.getShopDelivery());
		dto.setShopExplain(shopCommand.getShopExplain());
		dto.setShopMin(shopCommand.getShopMin());
		dto.setShopName(shopCommand.getShopName());
		dto.setShopPhone(shopCommand.getShopPhone());
		dto.setShopRegistDate(shopCommand.getShopRegistDate());
		dto.setShopType(shopCommand.getShopType());
		dto.setShopOwner(auth.getUserName());
		dto.setShopOwnerId(auth.getUserId());
		
		URL resource = getClass().getClassLoader().getResource("static/upload"); 
		String fileDir = resource.getFile();
		MultipartFile mf = shopCommand.getShopLogo();
		String originalFile = mf.getOriginalFilename();
		String extension = originalFile.substring(originalFile.lastIndexOf("."));
		String storeName = UUID.randomUUID().toString().replace("-", "");
		String storeFileName = storeName + extension;
		File file = new File(fileDir+"/"+storeFileName);
		try {
			mf.transferTo(file);
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		dto.setShopLogo(storeFileName);
		dto.setShopLogoImg(originalFile);		
		
		shopMapper.shopInsert(dto);
	}
}
