package co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data;

public final class Mensaje {
	
	private CodigoMensaje codigo;
	private String contenido;

	
	
	public  Mensaje(CodigoMensaje codigo, String contenido ) {
		setCodigo(codigo);
		setContenido(contenido);
	}
	
	private final void setCodigo(final CodigoMensaje codigo) {
		this.codigo = codigo;
	}


	private final void setContenido(final String contenido) {
		this.contenido = contenido;
	}

	private final CodigoMensaje getCodigo() {
		return codigo;
	}


	public final TipoMensaje getTipo() {
		return getCodigo().getTipo();
	}
	public final CategoriaMensaje getCategoria() {
		return getCodigo().getCategoria();
	}

	public final String getContenido() {
		return contenido;
	}
	
	public final String getIdentificador() {
		return getCodigo().getIdentificador();
	}

	public final boolean esBase() {
		return codigo.esBase();
	}
	
	
}
