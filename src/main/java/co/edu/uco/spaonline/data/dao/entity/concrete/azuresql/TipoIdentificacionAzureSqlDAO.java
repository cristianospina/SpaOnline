package co.edu.uco.spaonline.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.crosscutting.exceptions.custom.DataSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;
import co.edu.uco.spaonline.crosscutting.helpers.TextHelper;
import co.edu.uco.spaonline.crosscutting.helpers.UUIDHelper;
import co.edu.uco.spaonline.data.dao.entity.TipoIdentificacionDAO;
import co.edu.uco.spaonline.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.spaonline.entity.TipoIdentificacionEntity;


public class TipoIdentificacionAzureSqlDAO extends SqlConnection implements TipoIdentificacionDAO {
	
	public TipoIdentificacionAzureSqlDAO(final Connection conexion) {
		super (conexion);
		
	}

	@Override
	public List<TipoIdentificacionEntity> consultar(TipoIdentificacionEntity data) {
		List<TipoIdentificacionEntity> resultado = new ArrayList<>();
		var parametros = new ArrayList<Object>();
		
		String sentenciaSql = formarSentenciaConsulta(data,parametros);
			
	
				try (final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentenciaSql)) {
					colocarParametrosConsulta(sentenciaPreparada, parametros );					        
				        try (final ResultSet resultadoConsulta = sentenciaPreparada.executeQuery()) {
		
				            while (resultadoConsulta.next()) {
				            	TipoIdentificacionEntity servicio = new TipoIdentificacionEntity();
				            	servicio.setId( UUIDHelper.convertToUUID(resultadoConsulta.getString("id")) );
				            	servicio.setNombre(resultadoConsulta.getString("nombre"));
				            	
				                
				                resultado.add(servicio);
				            }
				        }				
				}
				 catch (final SQLException excepcion) {
			        var mensajeUsuario = "Se ha presentado un problema intentando consultar el tipo identificacion";
			        var mensajeTecnico =  "Se ha presentado una excepcion de tipo SQLException intentando consultar el tipo de identificacion, por favor validar la trama completa de que sucedio...";
			        throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
			    } 
				catch (final Exception excepcion) {
			        var mensajeUsuario = "Se ha presentado un problema INESPERADO,intentando consultar el tipo identificacion";
			        var mensajeTecnico =  "Se ha presentado una excepcion de tipo Exception intentando consultar el tipo de identificacion, por favor validar la trama completa de que sucedio...";
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
			var mensajeUsuario = "Se ha presentado un problema intentando consultar los tipo de servicios";
			var mensajeTecnico = "Se ha presentado una excepcion de tipo SQLException intentando consultar el tipo de servicio";
			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
		}
		catch(final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema inesperado intentando consultar los tipo de servicios";
			var mensajeTecnico = "se ha presentado una excepcion de tipo Exception intentando consultar un tiposervicio, por favor validar la trama completa";
			throw new DataSpaOnlineException(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}
	private final String formarSentenciaConsulta(TipoIdentificacionEntity data , List<Object> parametros) {
		
		final StringBuilder sentenciaSql = new StringBuilder();
		String operadorCondicional ="WHERE";
		
		sentenciaSql.append("SELECT id , nombre  FROM Tipoidentificacion ");
		if(!ObjectHelper.isNull(data)) {
			
			if(!ObjectHelper.isNull(data.getId())&& !UUIDHelper.isDefault(data.getId())) {
				sentenciaSql.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = " AND";
				parametros.add(data.getId());
			}
			if(!TextHelper.isNullOrEmpty(data.getNombre())) {
				sentenciaSql.append(operadorCondicional).append(" nombre = ? ");				
				parametros.add(data.getNombre());
			}			
			
		}
		sentenciaSql.append("ORDER BY nombre ");
		
		return sentenciaSql.toString();

	}

}
