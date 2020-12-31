package co.com.udem.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.udem.interfaces.Tarjeta;

@Component
@Qualifier("creditoBean")
public class TarjetaCredito implements Tarjeta {

	@Override
	public void validarSaldo() {
		System.out.println("Validar saldo tarjeta crédito");

	}

	@Override
	public void efectuarRetiro() {
		System.out.println("Efectuar retiro tarjeta crédito");
		
	}

}
