package co.edu.uco.spaonline.crosscutting.exceptions;

import co.edu.uco.spaonline.crosscutting.exceptions.enums.Lugar;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;
import co.edu.uco.spaonline.crosscutting.helpers.TextHelper;

public class SpaOnlineException extends RuntimeException {

	private static final long serialVersionUID = -1204292929766811976L;
	protected String mensajeUsuario;
	protected Lugar lugar;
	
	protected SpaOnlineException(String mensajeTecnico,String mensajeUsuario, Lugar lugar , Throwable excepcionRaiz) {
		super(mensajeTecnico, excepcionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}
	protected SpaOnlineException(String mensajeTecnico,String mensajeUsuario, Lugar lugar ) {
		super(mensajeTecnico);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}
	protected SpaOnlineException(String mensajeUsuario, Lugar lugar ) {
		super(mensajeUsuario, new Exception());
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}

	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = TextHelper.applyTrim(mensajeUsuario);
	}

	private final void setLugar(final Lugar lugar) {
		this.lugar= ObjectHelper.getObjectHelper().getDefaultValue(lugar);
	}

	
}