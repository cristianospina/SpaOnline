package co.edu.uco.spaonline.business.usecase.impl.servicio;

import java.util.List;

import co.edu.uco.spaonline.business.assembler.entity.impl.ServicioAssemblerEntity;
import co.edu.uco.spaonline.business.domain.ServicioDomain;
import co.edu.uco.spaonline.business.usecase.UseCaseWithReturn;
import co.edu.uco.spaonline.crosscutting.exceptions.custom.BusinessSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;
import co.edu.uco.spaonline.crosscutting.helpers.TextHelper;
import co.edu.uco.spaonline.data.dao.factory.DAOFactory;
import co.edu.uco.spaonline.entity.ServicioEntity;

public class ConsultarServicio implements UseCaseWithReturn<ServicioDomain, List<ServicioDomain>>{

	private DAOFactory factory;
	
	public ConsultarServicio (final DAOFactory factory){
		 if(ObjectHelper.isNull(factory)) {
			 var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00047);
			 var mensajeTecnico= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00048);
			 throw new BusinessSpaOnlineException(mensajeUsuario, mensajeTecnico);
		 }
		 this.factory = factory;
	}
	@Override
	public List<ServicioDomain> execute(ServicioDomain data) {
		validarIntegridadDato(data);
		validarCiudadMismoNombreMismoTipoServicio(data.getNombre(), data.getTiposervicio());
		var servicioEntityfilter= ServicioAssemblerEntity.getinstace().toEntity(data);
		var resultadosEntity = factory.getServicioDAO().consultar(servicioEntityfilter);
		return ServicioAssemblerEntity.getinstace().toDomainCollection(resultadosEntity);
	}
	
	private final void validarCiudadMismoNombreMismoTipoServicio (final String nombreCiudad, final String tipoServicio){
		var servicioEntity = ServicioEntity.build().setNombre(nombreCiudad).setTiposervicio(tipoServicio);
		var resultados = factory.getServicioDAO().consultar(servicioEntity);
		if(resultados.isEmpty()) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00049);
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}
	
	public void validarIntegridadDato(ServicioDomain dato) {
		if(!ObjectHelper.esNulooVacio(dato)) {
			validarLongitud(dato.getNombre());
		}		
	}
	
	private final void validarLongitud(final String dato) {
		if(!TextHelper.longitudMaximaValida(dato,50)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00050);
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}

}
