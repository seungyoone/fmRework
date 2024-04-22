package deliverySpringProject.command;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class MenuCommand {
	String shopName;
	String menuName;
	Integer menuPrice; 
	String menuExplain;
	MultipartFile menuContent;
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
	public MultipartFile getMenuContent() {
		return menuContent;
	}
	public void setMenuContent(MultipartFile menuContent) {
		this.menuContent = menuContent;
	}
}
