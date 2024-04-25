package deliverySpringProject.domain;

public class FileDTO {
	String orgFile;
	String storeFile;
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
	public FileDTO(String orgFile, String storeFile) {
		super();
		this.orgFile = orgFile;
		this.storeFile = storeFile;
	}
	public FileDTO() {
		super();
	}
	
	
}
