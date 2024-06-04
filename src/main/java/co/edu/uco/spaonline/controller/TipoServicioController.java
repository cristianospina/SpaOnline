package co.edu.uco.spaonline.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.uco.spaonline.business.facade.impl.tiposervicio.ConsultarTipoServicioFacade;
import co.edu.uco.spaonline.controller.response.TipoServicioResponse;
import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.dto.TipoServicioDTO;

@RestController
@RequestMapping("/api/v1/tiposervicios")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TipoServicioController {
	
	@GetMapping ("/dummy")
	public TipoServicioDTO dummy() {
		return TipoServicioDTO.build();
	}
	
	@GetMapping
	public ResponseEntity<TipoServicioResponse> consultar(){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var tiposervicioResponse = new TipoServicioResponse();
		try {
			var tipoServicioDto = TipoServicioDTO.build();
			var facade = new ConsultarTipoServicioFacade();
			
			tiposervicioResponse.setDatos(facade.execute(tipoServicioDto));
			tiposervicioResponse.getMensajes().add("Tipo de servicio consultado exitosamente");
		}
		catch(final SpaOnlineException exception){
			httpStatusCode = HttpStatus.BAD_REQUEST;
			tiposervicioResponse.getMensajes().add(exception.getMessage());
			exception.printStackTrace();
		}catch(final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00039);
			tiposervicioResponse.getMensajes().add(mensajeUsuario);
					exception.printStackTrace();
		}
		return new ResponseEntity<>(tiposervicioResponse, httpStatusCode);
	}
}
