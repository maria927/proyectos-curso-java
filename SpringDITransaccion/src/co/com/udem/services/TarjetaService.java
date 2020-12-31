package co.com.udem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.udem.interfaces.Tarjeta;

@Component
public class TarjetaService {
	
	@Autowired
	@Qualifier("debitoBean")
	private Tarjeta tarjetaDebito;
	
	@Autowired
	@Qualifier("creditoBean")
	private Tarjeta tarjetaCredito;
	
	public void imprimirMensajeVehiculo()
	{
		tarjetaDebito.validarSaldo();
		tarjetaDebito.efectuarRetiro();
		tarjetaCredito.validarSaldo();
		tarjetaCredito.efectuarRetiro();
	}

}
