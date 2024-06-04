package co.edu.uco.spaonline.business.usecase.impl.servicio;

import java.util.Random;
import java.util.UUID;

import co.edu.uco.spaonline.business.assembler.entity.impl.TipoServicioAssemblerEntity;
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
import co.edu.uco.spaonline.entity.TipoServicioEntity;
import jakarta.websocket.Decoder.Text;

public class RegistrarServicio implements UseCaseWithoutReturn<ServicioDomain>{
	
	private DAOFactory factory;
	
	
	public RegistrarServicio (final DAOFactory factory){
		 if(ObjectHelper.isNull(factory)) {
			 var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00061);
			 var mensajeTecnico= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00062);
			 throw new BusinessSpaOnlineException(mensajeUsuario, mensajeTecnico);
		 }
		 this.factory = factory;
	}


	@Override
	public void execute(ServicioDomain data) {
		validarIntegridadDato(data);
		validarServicioMismoNombreMismoTipoServicio(data.getNombre(), data.getTiposervicio().getId());
		validarexistencia(data);
		var servicioEntity = ServicioEntity.build().setId(generarUUIDAleatorio()).setNombre(data.getNombre()).setDescipcion(data.getDescipcion()).setTiposervicio(TipoServicioAssemblerEntity.getinstace().toEntity(data.getTiposervicio())).setTarifa(data.getTarifa());

		factory.getServicioDAO().crear(servicioEntity);
		
	}
	
	public static UUID generarUUIDAleatorio() {
		Random random = new Random();
        long mas = random.nextLong();
        long menos = random.nextLong();
        return new UUID(mas, menos);
    }
	
	private final void validarServicioMismoNombreMismoTipoServicio (final String nombreservicio, final UUID tiposervicio){
		var ciudadEntity = ServicioEntity.build().setNombre(nombreservicio).setTiposervicio(TipoServicioEntity.build(tiposervicio, TextHelper.EMPTY));
		var resultados = factory.getServicioDAO().consultar(ciudadEntity);
		if(!resultados.isEmpty()) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00053);
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}
	
	public void validarIntegridadDato(ServicioDomain dato) {
		if(!ObjectHelper.esNulooVacio(dato)) {
			validarLongitud(dato.getNombre(), 50);
			validarLongitud(dato.getDescipcion(), 400);
			validarObligatoriedad(dato.getNombre());
		}
		if(!UUIDHelper.isNull(dato.getId())) {
			String uuidString = dato.getId().toString();
			validarUUID(uuidString);
		}
				
	}
	
	private final void validarLongitud(final String dato , int rango) {
		if(!TextHelper.longitudMaximaValida(dato,rango)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00054);
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}
	private final void validarObligatoriedad(final String dato) {
		if(TextHelper.isNull(dato)) {
			var mensajeUsuario = TextHelper.reemplazarParametro(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00059), dato);
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
	public static void validarexistencia(ServicioDomain data) {
		if (ObjectHelper.esNulooVacio(data)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00082);
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}

}
