package co.com.udem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.udem.interfaces.Vehiculo;

@Component
public class VehiculoService {
	
	@Autowired
	@Qualifier("bicicletaBean") //indicar que quiero implementar es lo de bicleta
	private Vehiculo vehiculo;
	
	public void imprimirMensajeVehiculo()
	{
		vehiculo.start();
		vehiculo.stop();
	}

}
