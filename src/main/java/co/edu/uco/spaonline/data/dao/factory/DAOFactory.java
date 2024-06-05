package co.edu.uco.spaonline.data.dao.factory;

import co.edu.uco.spaonline.data.dao.entity.ServicioDAO;
import co.edu.uco.spaonline.data.dao.entity.TipoIdentificacionDAO;
import co.edu.uco.spaonline.data.dao.entity.TipoServicioDAO;
import co.edu.uco.spaonline.data.dao.factory.concrete.AzureSQLDAOFactory;

public interface DAOFactory {
	
	static DAOFactory getFactory() {
		return new AzureSQLDAOFactory();
	}
	
	void abrirConexion();
	void cerrarConexion();
	void iniciarTransaccion();
	void confirmarTransaccion();
	void cancelarTransaccion();
	
	ServicioDAO getServicioDAO();
	TipoServicioDAO getTipoServicioDAO();
	TipoIdentificacionDAO getTipoIdentificacionDAO();
}