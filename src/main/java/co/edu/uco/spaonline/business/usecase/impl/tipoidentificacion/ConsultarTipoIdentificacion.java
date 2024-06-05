package co.edu.uco.spaonline.business.usecase.impl.tipoidentificacion;

import java.util.List;
import java.util.UUID;

import co.edu.uco.spaonline.business.assembler.entity.impl.TipoIdentificacionAssemblerEntity;
import co.edu.uco.spaonline.business.domain.TipoIdentificacionDomain;
import co.edu.uco.spaonline.business.usecase.UseCaseWithReturn;
import co.edu.uco.spaonline.crosscutting.exceptions.custom.BusinessSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;
import co.edu.uco.spaonline.crosscutting.helpers.TextHelper;
import co.edu.uco.spaonline.data.dao.factory.DAOFactory;
import co.edu.uco.spaonline.entity.TipoIdentificacionEntity;

public class ConsultarTipoIdentificacion implements UseCaseWithReturn<TipoIdentificacionDomain, List<TipoIdentificacionDomain>> {
	
private DAOFactory factory;
	
	public ConsultarTipoIdentificacion (final DAOFactory factory){
		 if(ObjectHelper.isNull(factory)) {
			 var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00051);
			 var mensajeTecnico= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00052);
			 throw new BusinessSpaOnlineException(mensajeUsuario, mensajeTecnico);
		 }
		 this.factory = factory;
	}
	@Override
	public List<TipoIdentificacionDomain> execute(TipoIdentificacionDomain data) {
		validarIntegridadDato(data);
		validarTipoServicioMismoNombre(data.getId(), data.getNombre());
		var tipoIdentificacionEntityfilter= TipoIdentificacionAssemblerEntity.getinstace().toEntity(data);
		var resultadosEntity = factory.getTipoIdentificacionDAO().consultar(tipoIdentificacionEntityfilter);
		
		return TipoIdentificacionAssemblerEntity.getinstace().toDomainCollection(resultadosEntity);
	}
	private final void validarTipoServicioMismoNombre (final UUID id,  final String Tiposervicio){
		var tipoServicioEntity = TipoIdentificacionEntity.build(id ,Tiposervicio);
		var resultados = factory.getTipoIdentificacionDAO().consultar(tipoServicioEntity);
		if(resultados.isEmpty()) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00053);
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}
	
	public void validarIntegridadDato(TipoIdentificacionDomain dato) {
		if(!ObjectHelper.esNulooVacio(dato)) {
			validarLongitud(dato.getNombre());
		}		
	}
	
	private final void validarLongitud(final String dato) {
		if(!TextHelper.longitudMaximaValida(dato,50)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00054);
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}


}
