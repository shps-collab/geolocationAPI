package com.geolocation.geolocationFunctions;

public class GeoIP {
	
    private String ipAddress;
    private String city;
    private String latitude;
    private String longitude;
    
	public GeoIP(String ipAddress, String city, String latitude, String longitude) {
		super();
		this.ipAddress = ipAddress;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
}
