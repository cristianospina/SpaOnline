package co.edu.uco.spaonline.controller.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.dto.ServicioDTO;

public class ServicioResponse extends Response <ServicioDTO>{
	
	public ServicioResponse () {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}
	public ServicioResponse (final List<ServicioDTO> datos, final List<String> mensajes) {
		setMensajes(mensajes);
		setDatos(datos);
	}

}
