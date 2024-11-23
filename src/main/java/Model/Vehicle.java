package Model;

public class Vehicle {
	
	private String vehicleNO;
	private String brand;
	private String type;
	private String color;
	
	public Vehicle(String vehicleNO,String brand,String type,String color) {
		this.vehicleNO=vehicleNO;
		this.brand=brand;
		this.type=type;
		this.color=color;
	}

	public String getVehicleNO() {
		return vehicleNO;
	}

	public void setVehicleNO(String vehicleNO) {
		this.vehicleNO = vehicleNO;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
