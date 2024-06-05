package co.edu.uco.spaonline.controller.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.dto.TipoIdentificacionDTO;


public class TipoIdentificacionResponse extends Response <TipoIdentificacionDTO> {
	
	public TipoIdentificacionResponse () {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}
	public TipoIdentificacionResponse (final List<TipoIdentificacionDTO> datos, final List<String> mensajes) {
		setMensajes(mensajes);
		setDatos(datos);
	}

}
