package com.app.recipe.util.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RegistInit {
	public static void user_rating_init(String id) {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new FormHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(converters);
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		String result = null;
		try {
			result = restTemplate.getForObject(String.format("http://3.34.181.233:5000/recipe_data?id=%s", id),
					String.class, params);
		} catch (RestClientException e) {
			System.out.println("analytics server closed");
		}
		System.out.println("result:" + result);
	}
}
