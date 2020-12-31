package co.com.udem.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableAutoConfiguration //Habilitar contexto spring
@ComponentScan(basePackages="co.com.udem.crud") //Buscar en el paquete
@EnableJpaRepositories(basePackages="co.com.udem.crud.repositories")
@EnableTransactionManagement //Transacciones en la base de datos y persistencia
@EntityScan(basePackages="co.com.udem.crud.entities") //escanear las entidades

public class CruduserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruduserApplication.class, args);
	}

}
