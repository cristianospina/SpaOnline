package co.edu.uco.spaonline.dto;

import java.util.UUID;

public class TipoIdentificacionDTO {
	
	private UUID id;
	private String nombre;
	
	private TipoIdentificacionDTO() {
		super();
	}
	
	private TipoIdentificacionDTO(final UUID id,final String nombre) {
		setId(id);
		setNombre(nombre);

	}
	public static final TipoIdentificacionDTO build() {
		return new TipoIdentificacionDTO();
	}
	public static final TipoIdentificacionDTO build(final UUID id,final String nombre) {
		return new TipoIdentificacionDTO(id , nombre);
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
