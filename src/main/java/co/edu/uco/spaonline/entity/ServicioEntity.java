package co.edu.uco.spaonline.entity;


import java.util.UUID;

public final class ServicioEntity {
	
	private UUID id;
	private String nombre;
	private String descipcion;
	private String tiposervicio;
	private Long tarifa;
	
	public ServicioEntity() {
		super();
	}

	public ServicioEntity(final UUID id,final String nombre,final String descipcion,final String tiposervicio,final Long tarifa) {
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
	
	public final Long getTarifa() {
		return tarifa;
	}
	
	public final ServicioEntity setTarifa(Long tarifa) {
		this.tarifa = tarifa;
		return this;
	}
	
}
