package co.com.udem.clubfutbol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.modelmapper.ModelMapper;

import co.com.udem.clubfutbol.dto.DirectorTecnicoDTO;
import co.com.udem.clubfutbol.util.ConvertClubFutbol;
import co.com.udem.clubfutbol.util.ConvertDirectorTecnico;

@SpringBootApplication
@EnableDiscoveryClient //Permite que eureka detecte la aplicación
public class ClubfutbolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubfutbolApplication.class, args);
	}
	
	@Bean
	public ConvertClubFutbol convertClubFutbol() {		
		return new ConvertClubFutbol();
	}
	
	@Bean
	public ModelMapper modelMapper() {		
		return new ModelMapper();
	}
	
	@Bean
	public DirectorTecnicoDTO directorTecnicoDTO() {		
		return new DirectorTecnicoDTO();
	}
	
	@Bean
	public ConvertDirectorTecnico convertDirectorTecnico() {
		return new ConvertDirectorTecnico();
	}
	
	@Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

}
