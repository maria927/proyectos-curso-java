package co.com.udem.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.udem.interfaces.Vehiculo;

@Component
@Qualifier("motocicletaBean")
public class Motocicleta implements Vehiculo {

	@Override
	public void start() {
		System.out.println("Se est� arrancando la motocicleta");
	}

	@Override
	public void stop() {
		System.out.println("Se est� deteniendo la motocicleta");

	}

}
