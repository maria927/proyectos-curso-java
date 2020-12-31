package co.com.udem.clubfutbolclient.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import co.com.udem.clubfutbolclient.domain.AutenticationRequestDTO;
import co.com.udem.clubfutbolclient.domain.AutenticationResponseDTO;
import co.com.udem.clubfutbolclient.domain.ClubFutbolDTO;
import co.com.udem.clubfutbolclient.entities.UserToken;
import co.com.udem.clubfutbolclient.repositories.UserTokenRepository;

@RestController
public class ClubFutbolClientRestController {
	
	@Autowired
    RestTemplate restTemplate;
   
    @Autowired
    UserTokenRepository userTokenRepository;
   
    @Autowired
    UserToken userToken;
    
    @Autowired
    private LoadBalancerClient loadBalancer;
   
    @PostMapping("/autenticar")
    public String autenticar(@RequestBody AutenticationRequestDTO autenticationRequestDTO) {
    	
    	//Con balanceador de carga
    	
    	ServiceInstance serviceInstance=loadBalancer.choose("clubfutbol");
        System.out.println(serviceInstance.getUri());
        String baseUrl=serviceInstance.getUri().toString();
        baseUrl=baseUrl+"/auth/signin";
        ResponseEntity<String> postResponse = restTemplate.postForEntity(baseUrl, autenticationRequestDTO, String.class);
        System.out.println("Respuesta: "+postResponse.getBody());  //Recibe un xml
        
        Gson g = new Gson();
        AutenticationResponseDTO autenticationResponseDTO = g.fromJson(postResponse.getBody(), AutenticationResponseDTO.class);
        userToken.setUsername(autenticationResponseDTO.getUsername());
        userToken.setToken(autenticationResponseDTO.getToken());
        userTokenRepository.save(userToken);
        return autenticationResponseDTO.getToken();
 
    	
    	 ///////////Sin balanceador//////////////
    	
//        ResponseEntity<String> postResponse = restTemplate.postForEntity("http://localhost:9090/auth/signin", autenticationRequestDTO, String.class);
//        Gson g = new Gson();
//        AutenticationResponseDTO autenticationResponseDTO = g.fromJson(postResponse.getBody(), AutenticationResponseDTO.class);
//        userToken.setUsername(autenticationResponseDTO.getUsername());
//        userToken.setToken(autenticationResponseDTO.getToken());
//        userTokenRepository.save(userToken);
//        return autenticationResponseDTO.getToken();
       
    }
   
    @GetMapping("/consultarClubes")
    public List<ClubFutbolDTO> guardarClubFutbol() {
        List<ClubFutbolDTO> clubes = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWxpbyIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE1OTUwODQwNTYsImV4cCI6MTU5NTA4NzY1Nn0.zDmFbPvik0KF5Arvmy6AgWqsgpGmJGgtuBRGGz-UFLA");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:9090/clubes", HttpMethod.GET, entity, String.class);
        try {
            clubes = new ObjectMapper().readValue(response.getBody(), new TypeReference<List<ClubFutbolDTO>>() {});
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return clubes;
       
    }

}
