package co.com.udem.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.udem.interfaces.Vehiculo;

@Component
@Qualifier("bicicletaBean") 
public class Bicicleta implements Vehiculo {

	@Override
	public void start() {
		System.out.println("Se está iniciando la bicicleta");

	}

	@Override
	public void stop() {
		System.out.println("Se está deteniendo la bicicleta");
	}

}
