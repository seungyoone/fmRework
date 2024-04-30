package deliverySpringProject.domain;

public class PurchaseDTO {
	String shopName;
	String menuName;
	String menuContent;
	String totalPrice;
	String qty;
	Integer shopDelivery;
	String customerName;
	String customerAddr;
	String customerAddrDetail;
	String orderMessage;
	Integer purchasePrice;
	String customerPhone;
	
	
	
	
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
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
	public String getMenuContent() {
		return menuContent;
	}
	public void setMenuContent(String menuContent) {
		this.menuContent = menuContent;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public Integer getShopDelivery() {
		return shopDelivery;
	}
	public void setShopDelivery(Integer shopDelivery) {
		this.shopDelivery = shopDelivery;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}
	public String getCustomerAddrDetail() {
		return customerAddrDetail;
	}
	public void setCustomerAddrDetail(String customerAddrDetail) {
		this.customerAddrDetail = customerAddrDetail;
	}
	public String getOrderMessage() {
		return orderMessage;
	}
	public void setOrderMessage(String orderMessage) {
		this.orderMessage = orderMessage;
	}
	public Integer getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
}
