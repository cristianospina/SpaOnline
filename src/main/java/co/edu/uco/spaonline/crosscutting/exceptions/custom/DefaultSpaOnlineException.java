package co.edu.uco.spaonline.crosscutting.exceptions.custom;

import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.enums.Lugar;

public class DefaultSpaOnlineException extends  SpaOnlineException {

	private static final long serialVersionUID = 8373546155402014400L;

	protected DefaultSpaOnlineException(String mensajeTecnico, String mensajeUsuario, Lugar lugar, Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
	
	protected DefaultSpaOnlineException(String mensajeTecnico, String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, Lugar.DEFAULT);
	}
	
	protected DefaultSpaOnlineException(String mensajeTecnico) {
		super(mensajeTecnico, Lugar.DEFAULT);
	}
}
