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

	@GetMapping("/")
	public String getCoordinates(HttpServletRequest request, HttpServletResponse response) throws IOException, GeoIp2Exception {
		GeolocationByIP asdf = new GeolocationByIP();
		return asdf.getLocation("24.96.73.230").toString();
	}

}
