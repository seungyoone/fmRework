package deliverySpringProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import deliverySpringProject.domain.RecruitDTO;

@Mapper
public interface RecruitMapper {

	public void recruitRegist(RecruitDTO dto);
	
	public String selectShopLogo(String shopName); 
	
	public List<RecruitDTO> recruitSelectList(String customerAddr);
	
	public RecruitDTO recruitSelectOne(String boardWriter);
	
}
