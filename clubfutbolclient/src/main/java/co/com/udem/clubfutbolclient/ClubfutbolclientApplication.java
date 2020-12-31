package co.com.udem.clubfutbolclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import co.com.udem.clubfutbolclient.entities.UserToken;

@SpringBootApplication
@EnableEurekaClient
public class ClubfutbolclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubfutbolclientApplication.class, args);
	}
	
	@Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
   
    @Bean
    UserToken userToken() {
        return new UserToken();
    }

}
