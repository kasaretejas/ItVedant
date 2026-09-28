package com.tejas.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImagePathConfiguaration implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		final String imagePath = System.getProperty("user.dir")+"/uploads/images/";
		//user.dir gives path upto project folder location. ex : C:/Tejas Kasare Sir/T223/Spring/WebCart
		//therefor the imagePath becomes = C:/Tejas Kasare Sir/T223/Spring/WebCart/uploads/images
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:"+imagePath);
	}
}
