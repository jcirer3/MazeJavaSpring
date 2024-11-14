package com.esliceu.Maze;

import com.esliceu.Maze.filters.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MazeApplication implements WebMvcConfigurer {
	@Autowired
	LoginInterceptor loginInterceptor;

	public static void main(String[] args) {
		SpringApplication.run(MazeApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(
				loginInterceptor
		).addPathPatterns("/home");
	}
}
