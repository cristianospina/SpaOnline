package co.edu.uco.spaonline.controller;

import java.util.UUID;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.uco.spaonline.business.facade.impl.servicio.ConsultarServicioFacade;
import co.edu.uco.spaonline.business.facade.impl.servicio.EliminarServicioFacade;
import co.edu.uco.spaonline.business.facade.impl.servicio.ModificarServicioFacade;
import co.edu.uco.spaonline.business.facade.impl.servicio.RegistrarServicioFacade;
import co.edu.uco.spaonline.controller.response.ServicioResponse;
import co.edu.uco.spaonline.crosscutting.exceptions.SpaOnlineException;
import co.edu.uco.spaonline.dto.ServicioDTO;

@RestController
@RequestMapping("/api/v1/servicios")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public final class ServicioController {
	
	@GetMapping ("/dummy")
	public ServicioDTO dummy() {
		return ServicioDTO.build();
	}
	
	@GetMapping
	public ResponseEntity<ServicioResponse> consultar(){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var servicioResponse = new ServicioResponse();
		try {
			var servicioDto = ServicioDTO.build();
			var facade = new ConsultarServicioFacade();
			
			servicioResponse.setDatos(facade.execute(servicioDto));
			servicioResponse.getMensajes().add("Servicio consultado exitosamente");
		}
		catch(final SpaOnlineException exception){
			httpStatusCode = HttpStatus.BAD_REQUEST;
			servicioResponse.getMensajes().add(exception.getMessage());
			exception.printStackTrace();
		}catch(final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario= "Se ha presentado un problema intentando consultar un servicio";
			servicioResponse.getMensajes().add(mensajeUsuario);
					exception.printStackTrace();
		}
		return new ResponseEntity<>(servicioResponse, httpStatusCode);
	}
	@PostMapping
	public ResponseEntity<ServicioResponse> crear(@RequestBody ServicioDTO servicio){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var servicioResponse = new ServicioResponse();
		
		try {
			
			var facade = new RegistrarServicioFacade();
			facade.execute(servicio);
			servicioResponse.getMensajes().add("Servicio creado exitosamente");
		}
		catch(final SpaOnlineException exception){
			httpStatusCode = HttpStatus.BAD_REQUEST;
			servicioResponse.getMensajes().add(exception.getMessage());
			exception.printStackTrace();
		}catch(final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario= "Se ha presentado un problema intentando registrar un Servicio";
			servicioResponse.getMensajes().add(mensajeUsuario);
					exception.printStackTrace();
		}
		return new ResponseEntity<>(servicioResponse, httpStatusCode);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ServicioResponse> eliminar(@PathVariable UUID id){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new ServicioResponse();
		try {
			
			var facade = new EliminarServicioFacade();
			var dto = ServicioDTO.build().setId(id);
			facade.execute(dto);
			ciudadResponse.getMensajes().add("Servicio Eliminada exitosamente");
		}
		catch(final SpaOnlineException exception){
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(exception.getMessage());
			exception.printStackTrace();
		}catch(final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario= "Se ha presentado un problema intentando Eliminar un servicio";
					ciudadResponse.getMensajes().add(mensajeUsuario);
					exception.printStackTrace();
		}
		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
	}
	@PutMapping ("/{id}")
	public ResponseEntity<ServicioResponse> modificar(@PathVariable UUID id, @RequestBody ServicioDTO servicio){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new ServicioResponse();
		
		try {
			servicio.setId(id);
			var facade = new ModificarServicioFacade();
			facade.execute(servicio);
			ciudadResponse.getMensajes().add("Servicio modificado exitosamente");
		}
		catch(final SpaOnlineException exception){
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(exception.getMessage());
			exception.printStackTrace();
		}catch(final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario= "Se ha presentado un problema intentando modificar un servicio";
					ciudadResponse.getMensajes().add(mensajeUsuario);
					exception.printStackTrace();
		}
		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
	}
}
