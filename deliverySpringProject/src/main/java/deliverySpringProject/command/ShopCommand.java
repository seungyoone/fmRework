package deliverySpringProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class ShopCommand {
	
	String shopOwner;
	String shopName;
	String shopType;
	String shopAddr;
	String shopAddrDetail;
	String shopPhone;
	String shopExplain;
	MultipartFile shopLogo;
	Integer shopMin;
	Integer shopDelivery;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date shopRegistDate;
	
	public String getShopOwner() {
		return shopOwner;
	}
	public void setShopOwner(String shopOwner) {
		this.shopOwner = shopOwner;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopType() {
		return shopType;
	}
	public void setShopType(String shopType) {
		this.shopType = shopType;
	}
	public String getShopAddr() {
		return shopAddr;
	}
	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}
	public String getShopAddrDetail() {
		return shopAddrDetail;
	}
	public void setShopAddrDetail(String shopAddrDetail) {
		this.shopAddrDetail = shopAddrDetail;
	}
	public String getShopPhone() {
		return shopPhone;
	}
	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}
	public String getShopExplain() {
		return shopExplain;
	}
	public void setShopExplain(String shopExplain) {
		this.shopExplain = shopExplain;
	}
	
	public MultipartFile getShopLogo() {
		return shopLogo;
	}
	public void setShopLogo(MultipartFile shopLogo) {
		this.shopLogo = shopLogo;
	}
	public Integer getShopMin() {
		return shopMin;
	}
	public void setShopMin(Integer shopMin) {
		this.shopMin = shopMin;
	}
	public Integer getShopDelivery() {
		return shopDelivery;
	}
	public void setShopDelivery(Integer shopDelivery) {
		this.shopDelivery = shopDelivery;
	}
	public Date getShopRegistDate() {
		return shopRegistDate;
	}
	public void setShopRegistDate(Date shopRegistDate) {
		this.shopRegistDate = shopRegistDate;
	}
	
	
	
}
