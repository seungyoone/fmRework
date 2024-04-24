package deliverySpringProject.service.owner;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import deliverySpringProject.command.FileCommand;
import deliverySpringProject.command.ShopCommand;
import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.FileDTO;
import deliverySpringProject.domain.ShopDTO;
import deliverySpringProject.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class OwnerShopUpdateService {
	@Autowired
	ShopMapper shopMapper;
	public void execute(ShopCommand shopCommand, BindingResult result, HttpSession session, Model model) {
		ShopDTO dto = new ShopDTO();
		
		// command에 점주는 있는데 수정할떄 점주를 수정하지 않기때문에 이렇게 가져와야한다.
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		shopCommand.setShopOwner(auth.getUserName());
		dto.setShopOwner(shopCommand.getShopOwner());
		
		dto.setShopName(shopCommand.getShopName());
		dto.setShopExplain(shopCommand.getShopExplain());
		dto.setShopMin(shopCommand.getShopMin());
		dto.setShopDelivery(shopCommand.getShopDelivery());
		
		
		List<FileDTO> list = (List<FileDTO>)session.getAttribute("fileList");
		ShopDTO shopDTO = shopMapper.shopSelectOne(shopCommand.getShopOwner());
		
		URL resource = getClass().getClassLoader().getResource("static/upload");
		String fileDir = resource.getFile();
		if(!shopCommand.getShopLogo().getOriginalFilename().isEmpty()) {
			//2. 파일객체 불러오기
			MultipartFile mf = shopCommand.getShopLogo();
			//3. 파일이름 가져오기
			String originalFile = mf.getOriginalFilename();
			//4. 확장자 분리하기
			String extension = originalFile.substring(originalFile.lastIndexOf("."));
			//5. 새로운 파일명 만들기
			String storeName = UUID.randomUUID().toString().replace("-", "");
			//6. 새로운 파일명과 확장자 붙이기
			String storeFileName = storeName + extension;
			
			// 디비에 수정하기 위해 dto에 저장
			dto.setShopLogo(storeFileName);
			dto.setShopLogoImg(originalFile);
			
			//7. 파일객체 만들기
			File file = new File(fileDir + "/" + storeFileName);
			//8. 파일 저장
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			if(list != null) {
				for(FileCommand fileCommand : list) {
					if(fileCommand.getStoreFile().equals(shopDTO.getShopLogo())) {
						// session에 삭제 정보가 있는데 file을 가져오지 않음
						result.rejectValue("shopLogo", "error");
						model.addAttribute("error", "식당 사진을 선택해주세요");
						model.addAttribute("shopCommand", shopDTO);
						session.removeAttribute("fileList");
						return;
					}
				}
			}
		}
		int i = shopMapper.shopUpdate(dto);
		if(i > 0) {
			if(list != null) {
				for(FileDTO fd : list) {
					File file = new  File(fileDir + "/" + fd.getStoreFile());
					if(file.exists()) file.delete();
				}
			}
		}
		shopMapper.shopUpdate(dto);
	}
}
