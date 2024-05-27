package co.edu.uco.spaonline.data.dao.entity.concrete.azuresql;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import co.edu.uco.spaonline.crosscutting.exceptions.custom.DataSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;
import co.edu.uco.spaonline.crosscutting.helpers.TextHelper;
import co.edu.uco.spaonline.crosscutting.helpers.UUIDHelper;
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
		
		sentenciaSql.append("INSERT INTO Servicio ( id , nombre , descripcion , tiposervicio , tarifa ) ");
		sentenciaSql.append(" VAlUES ( ? , ? , ? , ? , ? )");
		
		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())){
			sentenciaSqlPreparada.setObject(1, data.getId());
			sentenciaSqlPreparada.setString(2, data.getNombre());
			sentenciaSqlPreparada.setString(3, data.getDescipcion());
			sentenciaSqlPreparada.setString(4, data.getTiposervicio());
			sentenciaSqlPreparada.setLong(5, data.getTarifa());
			
			
			sentenciaSqlPreparada.executeUpdate();
			
		} catch(SQLException exception) {
			var mensajeUsuario = "Se ha presentado un error al intentar crear un servicio, por favor intentarlo más tardes...";
			var mensajeTecnico = "Se ha presentado un error de tipo SQLException tratando de crear un nuevo servicio";
			//var mensajeUsuario = TextHelper.reemplazarParametro(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00030), exception) ;
			//var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00031);
			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, exception);
		}
		catch(Exception exception) {
			var mensajeUsuario = "Se ha presentado un error INESPERADO al intentar crear un servicio, por favor intentarlo más tardes...";
			var mensajeTecnico = "Se ha presentado un error de tipo Exception tratando de crear un nuevo servicio";
			//var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00030);
			//var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00032);
			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, exception);
		}
		
		
	}

	@Override
	public void modificar(ServicioEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		
			sentenciaSql.append("UPDATE Servicio ");
			sentenciaSql.append ("SET nombre = ? , departamento = ? , descripcion = ? , tiposervicio = ? , tarifa = ? ");
			sentenciaSql.append ("WHERE id = ?");
			
			try(final var sentenciaPreparada = getConexion().prepareStatement(sentenciaSql.toString()) ) {
		        
		        sentenciaPreparada.setString(1, data.getNombre());
		        sentenciaPreparada.setString(2, data.getDescipcion());
		        sentenciaPreparada.setString(3, data.getTiposervicio());
		        sentenciaPreparada.setLong(4, data.getTarifa());
		        sentenciaPreparada.setObject(5, data.getId());
		        
		        
		        sentenciaPreparada.executeUpdate();
		    }
		    catch(final SQLException excepcion){
		        var mensajeUsuario = "se ha presentado un problema tratando de modificar un Servicio";
		        var mensajeTecnico = "Se ha presentado un problema de tipo SQLException en el método modificar de la clase ServicioAzureSqlDAO tratando de llevar a cabo la modificación de Servicio \"${1}\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
		        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
		    } catch (final Exception excepcion) {
		        var mensajeUsuario = "se ha presentado un problema tratando de modificar un Servicio";
		        var mensajeTecnico = "Se ha presentado un problema de tipo Exception en el método modificar de la clase ServicioAzureSqlDAO tratando de llevar a cabo la modificación de Servicio \"${1}\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
		        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
		    }
		
	}

	@Override
	public final List<ServicioEntity> consultar(ServicioEntity data) {
		List<ServicioEntity> resultado = new ArrayList<>();
		var parametros = new ArrayList<Object>();
		
		String sentenciaSql = formarSentenciaConsulta(data,parametros);
			
	
				try (final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentenciaSql)) {
					colocarParametrosConsulta(sentenciaPreparada, parametros );					        
				        try (final ResultSet resultadoConsulta = sentenciaPreparada.executeQuery()) {
		
				            while (resultadoConsulta.next()) {
				            	ServicioEntity ciudad = new ServicioEntity();
				                ciudad.setId( UUIDHelper.convertToUUID(resultadoConsulta.getString("id")) );
				                ciudad.setNombre(resultadoConsulta.getString("nombre"));
				                ciudad.setDescipcion(resultadoConsulta.getString("descripcion"));
				                ciudad.setTiposervicio(resultadoConsulta.getString("tiposervicio"));
				                ciudad.setTarifa(resultadoConsulta.getLong("tarifa"));
				                
				                resultado.add(ciudad);
				            }
				        }				
				}
				 catch (final SQLException excepcion) {
			        var mensajeUsuario = "Se ha presentado un problema tratando de consultar los servicios...";
			        var mensajeTecnico = "Se ha presentado un problema de tipo SQLException en el método consultar de la clase ServicioAzureSqlDAO tratando de realizar la consulta de Servicio \"${1}\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
			        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
			    } 
				catch (final Exception excepcion) {
			        var mensajeUsuario = "Se ha presentado un problema tratando de consultar los servicios...";
			        var mensajeTecnico = "Se ha presentado un problema de tipo Exception en el método consultar de la clase ServicioAzureSqlDAO tratando de realizar la consulta de Servicio \"${1}\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
			        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
			    }
			
		    return resultado;
		}
	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros ) {
		try {
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1 , parametros.get(indice));
			}
			
		}catch(final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar las ciudades...";
			var mensajeTecnico = "Se ha presentado un problema de tipo SQLEXCEPTION tratando de colocar los parametros de consulta";
			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
		}
		catch(final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar las ciudades...";
			var mensajeTecnico =  "Se ha presentado un problema de tipo Exception tratandode colocar los parametros de consulta...";
			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}
	private final String formarSentenciaConsulta(ServicioEntity data , List<Object> parametros) {
		
		final StringBuilder sentenciaSql = new StringBuilder();
		String operadorCondicional ="WHERE";
		
		sentenciaSql.append("SELECT id , nombre , descripcion , tiposervicio , tarifa FROM Servicio ");
		if(!ObjectHelper.isNull(data)) {
			
			if(!ObjectHelper.isNull(data.getId())&& !UUIDHelper.isDefault(data.getId())) {
				sentenciaSql.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = " AND";
				parametros.add(data.getId());
			}
			if(!TextHelper.isNullOrEmpty(data.getNombre())) {
				sentenciaSql.append(operadorCondicional).append(" nombre = ? ");
				operadorCondicional = " AND";
				parametros.add(data.getNombre());
			}
			if(!TextHelper.isNullOrEmpty(data.getDescipcion())) {
				sentenciaSql.append(operadorCondicional).append(" descripcion = ? ");
				operadorCondicional = " AND";
				parametros.add(data.getDescipcion());
			}
			if(!TextHelper.isNullOrEmpty(data.getTiposervicio())) {
				sentenciaSql.append(operadorCondicional).append(" tiposervicio = ? ");
				operadorCondicional = " AND";
				parametros.add(data.getTiposervicio());
			}
			if(!ObjectHelper.isNull(data.getTarifa())) {
				sentenciaSql.append(operadorCondicional).append(" tarifa = ? ");
				parametros.add(data.getTarifa());
			}
			
		}
		sentenciaSql.append("ORDER BY nombre ");
		
		return sentenciaSql.toString();

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
