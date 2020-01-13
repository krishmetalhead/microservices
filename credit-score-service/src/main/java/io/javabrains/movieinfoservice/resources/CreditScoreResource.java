package io.javabrains.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/creditscore")
public class CreditScoreResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping("/{userId}")
   	public String generateScore(@PathVariable("userId") String userId) {
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Credit service taking longer than hystrix threshold time which is 2000 ms");
			e.printStackTrace();
		}
    	System.out.println("Inside generateScore() of Credit Score service");
   		return "100";
   	}

    

}
