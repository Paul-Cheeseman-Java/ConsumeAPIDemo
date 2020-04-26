package com.consumepicsapi.demo;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


import org.codehaus.jackson.type.TypeReference;

//import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;



@Controller
@SpringBootApplication
public class ConsumePicsAPI {

	private static final Logger log = LoggerFactory.getLogger(ConsumePicsAPI.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumePicsAPI.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	
	@GetMapping("/")
	public ModelAndView index(RestTemplate restTemplate, HttpServletRequest request) {
			Response response;
		if (request.getParameter("type") != null) {
			String type = request.getParameter("type");
			if (type.equals("Animals") || type.equals("Art")) {
				response = restTemplate.getForObject("https://api.unsplash.com/search/photos/?"
						+ "query=" + type + "&orientation=landscape&client_id=90YYoDZw5-bfZlZFvWqcQd5YdrXj_BVLJsoyO8ZB2nU&page=1", Response.class);			
			}
			else {
				response = restTemplate.getForObject("https://api.unsplash.com/search/photos/?"
						+ "query=galaxy+wallpaper&orientation=landscape&client_id=90YYoDZw5-bfZlZFvWqcQd5YdrXj_BVLJsoyO8ZB2nU&page=1", Response.class);						
			}
		}
		else {
			response = restTemplate.getForObject("https://api.unsplash.com/search/photos/?"
					+ "query=galaxy+wallpaper&orientation=landscape&client_id=90YYoDZw5-bfZlZFvWqcQd5YdrXj_BVLJsoyO8ZB2nU&page=1", Response.class);						
		}
		
		ModelAndView mv = new ModelAndView("index");
		ArrayList<ImgDetails> images = new ArrayList<>();		
		int imgNumber = 0;
		
		for (Result res : response.getResults()) {
			String url = res.getUrls().getRaw() + "&w=2560&h=1600&fit=scale";
			String name = res.getUser().getName();
			imgNumber = imgNumber + 1;
			
			//Removing the promoted images from 'Galaxy Background' search API results
			if (!name.equals("Harley-Davidson")) {
				ImgDetails imgDetails = new ImgDetails(url, name, imgNumber);
				images.add(imgDetails);
			}
		}

		mv.addObject("images", images);
		return mv;
	}
}
