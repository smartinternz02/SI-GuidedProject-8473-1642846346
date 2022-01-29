package com.example.NutritionAssistant;


import java.io.IOException;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
public class APICall {
	
	
//	QUICK ANSWER
	public String data(String query) throws InterruptedException, IOException {
		String encoded=URLEncoder.encode(query,"UTF-8").replace("+","%20");
		String url="https://rapidapi.p.rapidapi.com/recipes/quickAnswer?q="+encoded;
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/quickAnswer?q="+encoded))
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.header("x-rapidapi-key", AppConstants.API_KEY)
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		
	return response.body();
	}
//	FOOD JOKE & TRIVIA
	public String Joke() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/jokes/random"))
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.header("x-rapidapi-key", AppConstants.API_KEY)
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		return response.body();
	}
	public String trivia() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/trivia/random"))
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.header("x-rapidapi-key", AppConstants.API_KEY)
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		
	return response.body();	
	}
//	RECIPE ACCORDING TO CALORIES
	public String recipeByCal(int cals) throws IOException, InterruptedException {
		String url="https://rapidapi.p.rapidapi.com/recipes/mealplans/generate?targetCalories="+cals+"&timeFrame=day";
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.header("x-rapidapi-key", AppConstants.API_KEY)
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		
	return response.body();	
	}
//	Convert AMOUNT
	public String convertAmount(String ingriname,String tarunit,String sourunit,float souramount) throws IOException, InterruptedException {
		String url="https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/convert?ingredientName="+ingriname+"&targetUnit="+tarunit+"&sourceUnit="+sourunit+"&sourceAmount="+souramount;
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.header("x-rapidapi-key", AppConstants.API_KEY)
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		
	return response.body();	
	}
//	NUTRITION IN A DISH
	public String nutByStringDish(String name) throws IOException, InterruptedException {
		String encoded=URLEncoder.encode(name,"UTF-8").replace("+","%20");
		String url="https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/guessNutrition?title="+encoded;
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.header("x-rapidapi-key", AppConstants.API_KEY)
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		
	return response.body();	
	}
	
	
	
	
	

}
