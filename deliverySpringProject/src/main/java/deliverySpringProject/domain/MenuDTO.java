package deliverySpringProject.domain;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("menu")
public class MenuDTO {
	String shopName;
	String menuName;
	Integer menuPrice; 
	String menuExplain;
	String menuContent;
	String menuContentImg;
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(Integer menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMenuExplain() {
		return menuExplain;
	}
	public void setMenuExplain(String menuExplain) {
		this.menuExplain = menuExplain;
	}
	public String getMenuContent() {
		return menuContent;
	}
	public void setMenuContent(String menuContent) {
		this.menuContent = menuContent;
	}
	public String getMenuContentImg() {
		return menuContentImg;
	}
	public void setMenuContentImg(String menuContentImg) {
		this.menuContentImg = menuContentImg;
	}
	public MenuDTO(String shopName, String menuName, Integer menuPrice, String menuExplain, String menuContent,
			String menuContentImg) {
		super();
		this.shopName = shopName;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuExplain = menuExplain;
		this.menuContent = menuContent;
		this.menuContentImg = menuContentImg;
	}
	public MenuDTO() {
		super();
	}
	
}
