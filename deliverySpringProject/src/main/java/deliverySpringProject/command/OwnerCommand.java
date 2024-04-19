package deliverySpringProject.command;

import java.util.Date;

public class OwnerCommand {
	String ownerName;
	String ownerId;
	String ownerPw;
	String ownerPwCon;
	String ownerPhone;
	String ownerNum;
	String ownerEmail;
	Date ownerBirth;
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
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
	public String getOwnerPwCon() {
		return ownerPwCon;
	}
	public void setOwnerPwCon(String ownerPwCon) {
		this.ownerPwCon = ownerPwCon;
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
}
