package deliverySpringProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("owner")
public class OwnerDTO {
	String ownerId;
	String ownerPw;
	String ownerName;
	String ownerPhone;
	String ownerNum;
	String ownerEmail;
	Date ownerBirth;
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerPw() {
		return ownerPw;
	}
	public void setOwnerPw(String ownerPw) {
		this.ownerPw = ownerPw;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public Date getOwnerBirth() {
		return ownerBirth;
	}
	public void setOwnerBirth(Date ownerBirth) {
		this.ownerBirth = ownerBirth;
	}
	public OwnerDTO(String ownerId, String ownerPw, String ownerName, String ownerPhone, String ownerNum,
			String ownerEmail, Date ownerBirth) {
		super();
		this.ownerId = ownerId;
		this.ownerPw = ownerPw;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.ownerNum = ownerNum;
		this.ownerEmail = ownerEmail;
		this.ownerBirth = ownerBirth;
	}
	public OwnerDTO() {
		super();
	}
	
	
}
