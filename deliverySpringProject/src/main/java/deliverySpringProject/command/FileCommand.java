package deliverySpringProject.command;

public class FileCommand {
	String orgFile;
	String storeFile;
	int qty;
	public String getOrgFile() {
		return orgFile;
	}
	public void setOrgFile(String orgFile) {
		this.orgFile = orgFile;
	}
	public String getStoreFile() {
		return storeFile;
	}
	public void setStoreFile(String storeFile) {
		this.storeFile = storeFile;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
