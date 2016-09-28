package project.sinr;

public class Transmission {
	private double powerTransmission;
	private double startPoint;
	private double endPoint;
	
	public Transmission(double powerTransmission, double startPoint, double endPoint) {
		super();
		this.powerTransmission = powerTransmission;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	public double getPowerTransmission() {
		return powerTransmission;
	}
	public void setPowerTransmission(double powerTransmission) {
		this.powerTransmission = powerTransmission;
	}
	public double getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(double startPoint) {
		this.startPoint = startPoint;
	}
	public double getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(double endPoint) {
		this.endPoint = endPoint;
	}
	
}
