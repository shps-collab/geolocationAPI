package com.geolocation.geolocationFunctions;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

public class GeolocationByIP {
    
	private static DatabaseReader dbReader;
    private static InputStream database;
    
    public static JSONObject getLocation(String ip) throws IOException, GeoIp2Exception {
       	database = new ClassPathResource("/databases/GeoLite2-City.mmdb").getInputStream();
	    dbReader = new DatabaseReader.Builder(database).build();
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);
        String cityName = response.getCity().getName();
        String latitude = response.getLocation().getLatitude().toString();
        String longitude = response.getLocation().getLongitude().toString();
        JSONObject json = new JSONObject();
        json.put("latitude", latitude);
        json.put("longitude", longitude);
        json.put("city", cityName);
        json.put("province", response.getMostSpecificSubdivision().getName());
        json.put("ip", ip);
        return json;
    }
    
}
