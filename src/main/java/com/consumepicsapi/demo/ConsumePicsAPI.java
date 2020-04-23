package com.consumepicsapi.demo;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

	//HomePage
	@GetMapping("/")
	public ModelAndView index(RestTemplate restTemplate, ModelAndView modelView) {
		//log.info("Index hit!");
	
		ModelAndView mv = new ModelAndView("index");
		ArrayList<Response> images = new ArrayList<>();;
		
		Response response = restTemplate.getForObject("https://api.unsplash.com/search/photos/?query=nebular&client_id=90YYoDZw5-bfZlZFvWqcQd5YdrXj_BVLJsoyO8ZB2nU&page=1", Response.class);
		
		for (Result res : response.getResults()) {
			log.info("Testing - ID: " +res.getId());
			log.info("Testing - URL: " +res.getUrls().getRaw());

		}
	
		return mv;
	}

	
	

	


	

}
