package aeic.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
public class MvcConfig implements WebMvcConfigurer {
 
 
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/list").setViewName("list");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		Path imageUploadDir = Paths.get("./File-package/");
		String imageUploadPath = imageUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/File-package/**").addResourceLocations("file:/" + imageUploadPath + "/");
		
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}

	
}



