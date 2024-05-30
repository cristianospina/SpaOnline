package co.edu.uco.spaonline.data.dao.entity.concrete.azuresql;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import co.edu.uco.spaonline.crosscutting.exceptions.custom.DataSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.helpers.NumHelper;
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
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00063);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00064);

			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, exception);
		}
		catch(Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00065);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00066);

			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, exception);
		}
		
		
	}

	@Override
	public void modificar(ServicioEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		
			sentenciaSql.append("UPDATE Servicio ");
			sentenciaSql.append ("SET nombre = ? , descripcion = ? , tiposervicio = ? , tarifa = ? ");
			sentenciaSql.append ("WHERE id = ? ");
			
			try(final var sentenciaPreparada = getConexion().prepareStatement(sentenciaSql.toString()) ) {
		        
		        sentenciaPreparada.setString(1, data.getNombre());
		        sentenciaPreparada.setString(2, data.getDescipcion());
		        sentenciaPreparada.setString(3, data.getTiposervicio());
		        sentenciaPreparada.setLong(4, data.getTarifa());
		        sentenciaPreparada.setObject(5, data.getId());
		        
		        
		        sentenciaPreparada.executeUpdate();
		    }
		    catch(final SQLException excepcion){
		        var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00067);
		        var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00068);
		        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
		    } catch (final Exception excepcion) {
		        var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00069);
		        var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00070);
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
				            	ServicioEntity servicio = new ServicioEntity();
				            	servicio.setId( UUIDHelper.convertToUUID(resultadoConsulta.getString("id")) );
				            	servicio.setNombre(resultadoConsulta.getString("nombre"));
				            	servicio.setDescipcion(resultadoConsulta.getString("descripcion"));
				            	servicio.setTiposervicio(resultadoConsulta.getString("tiposervicio"));
				            	servicio.setTarifa(resultadoConsulta.getLong("tarifa"));
				                
				                resultado.add(servicio);
				            }
				        }				
				}
				 catch (final SQLException excepcion) {
			        var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00071);
			        var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00072);
			        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
			    } 
				catch (final Exception excepcion) {
			        var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00071);
			        var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00074);
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
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00071);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00073);
			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
		}
		catch(final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00076);
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
			if(!ObjectHelper.isNull(data.getTarifa())&& !NumHelper.isDefaultValue(data.getTarifa())) {
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
	        var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00077);
	        var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00078);
	        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00077);
	        var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00079);
	        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
	    }
	}
}
