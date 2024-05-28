package co.edu.uco.spaonline.business.facade.impl.servicio;


import co.edu.uco.spaonline.business.assembler.dto.impl.ServicioAssemblerDTO;
import co.edu.uco.spaonline.business.domain.ServicioDomain;
import co.edu.uco.spaonline.business.facade.FacadeWithoutReturn;
import co.edu.uco.spaonline.business.usecase.UseCaseWithoutReturn;
import co.edu.uco.spaonline.business.usecase.impl.servicio.RegistrarServicio;
import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.custom.BusinessSpaOnlineException;
import co.edu.uco.spaonline.data.dao.factory.DAOFactory;
import co.edu.uco.spaonline.dto.ServicioDTO;

public class RegistrarServicioFacade implements FacadeWithoutReturn<ServicioDTO>{
	
	private DAOFactory daoFactory;
	
	public RegistrarServicioFacade () {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public void execute(ServicioDTO dto) {
		daoFactory.iniciarTransaccion();
		try {
			UseCaseWithoutReturn<ServicioDomain> useCase = new RegistrarServicio(daoFactory);
			var servicioDomain = ServicioAssemblerDTO.getinstace().toDomain(dto);
			useCase.execute(servicioDomain);
			
			daoFactory.confirmarTransaccion();
		}catch(final SpaOnlineException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		}catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario= "Se ha presentado un problema tratando de ingresar la informacion de la ciudad";
			var mensajeTecnico = "Se ha presentado un problema  INESPERADO tratando de ingresar la informacion de la ciudad";
			throw new BusinessSpaOnlineException(mensajeUsuario, mensajeTecnico);
		} finally{
			daoFactory.cerrarConexion();
		}
	}

}
