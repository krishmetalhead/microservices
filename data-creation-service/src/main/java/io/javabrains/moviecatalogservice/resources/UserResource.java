package io.javabrains.moviecatalogservice.resources;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.javabrains.moviecatalogservice.models.User;

@RestController
@RequestMapping("/user")
public class UserResource {
	
	@Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;
    
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping({ "/test" })
	public String firstPage() {
		return "This is test service";
		
	}
    
    @RequestMapping({ "/create" })
    @HystrixCommand(fallbackMethod="createUserFallback",
    commandProperties= {
    	@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="2000"),
    	//@HystrixProperty(name = "hystrix.command.default.circuitBreaker.enabled", value = "false"),
    	@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value="3"),
    	//@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="50")
    	
    })
    //@HystrixCommand(fallbackMethod="createUserFallback")
   	public User createUser(@RequestBody User user) {
    	LOG.info("Inside createUser method of UserResource of Data Creation Service");
   		String rating =  restTemplate.getForObject("http://credit-score-service/creditscore/"+user.getUserId(),String.class);
   		user.setCreditScore(rating);
   		//Jpa code to push to actual data base
   		//If no error push the payload to active mq
   		LOG.info("Sending message into queue");
   		jmsTemplate.convertAndSend(queue, "User Created");     
   		
   		return user;
   		
   	}
    
	private User createUserFallback(User user)
	{

		System.out.println("Inside Fall back method :::: ");
		user.setCreditScore("99.99");
		return user;
	}

    /*@RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);

        return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());

    }*/
}

/*
Alternative WebClient way
Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve().bodyToMono(Movie.class).block();
*/