package com.tejas.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImageConfig implements WebMvcConfigurer
{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		final String uploadPath = System.getProperty("user.dir")+"/uploads/images";
		//System.getProperty("user.dir") ==> get complete project location from computer
		
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:"+uploadPath);
	}
}
