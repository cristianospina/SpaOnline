package co.edu.uco.spaonline.entity;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.helpers.TextHelper;
import co.edu.uco.spaonline.crosscutting.helpers.UUIDHelper;



public class TipoIdentificacionEntity {
	private UUID id;
	private String nombre;
	
	public TipoIdentificacionEntity() {
		setId(UUIDHelper.generarUUIDDefecto());
		setNombre(TextHelper.EMPTY);
	}
	
	public TipoIdentificacionEntity(final UUID id,final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final TipoIdentificacionEntity build() {
		return new TipoIdentificacionEntity();
	}
	public static final TipoIdentificacionEntity build(final UUID id,final String nombre) {
		return new TipoIdentificacionEntity(id, nombre);
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
