package co.edu.uco.spaonline.data.dao.entity.concrete;

import java.sql.Connection;

import co.edu.uco.spaonline.crosscutting.exceptions.custom.DataSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.helpers.SQLHelper;

public class SqlConnection {

	private Connection conexion;
	
	protected SqlConnection(Connection conexion) {
		setConexion(conexion);
	}
	protected SqlConnection() {
		super();
	}

	protected Connection getConexion() {
		return conexion;
	}

	protected final void setConexion(Connection conexion) {
		if(!SQLHelper.isOpen(conexion)) {
			var mensajeUsuario =MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			var mensajeTecnicoo = "no es posible crear el DAO deseado con una conexion cerrada";			
			throw new DataSpaOnlineException(mensajeTecnicoo, mensajeUsuario);
		}
		this.conexion = conexion;
	}

}