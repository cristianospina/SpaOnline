package co.edu.uco.spaonline.business.facade.impl.servicio;

import java.util.List;


import co.edu.uco.spaonline.business.assembler.dto.impl.ServicioAssemblerDTO;
import co.edu.uco.spaonline.business.facade.FacadeWithReturn;
import co.edu.uco.spaonline.business.usecase.impl.servicio.ConsultarServicio;
import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.custom.BusinessSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.data.dao.factory.DAOFactory;
import co.edu.uco.spaonline.dto.ServicioDTO;



public class ConsultarServicioFacade implements FacadeWithReturn<ServicioDTO, List<ServicioDTO> >{
	
	private DAOFactory daoFactory;
	
	public ConsultarServicioFacade () {
		daoFactory = DAOFactory.getFactory();
	}
	
	@Override
	public List<ServicioDTO> execute(ServicioDTO dto) {
		try {
			var useCase = new ConsultarServicio(daoFactory);
			var servicioDomain = ServicioAssemblerDTO.getinstace().toDomain(dto);
			var resultadosDomain =useCase.execute(servicioDomain);

			return ServicioAssemblerDTO.getinstace().toDTOCollection(resultadosDomain);
			
			
		}catch(final SpaOnlineException exception) {
			throw exception;
		}catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00043);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00044);
			throw new BusinessSpaOnlineException(mensajeUsuario, mensajeTecnico);
		} finally{
			daoFactory.cerrarConexion();
		}
	}

}
