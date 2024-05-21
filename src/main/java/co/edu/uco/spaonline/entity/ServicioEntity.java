package co.edu.uco.spaonline.entity;

import java.math.BigDecimal;
import java.util.UUID;

public final class ServicioEntity {
	
	private UUID id;
	private String nombre;
	private String descipcion;
	private String tiposervicio;
	private BigDecimal tarifa;
	
	private ServicioEntity() {
		super();
	}

	private ServicioEntity(final UUID id,final String nombre,final String descipcion,final String tiposervicio,final BigDecimal tarifa) {
		setId(id);
		setNombre(nombre);
		setDescipcion(descipcion);
		setTiposervicio(tiposervicio);
		setTarifa(tarifa);
	}
	
	public static final ServicioEntity build() {
		return new ServicioEntity();
	}
	
	public final UUID getId() {
		return id;
	}
	
	public final ServicioEntity setId(UUID id) {
		this.id = id;
		return this;
	}
	
	public final String getNombre() {
		return nombre;
	}
	
	public final ServicioEntity setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public final String getDescipcion() {
		return descipcion;
	}
	
	public final ServicioEntity setDescipcion(String descipcion) {
		this.descipcion = descipcion;
		return this;
	}
	
	public final String getTiposervicio() {
		return tiposervicio;
	}
	
	public final ServicioEntity setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
		return this;
	}
	
	public final BigDecimal getTarifa() {
		return tarifa;
	}
	
	public final ServicioEntity setTarifa(BigDecimal tarifa) {
		this.tarifa = tarifa;
		return this;
	}
	
}
