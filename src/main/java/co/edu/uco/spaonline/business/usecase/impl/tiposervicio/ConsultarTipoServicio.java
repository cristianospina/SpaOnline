package co.edu.uco.spaonline.business.usecase.impl.tiposervicio;

import java.util.List;
import java.util.UUID;

import co.edu.uco.spaonline.business.assembler.entity.impl.TipoServicioAssemblerEntity;
import co.edu.uco.spaonline.business.domain.TipoServicioDomain;
import co.edu.uco.spaonline.business.usecase.UseCaseWithReturn;
import co.edu.uco.spaonline.crosscutting.exceptions.custom.BusinessSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;
import co.edu.uco.spaonline.crosscutting.helpers.TextHelper;
import co.edu.uco.spaonline.data.dao.factory.DAOFactory;
import co.edu.uco.spaonline.entity.TipoServicioEntity;

public class ConsultarTipoServicio implements UseCaseWithReturn<TipoServicioDomain, List<TipoServicioDomain>> {
	
private DAOFactory factory;
	
	public ConsultarTipoServicio (final DAOFactory factory){
		 if(ObjectHelper.isNull(factory)) {
			 var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00051);
			 var mensajeTecnico= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00052);
			 throw new BusinessSpaOnlineException(mensajeUsuario, mensajeTecnico);
		 }
		 this.factory = factory;
	}
	@Override
	public List<TipoServicioDomain> execute(TipoServicioDomain data) {
		validarIntegridadDato(data);
		validarTipoServicioMismoNombre(data.getId(), data.getNombre());
		var tipoServicioEntityfilter= TipoServicioAssemblerEntity.getinstace().toEntity(data);
		var resultadosEntity = factory.getTipoServicioDAO().consultar(tipoServicioEntityfilter);
		
		return TipoServicioAssemblerEntity.getinstace().toDomainCollection(resultadosEntity);
	}
	private final void validarTipoServicioMismoNombre (final UUID id,  final String Tiposervicio){
		var tipoServicioEntity = TipoServicioEntity.build(id ,Tiposervicio);
		var resultados = factory.getTipoServicioDAO().consultar(tipoServicioEntity);
		if(resultados.isEmpty()) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00053);
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}
	
	public void validarIntegridadDato(TipoServicioDomain dato) {
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
