package co.edu.uco.spaonline.business.usecase.impl.servicio;


import java.util.UUID;


import co.edu.uco.spaonline.business.domain.ServicioDomain;
import co.edu.uco.spaonline.business.usecase.UseCaseWithoutReturn;
import co.edu.uco.spaonline.crosscutting.exceptions.custom.BusinessSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;
import co.edu.uco.spaonline.crosscutting.helpers.UUIDHelper;
import co.edu.uco.spaonline.data.dao.factory.DAOFactory;
import co.edu.uco.spaonline.entity.ServicioEntity;

public class EliminarServicio implements UseCaseWithoutReturn<ServicioDomain>{
	
	private DAOFactory factory;
	
	public EliminarServicio (final DAOFactory factory){
		 if(ObjectHelper.isNull(factory)) {
			 var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00052);
			 var mensajeTecnico= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00053);
			 throw new BusinessSpaOnlineException(mensajeUsuario, mensajeTecnico);
		 }
		 this.factory = factory;
	}
	@Override
	public void execute(ServicioDomain Data) {
		validarIntegridadDato(Data);
		validarServicioExista(Data);
		var ciudadEntity = ServicioEntity.build().setId(Data.getId());
		factory.getServicioDAO().eliminar(ciudadEntity.getId());
		
	}
	
	public void validarIntegridadDato(ServicioDomain dato) {

		if(!UUIDHelper.isNull(dato.getId())) {
			String uuidString = dato.getId().toString();
			validarUUID(uuidString);
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
	private final void validarServicioExista (final ServicioDomain data){
		var servicioEntity = ServicioEntity.build().setId(data.getId());
		var resultados = factory.getServicioDAO().consultar(servicioEntity);
		
		 boolean encontrado = false;
	        for (ServicioEntity datoServicio : resultados) {
	            if (datoServicio.getId().equals(data.getId())) {
	                encontrado = true;
	                break;
	            }
	        }
		if(!encontrado) {
			var mensajeUsuario = "El servicio que desea eliminar no se ha encontrado, por favor validar de nuevo";
			throw new BusinessSpaOnlineException(mensajeUsuario);
		}
	}
}
