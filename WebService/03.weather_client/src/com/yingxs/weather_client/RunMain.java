package com.yingxs.weather_client;

import java.util.List;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWebService;
import cn.com.webxml.WeatherWebServiceSoap;

public class RunMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherWebService weatherWebService = new WeatherWebService();
		
		
		WeatherWebServiceSoap weatherWebServiceSoap = weatherWebService.getWeatherWebServiceSoap();
	
		ArrayOfString arrayOfString = weatherWebServiceSoap.getWeatherbyCityName("杭州");
		List<String> list = arrayOfString.getString();
		for (String string : list) {
			System.out.println(string);
		}
		
		
		
	}

}
