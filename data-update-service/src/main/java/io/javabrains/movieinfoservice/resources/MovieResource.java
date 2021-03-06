package io.javabrains.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class MovieResource {

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World from Update service";
	}

	@RequestMapping({ "/update" })
	public String update() {
		return "Hello World from Update service";
	}

}
