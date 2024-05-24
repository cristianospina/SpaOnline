package co.edu.uco.spaonline.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exceptions.custom.DataSpaOnlineException;
import co.edu.uco.spaonline.data.dao.entity.ServicioDAO;
import co.edu.uco.spaonline.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.spaonline.entity.ServicioEntity;




public class ServicioAzureSqlDAO  extends SqlConnection implements ServicioDAO {
	
	public ServicioAzureSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(ServicioEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("INSERT INTO Servicio (id, nombre, descripcion , tiposervicio , tarifa) ");
		sentenciaSql.append("SELECT ? , ? ,? , ? , ? ");

		
		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())){
			sentenciaSqlPreparada.setObject(1, data.getId());
			sentenciaSqlPreparada.setString(2, data.getNombre());
			sentenciaSqlPreparada.setObject(3, data.getDescipcion());
			sentenciaSqlPreparada.setObject(3, data.getTiposervicio());
			sentenciaSqlPreparada.setObject(3, data.getTarifa());
			
			sentenciaSqlPreparada.executeUpdate();
			
		} catch(SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de crear la ciudad \"${1}\". Por favor intente de nuevo y si el problema persiste contacte al administrador";
			var mensajeTecnico = "Se ha presentado una excepcion de tipo SQL exception tratando realizar  el insert de la ciudad \"${1}\" en la tabla \"Pais\" de la tabla AzureSQL, para mas detalles, revise de forma completa la excepcion raíz presentada... ";
			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, exception);
		}
		catch(Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de crear la ciudad \"${1}\". Por favor intente de nuevo y si el problema persiste contacte al administrador";
			var mensajeTecnico = "Se ha presentado  un problema INESPERADO con una excepcion de tipo SQL exception tratando realizar  el insert de la ciudad \"${1}\" en la tabla \"Pais\" de la tabla AzureSQL, para mas detalles, revise de forma completa la excepcion raíz presentada... ";
			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

	@Override
	public final List<ServicioEntity> consultar(ServicioEntity data) {
		List<ServicioEntity> resultado = new ArrayList<>();
		
		String sentenciaSql = formarSentenciaConsulta(data);
			
			
	
				try (final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentenciaSql)) {
			       								        
				        try (final ResultSet resultadoConsulta = sentenciaPreparada.executeQuery()) {
		
				            while (resultadoConsulta.next()) {
				            	ServicioEntity servicio = new ServicioEntity();
			                    servicio.setId((UUID) resultadoConsulta.getObject("id"));
			                    servicio.setNombre(resultadoConsulta.getString("nombre"));
			                    servicio.setDescipcion(resultadoConsulta.getString("descripcion"));
			                    servicio.setTiposervicio(resultadoConsulta.getString("tiposervicio"));
			                    servicio.setTarifa(resultadoConsulta.getLong("tarifa"));
			                    
			                    resultado.add(servicio);
				            }
				        }				
				}
				 catch (final SQLException excepcion) {
			        var mensajeUsuario = "Se ha presentado un problema tratando de consultar las ciudades...";
			        var mensajeTecnico = "Se ha presentado un problema de tipo SQLException en el método consultar de la clase CiudadAzureSqlDAO tratando de realizar la consulta de ciudades \"${1}\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
			        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
			    } 
				catch (final Exception excepcion) {
			        var mensajeUsuario = "Se ha presentado un problema tratando de consultar las ciudades...";
			        var mensajeTecnico = "Se ha presentado un problema de tipo Exception en el método consultar de la clase CiudadAzureSqlDAO tratando de realizar la consulta de ciudades \"${1}\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
			        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
			    }
			
		    return resultado;
		}
	private final String formarSentenciaConsulta(ServicioEntity data) {
		final var parametros = new ArrayList<Object>();
		final StringBuilder sentenciaSql = new StringBuilder();
		String operadorCondicional ="WHERE";
		
		sentenciaSql.append("SELECT id, nombre, descripcion, tiposervicio, tarifa FROM Servicio ");
        if (data != null) {
            if (data.getId() != null) {
                sentenciaSql.append(operadorCondicional).append(" id = ? ");
                operadorCondicional = " AND";
                parametros.add(data.getId());
            }
            if (data.getNombre() != null && !data.getNombre().isEmpty()) {
                sentenciaSql.append(operadorCondicional).append(" nombre = ? ");
                operadorCondicional = " AND";
                parametros.add(data.getNombre());
            }
            if (data.getDescipcion() != null && !data.getDescipcion().isEmpty()) {
                sentenciaSql.append(operadorCondicional).append(" descripcion = ? ");
                operadorCondicional = " AND";
                parametros.add(data.getDescipcion());
            }
            if (data.getTiposervicio() != null && !data.getTiposervicio().isEmpty()) {
                sentenciaSql.append(operadorCondicional).append(" tiposervicio = ? ");
                operadorCondicional = " AND";
                parametros.add(data.getTiposervicio());
            }
            if (data.getTarifa() != null) {
                sentenciaSql.append(operadorCondicional).append(" tarifa = ? ");
                parametros.add(data.getTarifa());
            }
        }
        sentenciaSql.append("ORDER BY id");
        
        return sentenciaSql.toString();

	}

	@Override
	public final void modificar(ServicioEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("UPDATE Servicio ");
        sentenciaSql.append("SET nombre = ?, descripcion = ?, tiposervicio = ?, tarifa = ? ");
        sentenciaSql.append("WHERE id = ?");
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentenciaSql.toString()) ) {
	        
			sentenciaPreparada.setString(1, data.getNombre());
            sentenciaPreparada.setString(2, data.getDescipcion());
            sentenciaPreparada.setString(3, data.getTiposervicio());
            sentenciaPreparada.setLong(4, data.getTarifa());
            sentenciaPreparada.setObject(5, data.getId());
            
            sentenciaPreparada.executeUpdate();
	    }
	    catch(final SQLException excepcion){
	        var mensajeUsuario = "se ha presentado un problema tratando de modificar una Ciudad";
	        var mensajeTecnico = "Se ha presentado un problema de tipo SQLException en el método modificar de la clase CiudadAzureSqlDAO tratando de llevar a cabo la modificación del Ciudad \"${1}\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
	        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "se ha presentado un problema tratando de modificar una Ciudad";
	        var mensajeTecnico = "Se ha presentado un problema de tipo Exception en el método modificar de la clase CiudadAzureSqlDAO tratando de llevar a cabo la modificación del Ciudad \"${1}\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
	        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
	    }
	}

	@Override
	public final void eliminar(UUID id) {
		final StringBuilder sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("DELETE FROM Servicio ");
        sentenciaSql.append("WHERE id = ?");
	    
	    try(final var sentenciaPreparada = getConexion().prepareStatement(sentenciaSql.toString()) ) {
	    	sentenciaPreparada.setObject(1, id);
            sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información de la Ciudad...";
	        var mensajeTecnico = "Se ha presentado un problema de tipo SQLException en el método eliminar de la clase CiudadAzureSqlDAO tratando de eliminar la Ciudad \"${1}\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
	        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del cliente...";
	        var mensajeTecnico = "Se ha presentado un problema de tipo Exception en el método eliminar de la clase CiudadAzureSqlDAO tratando de eliminar la Ciudad \"${1}\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
	        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
	    }
		
	}

	
}
