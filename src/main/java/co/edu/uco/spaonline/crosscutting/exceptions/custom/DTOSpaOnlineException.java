package co.edu.uco.spaonline.crosscutting.exceptions.custom;

import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.enums.Lugar;

public class DTOSpaOnlineException extends SpaOnlineException{

	
	private static final long serialVersionUID = 4880724831403018987L;

	protected DTOSpaOnlineException(String mensajeTecnico, String mensajeUsuario, Lugar lugar, Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
		
	}
	protected DTOSpaOnlineException(String mensajeTecnico, String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, Lugar.DTO);
		
	}
	protected DTOSpaOnlineException(String mensajeTecnico) {
		super(mensajeTecnico, Lugar.DTO);
		
	}

}
