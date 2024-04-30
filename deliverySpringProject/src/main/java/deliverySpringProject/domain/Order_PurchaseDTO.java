package deliverySpringProject.domain;

public class Order_PurchaseDTO {
	String shopName;
	String menuName;
	String menuContent;
	String totalPrice;
	String qty;
	Integer shopDelivery;
	String customerName;
	String customerAddr;
	String customerAddrDetail;
	String OrderMessage;
	String purchasePrice;
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
		return OrderMessage;
	}
	public void setOrderMessage(String orderMessage) {
		OrderMessage = orderMessage;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public Order_PurchaseDTO(String shopName, String menuName, String menuContent, String totalPrice, String qty,
			Integer shopDelivery, String customerName, String customerAddr, String customerAddrDetail,
			String orderMessage, String purchasePrice) {
		super();
		this.shopName = shopName;
		this.menuName = menuName;
		this.menuContent = menuContent;
		this.totalPrice = totalPrice;
		this.qty = qty;
		this.shopDelivery = shopDelivery;
		this.customerName = customerName;
		this.customerAddr = customerAddr;
		this.customerAddrDetail = customerAddrDetail;
		OrderMessage = orderMessage;
		this.purchasePrice = purchasePrice;
	}
	public Order_PurchaseDTO() {
		super();
	}
}
