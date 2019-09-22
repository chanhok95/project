package kr.co.hyungi.beans;

public class MemberBean {
	private int phoneNo;
	private String memName;
	private int licenseNo;
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(int licenseNo) {
		this.licenseNo = licenseNo;
	}
	@Override
	public String toString() {
		return "MemberBean [phoneNo=" + phoneNo + ", memName=" + memName + ", licenseNo=" + licenseNo + "]";
	}

}
