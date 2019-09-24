package kr.co.hyungi.beans;

public class MemberBean {
	private String phoneNo;
	private String memName;
	private String licenseNo;

	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	@Override
	public String toString() {
		return "MemberBean [phoneNo=" + phoneNo + ", memName=" + memName + ", licenseNo=" + licenseNo + "]";
	}

}
