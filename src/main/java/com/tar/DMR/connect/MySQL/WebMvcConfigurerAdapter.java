package com.tar.DMR.connect.MySQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfigurerAdapter implements WebMvcConfigurer {
	@Autowired
	private Environment env;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String urls = env.getProperty("cors.urls");
        CorsRegistration reg = registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE");
        for (String url : urls.split(",")) {
            reg.allowedOrigins(url);
        }
    }
}
