package co.edu.uco.spaonline.entity;

import java.util.UUID;

public class TipoServicioEntity {

	private UUID id;
	private String nombre;
	
	public TipoServicioEntity() {
		super();
	}
	
	public TipoServicioEntity(final UUID id,final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final TipoServicioEntity build() {
		return new TipoServicioEntity();
	}
	public static final TipoServicioEntity build(final UUID id,final String nombre) {
		return new TipoServicioEntity(id, nombre);
	}
	public final UUID getId() {
		return id;
	}
	public final void setId(UUID id) {
		this.id = id;
	}
	public final String getNombre() {
		return nombre;
	}
	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
