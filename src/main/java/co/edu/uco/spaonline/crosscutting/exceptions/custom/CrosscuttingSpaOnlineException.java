package co.edu.uco.spaonline.crosscutting.exceptions.custom;


import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.enums.Lugar;

public class CrosscuttingSpaOnlineException extends SpaOnlineException {

	private static final long serialVersionUID = 4526879296082603189L;

	public CrosscuttingSpaOnlineException(String mensajeTecnico, String mensajeUsuario, Lugar lugar,
			Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
	public CrosscuttingSpaOnlineException(String mensajeTecnico, String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, Lugar.CROSSCUTTING );
	}
	public CrosscuttingSpaOnlineException(String mensajeTecnico, String mensajeUsuario, Throwable excepcioRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.CROSSCUTTING, excepcioRaiz );
	}
	
	public CrosscuttingSpaOnlineException(String mensajeTecnico) {
		super(mensajeTecnico, Lugar.CROSSCUTTING);
	}

}
