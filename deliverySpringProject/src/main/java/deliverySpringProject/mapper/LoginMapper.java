package deliverySpringProject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import deliverySpringProject.domain.AuthInfoDTO;

@Mapper
public interface LoginMapper {
	public AuthInfoDTO userLogin(@RequestParam(value="userId") String userId);
}
