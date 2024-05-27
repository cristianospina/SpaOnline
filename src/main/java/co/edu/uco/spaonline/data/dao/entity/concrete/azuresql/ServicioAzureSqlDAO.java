package co.edu.uco.spaonline.data.dao.entity.concrete.azuresql;

import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.uco.spaonline.crosscutting.exceptions.custom.DataSpaOnlineException;
import co.edu.uco.spaonline.data.dao.entity.ServicioDAO;
import co.edu.uco.spaonline.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.spaonline.entity.ServicioEntity;

public final class ServicioAzureSqlDAO extends SqlConnection implements ServicioDAO {
	
	public ServicioAzureSqlDAO(final Connection conexion) {
		super (conexion);
		
	}

	@Override
	public void crear(ServicioEntity data) {
		
		final StringBuilder sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("INSERT INTO Servicio (id, nombre,) ");
		sentenciaSql.append("SELECT ? , ? ");
		
		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())){
			sentenciaSqlPreparada.setObject(1, data.getId());
			sentenciaSqlPreparada.setString(2, data.getNombre());
			
			
			sentenciaSqlPreparada.executeUpdate();
			
		} catch(SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de crear el servicio \\\"${1}\\\". Por favor intente de nuevo y si el problema persiste contacte al administrador";
			var mensajeTecnico = "Se ha presentado una excepcion de tipo SQL exception tratando realizar  el insert del servicio \\\"${1}\\\" para mas detalles, revise de forma completa la excepcion raíz presentada...";
			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, exception);
		}
		catch(Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de crear el servicio \\\"${1}\\\". Por favor intente de nuevo y si el problema persiste contacte al administrador" ;
			var mensajeTecnico = "Se ha presentado  un problema INESPERADO con una excepcion de tipo SQL exception tratando realizar  el insert del servicio";
			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, exception);
		}
	
	
		
	}

	@Override
	public void modificar(ServicioEntity data) {
		
		
	}

	@Override
	public void consultar(ServicioEntity data) {
		
	}

	@Override
	public void eliminar(UUID id) {
		final StringBuilder sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("DELETE FROM Servicio ");
		sentenciaSql.append ("WHERE id = ?");
	    
	    try(final var sentenciaPreparada = getConexion().prepareStatement(sentenciaSql.toString()) ) {
	        sentenciaPreparada.setObject(1,id);
	        sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del servicio...";
	        var mensajeTecnico = "Se ha presentado un problema de tipo SQLException en el método eliminar de la clase ServicioAzureSqlDAO tratando de eliminar el Servicio \"${1}\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
	        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del cliente...";
	        var mensajeTecnico = "Se ha presentado un problema de tipo Exception en el método eliminar de la clase ServicioAzureSqlDAO tratando de eliminar el Servicio \"${1}\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
	        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
	    }
	}

}
