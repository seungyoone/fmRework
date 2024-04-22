package deliverySpringProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("customer")
public class CustomerDTO {
	String customerName;
	String customerId;
	String customerPw;
	String customerAddr;
	String customerAddrDetail;
	Date customerBirth;
	String customerEmail;
	String customerPhone;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerPw() {
		return customerPw;
	}
	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
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
	public Date getCustomerBirth() {
		return customerBirth;
	}
	public void setCustomerBirth(Date customerBirth) {
		this.customerBirth = customerBirth;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public CustomerDTO(String customerName, String customerId, String customerPw, String customerAddr,
			String customerAddrDetail, Date customerBirth, String customerEmail, String customerPhone) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.customerPw = customerPw;
		this.customerAddr = customerAddr;
		this.customerAddrDetail = customerAddrDetail;
		this.customerBirth = customerBirth;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
	}
	public CustomerDTO() {
		super();
	}
	
}
