package com.geolocation.geolocationFunctions;

import java.io.File;

import java.io.IOException;
import java.net.InetAddress;

import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

public class GeolocationByIP {

	    private DatabaseReader dbReader;
	    
	    public GeolocationByIP() throws IOException {
	        File database = new ClassPathResource("/databases/GeoLite2-City.mmdb").getFile();
	        dbReader = new DatabaseReader.Builder(database).build();
	    }
	    
	    public JSONObject getLocation(String ip) 
	      throws IOException, GeoIp2Exception {
	        InetAddress ipAddress = InetAddress.getByName(ip);
	        CityResponse response = dbReader.city(ipAddress);
	        System.out.println(response.getLocation().toJson());
	        String cityName = response.getCity().getName();
	        String latitude = 
	          response.getLocation().getLatitude().toString();
	        String longitude = 
	          response.getLocation().getLongitude().toString();
	        JSONObject json = new JSONObject();
	        json.put("latitude", latitude);
	        json.put("longitude", longitude);
	        json.put("city", cityName);
	        json.put("province", response.getMostSpecificSubdivision().getName());
	        json.put("ip", ip);
	        return json;
	    }
	

}
