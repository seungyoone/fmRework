package deliverySpringProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import deliverySpringProject.domain.RecruitDTO;

@Mapper
public interface RecruitMapper {

	public void recruitRegist(RecruitDTO dto);
}
