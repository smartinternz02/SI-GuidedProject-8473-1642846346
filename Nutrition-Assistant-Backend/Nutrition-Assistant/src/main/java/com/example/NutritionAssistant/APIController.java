package com.example.NutritionAssistant;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
@CrossOrigin(originPatterns = {"*"})
public class APIController {
	
	@Autowired
	private APICall apiCall;
	
	@GetMapping("/quickanswer")
	public ResponseEntity<?> quickAnswerEndPoint(@RequestParam(name = "query") String query){
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("success", true);
		try {
			jsonObject = new JSONObject(apiCall.data(query));
			if(!jsonObject.has("answer")) {
				responseMap.put("success", false);
				responseMap.put("message", "Ask the right question ?");
			}else {
				responseMap.put("answer", jsonObject.get("answer"));
				if(jsonObject.has("image")) {
					responseMap.put("image",jsonObject.get("image"));
				}
			}
		} catch (JSONException | InterruptedException | IOException e) {
			e.printStackTrace();
			responseMap.put("message", "Error fetching response from API !");
		}
				
		return ResponseEntity.ok(responseMap);
	}
	
	@GetMapping("/randomjoke")
	public ResponseEntity<?> foodjoke() {
		JSONObject jsonObject=new JSONObject();
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("success", true);
		try {
			jsonObject = new JSONObject(apiCall.Joke());
			if(!jsonObject.has("text")) {
				responseMap.put("success", false);
				responseMap.put("message", "Ask the right question ?");
				
			}else {
				responseMap.put("text", jsonObject.get("text"));
				
			}
			
		} catch (JSONException | InterruptedException | IOException e) {
			e.printStackTrace();
			responseMap.put("message", "Error fetching response from API !");
		}
		return ResponseEntity.ok(responseMap);
	}
	
	@GetMapping("/randomtrivia")
	public ResponseEntity<?> foodtrivia() {
		JSONObject jsonObject=new JSONObject();
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("success", true);
		try {
			jsonObject = new JSONObject(apiCall.trivia());
			if(!jsonObject.has("text")) {
				responseMap.put("success", false);
				responseMap.put("message", "Ask the right question ?");
				
			}else {
				responseMap.put("text", jsonObject.get("text"));
				
			}
			
		} catch (JSONException | InterruptedException | IOException e) {
			e.printStackTrace();
			responseMap.put("message", "Error fetching response from API !");
		}
		return ResponseEntity.ok(responseMap);
	}
	
	@GetMapping("/resbycals/{calories}")
	public ResponseEntity<?> resbycals(@PathVariable("calories") int calories) {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("success", true);
		try {
			jsonObject = new JSONObject(apiCall.recipeByCal(calories));
		} catch (JSONException | InterruptedException | IOException e) {
			e.printStackTrace();
			jsonObject.put("success", false);
			jsonObject.put("message", "Error fetching response from API !");
		}
		return ResponseEntity.ok(jsonObject.toMap());
	}
	
	@GetMapping("/convert")
	public ResponseEntity<?> convert(@RequestParam("ingridientsname") String ingridientsname,@RequestParam("targetunit") String targetunit,@RequestParam("sourceunit") String sourceunit,@RequestParam("sourceamount") float sourceamount) {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("success", true);
		try {
			jsonObject = new JSONObject(apiCall.convertAmount(ingridientsname, targetunit, sourceunit, sourceamount));
		} catch (JSONException | InterruptedException | IOException e) {
			e.printStackTrace();
			jsonObject.put("success", false);
			jsonObject.put("message", "Error fetching response from API !");
		}
		return ResponseEntity.ok(jsonObject.toMap());
	}
	
	@GetMapping("/getnutri")
	public ResponseEntity<?> getnutri(@RequestParam("name") String name) {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("success", true);
		try {
			jsonObject = new JSONObject(apiCall.nutByStringDish(name));
		} catch (JSONException | InterruptedException | IOException e) {
			e.printStackTrace();
			jsonObject.put("success", false);
			jsonObject.put("message", "Error fetching response from API !");
		}
		return ResponseEntity.ok(jsonObject.toMap());
	}
}