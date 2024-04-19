package deliverySpringProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("shop");
public class ShopDTO {

	String shopOwner;
	String shopName;
	String shopType;
	String shopAddr;
	String shopAddrDetail;
	String shopPhone;
	String shopExplain;
	String shopLogo;
	String shopLogoImg;
	Integer shopMin;
	Integer shopDelivery;
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
	public String getShopLogo() {
		return shopLogo;
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	public String getShopLogoImg() {
		return shopLogoImg;
	}
	public void setShopLogoImg(String shopLogoImg) {
		this.shopLogoImg = shopLogoImg;
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
	public ShopDTO(String shopOwner, String shopName, String shopType, String shopAddr, String shopAddrDetail,
			String shopPhone, String shopExplain, String shopLogo, String shopLogoImg, Integer shopMin,
			Integer shopDelivery, Date shopRegistDate) {
		super();
		this.shopOwner = shopOwner;
		this.shopName = shopName;
		this.shopType = shopType;
		this.shopAddr = shopAddr;
		this.shopAddrDetail = shopAddrDetail;
		this.shopPhone = shopPhone;
		this.shopExplain = shopExplain;
		this.shopLogo = shopLogo;
		this.shopLogoImg = shopLogoImg;
		this.shopMin = shopMin;
		this.shopDelivery = shopDelivery;
		this.shopRegistDate = shopRegistDate;
	}
	
	public ShopDTO() {
		super();
	}
	
	
	
	
}
