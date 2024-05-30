package co.edu.uco.spaonline.data.dao.factory.concrete;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.spaonline.crosscutting.exceptions.custom.DataSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.helpers.SQLHelper;
import co.edu.uco.spaonline.data.dao.entity.ServicioDAO;
import co.edu.uco.spaonline.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.spaonline.data.dao.entity.concrete.azuresql.ServicioAzureSqlDAO;

import co.edu.uco.spaonline.data.dao.factory.DAOFactory;

public final class AzureSQLDAOFactory extends SqlConnection implements DAOFactory {

	public AzureSQLDAOFactory() {
		super();
		abrirConexion();
	}

	public void abrirConexion() {
		final String connectionUrl = "jdbc:sqlserver://spaonline-server.database.windows.net:1433;database=SpaOnline;user=administrador@spaonline-server;password=Mateoandres12353;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try {
			setConexion(DriverManager.getConnection(connectionUrl));
		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00080);

			throw new DataSpaOnlineException(mensajeTecnico, mensajeUsuario, excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00081);

			throw new DataSpaOnlineException(mensajeTecnico, mensajeUsuario, excepcion);
		}
	}


	@Override
	public void cerrarConexion() {
		SQLHelper.close(getConexion());
	}

	@Override
	public void iniciarTransaccion() {
		SQLHelper.initTransaction(getConexion());
	}

	@Override
	public void confirmarTransaccion() {
		SQLHelper.commit(getConexion());
	}

	@Override
	public void cancelarTransaccion() {
		SQLHelper.rollback(getConexion());
	}

	@Override
	public ServicioDAO getServicioDAO() {
		return new ServicioAzureSqlDAO(getConexion());
	}


}