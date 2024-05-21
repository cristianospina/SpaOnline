package co.edu.uco.spaonline.dto;

import java.math.BigDecimal;
import java.util.UUID;

public final class ServicioDTO {
	
	private UUID id;
	private String nombre;
	private String descipcion;
	private String tiposervicio;
	private BigDecimal tarifa;
	
	private ServicioDTO() {
		super();
	}

	private ServicioDTO(final UUID id,final String nombre,final String descipcion,final String tiposervicio,final BigDecimal tarifa) {
		setId(id);
		setNombre(nombre);
		setDescipcion(descipcion);
		setTiposervicio(tiposervicio);
		setTarifa(tarifa);
	}
	
	public static final ServicioDTO build() {
		return new ServicioDTO();
	}
	
	public final UUID getId() {
		return id;
	}
	
	public final ServicioDTO setId(UUID id) {
		this.id = id;
		return this;
	}
	
	public final String getNombre() {
		return nombre;
	}
	
	public final ServicioDTO setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public final String getDescipcion() {
		return descipcion;
	}
	
	public final ServicioDTO setDescipcion(String descipcion) {
		this.descipcion = descipcion;
		return this;
	}
	
	public final String getTiposervicio() {
		return tiposervicio;
	}
	
	public final ServicioDTO setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
		return this;
	}
	
	public final BigDecimal getTarifa() {
		return tarifa;
	}
	
	public final ServicioDTO setTarifa(BigDecimal tarifa) {
		this.tarifa = tarifa;
		return this;
	}
	
}
