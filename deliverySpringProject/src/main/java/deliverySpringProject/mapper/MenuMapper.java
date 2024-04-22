package deliverySpringProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import deliverySpringProject.domain.MenuDTO;

@Mapper
public interface MenuMapper {
	public void menuInsert(MenuDTO dto);
}
