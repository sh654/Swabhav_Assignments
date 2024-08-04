package com.techlabs.model;

public class Country {

	private String countryCode;
	private String countryName;
	private Region region;
	
	public Country(String countryCode, String countryName, Region region) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.region = region;
	}

	
	

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Country [countryCode=" + countryCode + ", countryName=" + countryName + ", regionId=" + region.getRegionId() + "]";
	}
	
	
	
}
