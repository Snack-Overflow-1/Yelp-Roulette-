
package com.snackoverflow.yelproulette;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
@RestController
@CrossOrigin
@ServletComponentScan
@RequestMapping("/api")
public class RestaurantController{

	String[] restaurantData = {"Taco Bell", "Wendy's", "Chipotle", "McDonalds", "Raising Canes"};
	boolean onRefreshPage = false;
	long durationInSeconds = 0;
	private static final String API_KEY = "aUUmAi731yi0X2gIQR2Y8ACDhPJSuPP6Y9Zsbn9stSBmluwa0vHYDYKh-HDYIcg4yPWhZ9FAwnYiXOCY2iI43ODZb7YFH5Ul6Mp1FB1GSWaPBvHfxQub3XGbi6BYY3Yx";
	Restaurant input = new Restaurant();
	private static final float MILESTOMETERS = 1609.344f;

	public static void main(String[] args) {
		SpringApplication.run(RestaurantController.class, args);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	@GetMapping("/randomRestaurant")
	public String randomRestaurant() {
		Random r = new Random();
		return "You landed on " + restaurantData[r.nextInt(restaurantData.length)] + "!";
	}

	@GetMapping("/testYelpFusion")
	public String testYelpFusion() throws URISyntaxException, JsonProcessingException {
		URI location = new URI("https://api.yelp.com/v3/businesses/search?term=restaurants&location=3801+W+Temple+Ave%2C+Pomona%2C+CA+91768");

		RestTemplate restTemplate = new RestTemplate();
		RequestEntity<?> request = RequestEntity.get(location).header("Authorization", "Bearer " + API_KEY).build();
		ResponseEntity<String> response = restTemplate.exchange(request, String.class);

		ObjectMapper mapper = new ObjectMapper();
		Business business = mapper.readValue(response.getBody(), Business.class);
		return response.getBody();
	}

	@GetMapping("/getURL")
	public String getURL() throws URISyntaxException, JsonProcessingException {
		String url = "https://api.yelp.com/v3/businesses/search?term=restaurants%2C+food";
		if(!input.getAddress().equals(""))
			url += "&location=" + URLEncoder.encode(input.getAddress(), StandardCharsets.UTF_8);
		if(input.getRadius() != 0)
			url += "&radius=" + Math.round(input.getRadius() * MILESTOMETERS);
		else if(input.getRadius() >= 25)
			url += "&radius=40000";
		if(!input.getPrice().equals(""))
			url += "&price=" + input.getPrice();
		if(input.getOpenNow())
			url += "&open_now=true";
		else
			url += "&open_now=false";
		url += "&limit=50";
		
		URI location = new URI(url);
		RestTemplate restTemplate = new RestTemplate();
		RequestEntity<?> request = RequestEntity.get(location).header("Authorization", "Bearer " + API_KEY).build();
		ResponseEntity<String> response = restTemplate.exchange(request, String.class);

		ObjectMapper mapper = new ObjectMapper();
		Business business = mapper.readValue(response.getBody(), Business.class);
		System.out.println("URL: " + url);
		return response.getBody();
	}

	//Test API post (get data from frontend)
	@PostMapping("/input")
	public void postInput(@RequestBody Restaurant input){
		this.input.setAddress(input.getAddress());
		this.input.setRadius(input.getRadius());
		this.input.setPrice(input.getPrice());
		this.input.setOpenNow(input.getOpenNow());
	} 

	@GetMapping("/input")
	public String postInput(){
		return "Address: " + input.getAddress() + 
				" | Radius: " + input.getRadius() +
				" | Price: " + input.getPrice() + 
				" | Open Now: " + input.getOpenNow();
	}

	@PostMapping("/postID")
	public void postID(@RequestBody Restaurant input){
		this.input.setID(input.getID());
	}

	@GetMapping("/postID")
	public String postID(){
		return "ID: " + input.getID();
	}

	@GetMapping("/getID")
	public String getBusinessData() throws URISyntaxException, JsonProcessingException {
		String url = "https://api.yelp.com/v3/businesses/";
		url += input.getID();

		URI location = new URI(url);
		RestTemplate restTemplate = new RestTemplate();
		RequestEntity<?> request = RequestEntity.get(location).header("Authorization", "Bearer " + API_KEY).build();
		ResponseEntity<String> response = restTemplate.exchange(request, String.class);

		System.out.println("URL: " + url);
		return response.getBody();
	}

}





