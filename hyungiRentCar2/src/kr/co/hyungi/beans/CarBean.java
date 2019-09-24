package kr.co.hyungi.beans;

public class CarBean {
	private int carNo;
	private String carColor;
	private String carModel;
	private int costPerHour;
	public int getCarNo() {
		return carNo;
	}
	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getCostPerHour() {
		return costPerHour;
	}
	public void setCostPerHour(int costPerHour) {
		this.costPerHour = costPerHour;
	}
	@Override
	public String toString() {
		return "CarBean [carNo=" + carNo + ", carColor=" + carColor + ", carModel=" + carModel + ", costPerHour="
				+ costPerHour + "]";
	}
	
	
}
