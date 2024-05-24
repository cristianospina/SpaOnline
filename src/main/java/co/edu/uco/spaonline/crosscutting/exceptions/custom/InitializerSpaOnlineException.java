package co.edu.uco.spaonline.crosscutting.exceptions.custom;

import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.enums.Lugar;

public class InitializerSpaOnlineException extends SpaOnlineException {

	private static final long serialVersionUID = 7531504679363475368L;
	
	protected InitializerSpaOnlineException(String mensajeTecnico, String mensajeUsuario, Lugar lugar,
			Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
	protected InitializerSpaOnlineException(String mensajeTecnico, String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, Lugar.INITIALIZER);
	}

	protected InitializerSpaOnlineException(String mensajeTecnico) {
		super(mensajeTecnico, Lugar.INITIALIZER);
	}
	
}
