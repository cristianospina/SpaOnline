package co.edu.uco.spaonline.business.facade.impl.tipoidentificacion;

import java.util.List;

import co.edu.uco.spaonline.business.assembler.dto.impl.TipoIdentificacionAssemblerDTO;
import co.edu.uco.spaonline.business.facade.FacadeWithReturn;
import co.edu.uco.spaonline.business.usecase.impl.tipoidentificacion.ConsultarTipoIdentificacion;
import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.custom.BusinessSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.data.dao.factory.DAOFactory;
import co.edu.uco.spaonline.dto.TipoIdentificacionDTO;

public class ConsultarTipoIdentificacionFacade implements FacadeWithReturn<TipoIdentificacionDTO, List<TipoIdentificacionDTO> > {
	
	private DAOFactory daoFactory;
	
	public ConsultarTipoIdentificacionFacade () {
		daoFactory = DAOFactory.getFactory();
	}
	@Override
	public List<TipoIdentificacionDTO> execute(TipoIdentificacionDTO dto) {
		try {
			var useCase = new  ConsultarTipoIdentificacion(daoFactory);
			var tipoServicioDomain = TipoIdentificacionAssemblerDTO.getinstace().toDomain(dto);
			var resultadosDomain =useCase.execute(tipoServicioDomain);

			return TipoIdentificacionAssemblerDTO.getinstace().toDTOCollection(resultadosDomain);
			
			
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
