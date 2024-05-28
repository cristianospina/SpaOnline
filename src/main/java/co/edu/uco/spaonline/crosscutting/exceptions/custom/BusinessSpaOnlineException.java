package co.edu.uco.spaonline.crosscutting.exceptions.custom;

import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.enums.Lugar;

public class BusinessSpaOnlineException extends SpaOnlineException{

	private static final long serialVersionUID = -772840292783193403L;
	
	protected BusinessSpaOnlineException(String mensajeTecnico, String mensajeUsuario, Lugar lugar, Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
	
	public BusinessSpaOnlineException(String mensajeTecnico, String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
	}
	
	public BusinessSpaOnlineException(String mensajeTecnico) {
		super(mensajeTecnico, Lugar.BUSINESS);
	}
}
