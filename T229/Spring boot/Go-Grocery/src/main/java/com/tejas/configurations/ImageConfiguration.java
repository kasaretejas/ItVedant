package com.tejas.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImageConfiguration implements WebMvcConfigurer
{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		String imagePath = System.getProperty("user.dir")+"/uploads/images"; //user.dir =C:\Tejas Kasare Sir\T229\Spring boot\Go-Grocery
		
		registry
				.addResourceHandler("/api/v1/images/**")   //api to access images
				.addResourceLocations("file:"+imagePath);  //location where we store images
		
	}
	
}
