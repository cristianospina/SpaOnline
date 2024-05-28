package co.edu.uco.spaonline.crosscutting.exceptions.custom;

import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.enums.Lugar;

public class EntitySpaOnlineException extends SpaOnlineException{
	
	private static final long serialVersionUID = 2986087650664440709L;
	
	protected EntitySpaOnlineException(String mensajeTecnico, String mensajeUsuario, Lugar lugar, Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
	
	protected EntitySpaOnlineException(String mensajeTecnico, String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario,Lugar.ENTITY);
	}

	protected EntitySpaOnlineException(String mensajeTecnico) {
		super(mensajeTecnico, Lugar.ENTITY);
	}
}
