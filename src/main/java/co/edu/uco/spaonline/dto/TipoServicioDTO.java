package co.edu.uco.spaonline.dto;

import java.util.UUID;

public class TipoServicioDTO {
	
	private UUID id;
	private String nombre;
	
	private TipoServicioDTO() {
		super();
	}
	
	private TipoServicioDTO(final UUID id,final String nombre) {
		setId(id);
		setNombre(nombre);

	}
	public static final TipoServicioDTO build() {
		return new TipoServicioDTO();
	}
	public static final TipoServicioDTO build(final UUID id,final String nombre) {
		return new TipoServicioDTO(id , nombre);
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

	public final void setId(UUID id) {
		this.id = id;
	}

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
