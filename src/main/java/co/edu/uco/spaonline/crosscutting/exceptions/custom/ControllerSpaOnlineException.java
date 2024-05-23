package co.edu.uco.spaonline.crosscutting.exceptions.custom;

import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.enums.Lugar;

public class ControllerSpaOnlineException extends SpaOnlineException{

	private static final long serialVersionUID = 3291470665555273037L;
	
	protected ControllerSpaOnlineException(String mensajeTecnico, String mensajeUsuario, Lugar lugar,
			Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	
	}
	protected ControllerSpaOnlineException(String mensajeTecnico, String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, Lugar.CONTROLLER);
	
	}
	
	protected ControllerSpaOnlineException(String mensajeTecnico) {
		super(mensajeTecnico, Lugar.CONTROLLER);
	}
	

}
