package deliverySpringProject.service.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import deliverySpringProject.command.ShopCommand;
import deliverySpringProject.domain.AuthInfoDTO;
import deliverySpringProject.domain.ShopDTO;
import deliverySpringProject.mapper.MenuMapper;
import deliverySpringProject.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class OwnerShopUpdateService {
	@Autowired
	ShopMapper shopMapper;
	
	@Autowired
	MenuMapper menuMapper;
	public void execute(ShopCommand shopCommand, BindingResult result, HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		ShopDTO dto = shopMapper.shopSelectOne(auth.getUserId());
		String exName = dto.getShopName();
		String newName = shopCommand.getShopName();
		
		// command에 점주는 있는데 수정할떄 점주를 수정하지 않기때문에 이렇게 가져와야한다.
		dto.setShopName(shopCommand.getShopName());
		dto.setShopExplain(shopCommand.getShopExplain());
		dto.setShopMin(shopCommand.getShopMin());
		dto.setShopDelivery(shopCommand.getShopDelivery());
		
		/*
		List<FileDTO> list = (List<FileDTO>)session.getAttribute("fileList");
	
		
		URL resource = getClass().getClassLoader().getResource("static/upload");
		String fileDir = resource.getFile();
		if(!shopCommand.getShopLogo().getOriginalFilename().isEmpty()) {
			System.out.println(shopCommand.getShopLogo());
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
				for(FileDTO fileCommand : list) {
					if(fileCommand.getStoreFile().equals(dto .getShopLogo())) {
						// session에 삭제 정보가 있는데 file을 가져오지 않음
						result.rejectValue("shopLogo", "error");
						model.addAttribute("error", "식당 사진을 선택해주세요");
						model.addAttribute("shopCommand", dto);
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
		*/
		
		menuMapper.menuShopUpdate(exName,newName);
		shopMapper.shopUpdate(dto);
		
	}
}
