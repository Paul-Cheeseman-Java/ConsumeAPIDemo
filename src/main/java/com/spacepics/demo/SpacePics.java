package com.spacepics.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

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



@Controller
@SpringBootApplication
public class SpacePics {

	private static final Logger log = LoggerFactory.getLogger(SpacePics.class);

	public static void main(String[] args) {
		SpringApplication.run(SpacePics.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	//HomePage
	//
	@GetMapping("/")
	public ModelAndView index(RestTemplate restTemplate, ModelAndView modelView) {
		log.info("Index hit!");
		
		ArrayList<ImgOfDay> images = new ArrayList<>();
		LocalDate apiCallDate = LocalDate.now();
		
		ModelAndView mv = new ModelAndView("index");
		
		
		for(int i=0; i<5; i++) {
			//ImgOfDay img = restTemplate.getForObject("https://api.nasa.gov/planetary/apod?date=" + apiCallDate.minusDays(i).getYear() + "-" + apiCallDate.minusDays(i).getMonthValue() + "-" + apiCallDate.minusDays(i).getDayOfMonth() + "&api_key=yZmDIN7MgLEVQhGb2OtQx9Rqqwzhq9EPr75K3MaH", ImgOfDay.class);
			//log.info("https://api.nasa.gov/planetary/apod?date=" + apiCallDate.minusDays(i).getYear() + "-" + apiCallDate.minusDays(i).getMonthValue() + "-" + apiCallDate.minusDays(i).getDayOfMonth() + "&api_key=DEMO_KEY");
			ImgOfDay img = restTemplate.getForObject("https://api.nasa.gov/planetary/apod?date=" + apiCallDate.minusDays(i).getYear() + "-" + apiCallDate.minusDays(i).getMonthValue() + "-" + apiCallDate.minusDays(i).getDayOfMonth() + "&api_key=yZmDIN7MgLEVQhGb2OtQx9Rqqwzhq9EPr75K3MaH", ImgOfDay.class);
			images.add(img);
			
			//log.info(img.getTitle());
		}

		mv.addObject("images", images);
		
		return mv;
	}

	

	
	@GetMapping("test")
	public ModelAndView demo(RestTemplate restTemplate) {

		ModelAndView mv = new ModelAndView("test");
		ArrayList<ImgOfDay> images = new ArrayList<>();
		LocalDate apiCallDate = LocalDate.now();
		
		for(int i=0; i<5; i++) {
			//ImgOfDay img = restTemplate.getForObject("https://api.nasa.gov/planetary/apod?date=" + apiCallDate.minusDays(i).getYear() + "-" + apiCallDate.minusDays(i).getMonthValue() + "-" + apiCallDate.minusDays(i).getDayOfMonth() + "&api_key=yZmDIN7MgLEVQhGb2OtQx9Rqqwzhq9EPr75K3MaH", ImgOfDay.class);
			//log.info("https://api.nasa.gov/planetary/apod?date=" + apiCallDate.minusDays(i).getYear() + "-" + apiCallDate.minusDays(i).getMonthValue() + "-" + apiCallDate.minusDays(i).getDayOfMonth() + "&api_key=DEMO_KEY");
			ImgOfDay img = restTemplate.getForObject("https://api.nasa.gov/planetary/apod?date=" + apiCallDate.minusDays(i).getYear() + "-" + apiCallDate.minusDays(i).getMonthValue() + "-" + apiCallDate.minusDays(i).getDayOfMonth() + "&api_key=yZmDIN7MgLEVQhGb2OtQx9Rqqwzhq9EPr75K3MaH", ImgOfDay.class);
			images.add(img);
			
			
			
			//log.info(img.getTitle());
		}

		mv.addObject("images", images);
		
		
		mv.addObject("testVal", "Yippee!");
		return mv;
	
	}
	
	


}
