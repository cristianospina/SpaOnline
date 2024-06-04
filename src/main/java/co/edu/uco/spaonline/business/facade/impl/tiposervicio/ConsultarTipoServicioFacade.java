package co.edu.uco.spaonline.business.facade.impl.tiposervicio;

import java.util.List;


import co.edu.uco.spaonline.business.assembler.dto.impl.TipoServicioAssemblerDTO;
import co.edu.uco.spaonline.business.facade.FacadeWithReturn;
import co.edu.uco.spaonline.business.usecase.impl.tiposervicio.ConsultarTipoServicio;
import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.custom.BusinessSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.data.dao.factory.DAOFactory;
import co.edu.uco.spaonline.dto.TipoServicioDTO;

public class ConsultarTipoServicioFacade implements FacadeWithReturn<TipoServicioDTO, List<TipoServicioDTO> > {
	
	private DAOFactory daoFactory;
	
	public ConsultarTipoServicioFacade () {
		daoFactory = DAOFactory.getFactory();
	}
	@Override
	public List<TipoServicioDTO> execute(TipoServicioDTO dto) {
		try {
			var useCase = new ConsultarTipoServicio(daoFactory);
			var tiposervicioDomain = TipoServicioAssemblerDTO.getinstace().toDomain(dto);
			var resultadosDomain =useCase.execute(tiposervicioDomain);

			return TipoServicioAssemblerDTO.getinstace().toDTOCollection(resultadosDomain);
			
			
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
