package com.revature.beans;

public class Bike {
	private String bikeModel;
	private int frameSerialNumber;
	private String bikeType;
	private String Manufacturer;
	private double frameWeight;
	private double price;
	
	public Bike(){
		frameSerialNumber = 0;
		bikeModel = "Bike Model";
		bikeType = "hybrid";
		Manufacturer = "Manufacturer";
		frameWeight = 0;
		price = 0;
	}
	
	
	// setters and getters start
	public String getBikeModel() {
		return bikeModel;
	}

	public void setBikeModel(String bikeModel) {
		this.bikeModel = bikeModel;
	}


	public int getframeSerialNumber() {
		return frameSerialNumber;
	}


	public void setframeSerialNumber(int frameSerialNumber) {
		this.frameSerialNumber = frameSerialNumber;
	}


	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}

	public String getManufacturer() {
		return Manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	

	public double getFrameWeight() {
		return frameWeight;
	}


	public void setFrameWeight(double frameWeight) {
		this.frameWeight = frameWeight;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	
	//setters and getters end
	
	//complete the bean
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bikeModel == null) ? 0 : bikeModel.hashCode());
		result = prime * result + frameSerialNumber;
		result = prime * result + ((Manufacturer == null) ? 0 : Manufacturer.hashCode());
		result = prime * result + ((bikeType == null) ? 0 : bikeType.hashCode());
		result = (int) (prime * result + frameWeight);
		result = (int) (prime * result + price);
		return result;
	}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Bike other = (Bike) obj;
			if (bikeModel == null) {
				if (other.bikeModel != null)
					return false;
			} else if (!bikeModel.equals(other.bikeModel))
				return false;
			if (frameSerialNumber != other.frameSerialNumber)
				return false;
			if (bikeType == null) {
				if (other.bikeType != null)
					return false;
			} else if (!bikeType.equals(other.bikeType))
				return false;
			if (Manufacturer == null) {
				if (other.Manufacturer != null)
					return false;
			} else if (!Manufacturer.equals(other.Manufacturer))
				return false;
			if (frameWeight != other.frameWeight)
				return false;
			if (price != other.price)
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "Bike [frameSerialNumber=" + frameSerialNumber + ", bikeModel=" + bikeModel + ", bikeType=" + bikeType + ", Manufacturer=" + Manufacturer
					+ ", frameWeight=" + frameWeight + ", price=" + price + "]";
		}
	}
	
