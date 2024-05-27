package co.edu.uco.spaonline.crosscutting.exceptions.custom;

import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.enums.Lugar;

public final class DataSpaOnlineException extends SpaOnlineException{

	private static final long serialVersionUID = -3786840150696753545L;
	
	public DataSpaOnlineException(String mensajeUsuario, String mensajeTecnico, Lugar lugar, Throwable excepcion) {
		super(mensajeTecnico, mensajeUsuario, Lugar.DATA, excepcion);
	}
	
	public DataSpaOnlineException(String mensajeUsuario, String mensajeTecnico) {
		super(mensajeTecnico, mensajeUsuario,Lugar.DATA);
	}
	
	public DataSpaOnlineException(String mensajeUsuario, String mensajeTecnico , Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario,Lugar.DATA, excepcionRaiz);
	}

	
	public DataSpaOnlineException(String mensajeUsuario ) {
		super(mensajeUsuario, Lugar.DATA);
	}

}
