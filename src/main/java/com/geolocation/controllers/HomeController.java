package com.geolocation.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geolocation.geolocationFunctions.GeolocationByIP;
import com.maxmind.geoip2.exception.GeoIp2Exception;

@RestController
public class HomeController {
	//Test Comment
	@GetMapping("/")
	public String getCoordinates(HttpServletRequest request, HttpServletResponse response) throws IOException, GeoIp2Exception {
		try {
			return GeolocationByIP.getLocation(request.getRemoteAddr()).toString();
		}catch(Exception ex) {
			return "false";
		}		
	}
}
