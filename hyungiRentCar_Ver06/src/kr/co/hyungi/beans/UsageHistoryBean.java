package kr.co.hyungi.beans;

public class UsageHistoryBean {
	private int rentNo;
	private int carNo;
	private String phoneNo;
	private String licenseNo;
	private String rentStartDate;
	private String rentEndDate;
	private String rentFinal;
	private int rentCost;	//결제된 금액
	private String addCost;	//반납후 결제된 실제금액
	private String state;
	public int getRentNo() {
		return rentNo;
	}
	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}
	public int getCarNo() {
		return carNo;
	}
	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getRentStartDate() {
		return rentStartDate;
	}
	public void setRentStartDate(String rentStartDate) {
		this.rentStartDate = rentStartDate;
	}
	public String getRentEndDate() {
		return rentEndDate;
	}
	public void setRentEndDate(String rentEndDate) {
		this.rentEndDate = rentEndDate;
	}
	public String getRentFinal() {
		return rentFinal;
	}
	public void setRentFinal(String rentFinal) {
		this.rentFinal = rentFinal;
	}
	public int getRentCost() {
		return rentCost;
	}
	public void setRentCost(int rentCost) {
		this.rentCost = rentCost;
	}
	public String getAddCost() {
		return addCost;
	}
	public void setAddCost(String addCost) {
		this.addCost = addCost;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "UsageHistoryBean [rentNo=" + rentNo + ", carNo=" + carNo + ", phoneNo=" + phoneNo + ", licenseNo="
				+ licenseNo + ", rentStartDate=" + rentStartDate + ", rentEndDate=" + rentEndDate + ", rentFinal="
				+ rentFinal + ", rentCost=" + rentCost + ", addCost=" + addCost + ", state=" + state
				+ "]";
	}
}
