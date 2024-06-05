package co.edu.uco.spaonline.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.spaonline.business.facade.impl.tipoidentificacion.ConsultarTipoIdentificacionFacade;
import co.edu.uco.spaonline.business.facade.impl.tiposervicio.ConsultarTipoServicioFacade;
import co.edu.uco.spaonline.controller.response.TipoIdentificacionResponse;
import co.edu.uco.spaonline.controller.response.TipoServicioResponse;
import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.dto.TipoIdentificacionDTO;


@RestController
@RequestMapping("/api/v1/tipoidentificaciones")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TipoIdentificacionController {
	
	@GetMapping ("/dummy")
	public TipoIdentificacionDTO dummy() {
		return TipoIdentificacionDTO.build();
	}
	
	@GetMapping
	public ResponseEntity<TipoIdentificacionResponse> consultar(){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var tipoIdentificacionResponse = new TipoIdentificacionResponse();
		try {
			var tipoIdentificacionDto = TipoIdentificacionDTO.build();
			var facade = new ConsultarTipoIdentificacionFacade();
			
			tipoIdentificacionResponse.setDatos(facade.execute(tipoIdentificacionDto));
			tipoIdentificacionResponse.getMensajes().add("Tipo de identificacion consultado exitosamente");
		}
		catch(final SpaOnlineException exception){
			httpStatusCode = HttpStatus.BAD_REQUEST;
			tipoIdentificacionResponse.getMensajes().add(exception.getMessage());
			exception.printStackTrace();
		}catch(final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00039);
			tipoIdentificacionResponse.getMensajes().add(mensajeUsuario);
					exception.printStackTrace();
		}
		return new ResponseEntity<>(tipoIdentificacionResponse, httpStatusCode);
	}

}
