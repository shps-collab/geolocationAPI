package com.geolocation.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geolocation.geolocationFunctions.GeolocationByIP;
import com.maxmind.geoip2.exception.GeoIp2Exception;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String getCoordinates(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String,String> params) throws IOException, GeoIp2Exception {
		try {
			return GeolocationByIP.getLocation(params.get("ip")).toString();
		}catch(Exception ex) {
			return ex.getMessage().toString();
		}		
	}
}
