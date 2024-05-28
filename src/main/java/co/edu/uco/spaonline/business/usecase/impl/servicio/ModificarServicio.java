package co.edu.uco.spaonline.business.usecase.impl.servicio;

import java.util.UUID;


import co.edu.uco.spaonline.business.domain.ServicioDomain;
import co.edu.uco.spaonline.business.usecase.UseCaseWithoutReturn;
import co.edu.uco.spaonline.crosscutting.exceptions.custom.BusinessSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;
import co.edu.uco.spaonline.crosscutting.helpers.TextHelper;
import co.edu.uco.spaonline.crosscutting.helpers.UUIDHelper;
import co.edu.uco.spaonline.data.dao.factory.DAOFactory;
import co.edu.uco.spaonline.entity.ServicioEntity;

public class ModificarServicio implements UseCaseWithoutReturn<ServicioDomain>{

	private DAOFactory factory;
	
	public ModificarServicio (final DAOFactory factory){
		 if(ObjectHelper.isNull(factory)) {
			 var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00051);
			 var mensajeTecnico= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00054);
			 throw new BusinessSpaOnlineException(mensajeUsuario, mensajeTecnico);
		 }
		 this.factory = factory;
	}
	@Override
	public void execute(ServicioDomain Data) {
		validarIntegridadDato(Data);
		validarCiudadMismoNombreMismoTipoServicio(Data.getNombre(), Data.getTiposervicio());
		var servicioEntity = ServicioEntity.build().setId(Data.getId()).setNombre(Data.getNombre()).setDescipcion(Data.getDescipcion()).setTiposervicio(Data.getTiposervicio()).setTarifa(Data.getTarifa());
		factory.getServicioDAO().modificar(servicioEntity);
		
	}
	private final void validarCiudadMismoNombreMismoTipoServicio (final String nombreServicio, final String TipoServicio){
		var servicioEntity = ServicioEntity.build().setNombre(nombreServicio).setTiposervicio(TipoServicio);
		var resultados = factory.getServicioDAO().consultar(servicioEntity);
		if(!resultados.isEmpty()) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00055);
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}
	
	public void validarIntegridadDato(ServicioDomain dato) {
		if(!ObjectHelper.esNulooVacio(dato)) {
			validarLongitud(dato.getNombre());
			validarObligatoriedad(dato.getNombre());
			validarFormato(dato.getNombre());
		}
		if(!UUIDHelper.isNull(dato.getId())) {
			String uuidString = dato.getId().toString();
			validarUUID(uuidString);
		}
		
				
	}
	
	private final void validarLongitud(final String dato) {
		if(!TextHelper.longitudMaximaValida(dato,50)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00056);
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}
	private final void validarObligatoriedad(final String dato) {
		if(TextHelper.isNull(dato)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00057);
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}
	private final void validarFormato(final String dato) {
		if(!TextHelper.contieneSoloLetras(dato)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00058);
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}
	public static boolean validarUUID(String s) {
        try {
            UUID.fromString(s);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
