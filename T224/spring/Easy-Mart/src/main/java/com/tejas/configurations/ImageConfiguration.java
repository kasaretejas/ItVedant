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
		final String imagePath=System.getProperty("user.dir")+"/uploads/images";
		//System.getProperty("user.dir") ==> C:/Tejas Kasare Sir/T224/spring/Easy-Mart
		registry.addResourceHandler("/api/v1/images/**")
		.addResourceLocations("file:"+imagePath);
	}

}
