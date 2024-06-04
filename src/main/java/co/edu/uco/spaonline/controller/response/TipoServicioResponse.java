package co.edu.uco.spaonline.controller.response;


import java.util.ArrayList;
import java.util.List;


import co.edu.uco.spaonline.dto.TipoServicioDTO;

public class TipoServicioResponse extends Response <TipoServicioDTO> {
	
	public TipoServicioResponse () {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}
	public TipoServicioResponse (final List<TipoServicioDTO> datos, final List<String> mensajes) {
		setMensajes(mensajes);
		setDatos(datos);
	}

}
