package co.edu.uco.spaonline.business.domain;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.helpers.TextHelper;
import co.edu.uco.spaonline.crosscutting.helpers.UUIDHelper;

public class TipoServicioDomain {

	private UUID id;
	private String nombre;
	protected TipoServicioDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);		
	}
	
	public static TipoServicioDomain build(final UUID id, final String nombre) {
		return new TipoServicioDomain(id,nombre);
	}
	public static TipoServicioDomain build(final UUID id) {
		return new TipoServicioDomain(id,TextHelper.EMPTY);
	}
	public static TipoServicioDomain build() {
		return new TipoServicioDomain(UUIDHelper.generarUUIDDefecto(), TextHelper.EMPTY);
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
