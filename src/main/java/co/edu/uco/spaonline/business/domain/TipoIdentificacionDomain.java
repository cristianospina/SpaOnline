package co.edu.uco.spaonline.business.domain;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.helpers.TextHelper;
import co.edu.uco.spaonline.crosscutting.helpers.UUIDHelper;

public class TipoIdentificacionDomain {
	private UUID id;
	private String nombre;
	protected TipoIdentificacionDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);		
	}
	
	public static TipoIdentificacionDomain build(final UUID id, final String nombre) {
		return new TipoIdentificacionDomain(id,nombre);
	}
	public static TipoIdentificacionDomain build(final UUID id) {
		return new TipoIdentificacionDomain(id,TextHelper.EMPTY);
	}
	public static TipoIdentificacionDomain build() {
		return new TipoIdentificacionDomain(UUIDHelper.generarUUIDDefecto(), TextHelper.EMPTY);
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
