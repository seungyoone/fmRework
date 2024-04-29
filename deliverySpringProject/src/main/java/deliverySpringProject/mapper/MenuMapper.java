package deliverySpringProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import deliverySpringProject.domain.MenuDTO;

@Mapper
public interface MenuMapper {
	public void menuInsert(MenuDTO dto);
	public MenuDTO menuSelectOne(String menuName, String shopName);
	public void menuUpdate(MenuDTO dto);
	public void menuDelete(String menuName, String shopName);
}
