package co.edu.uco.spaonline.entity;


import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.helpers.NumHelper;
import co.edu.uco.spaonline.crosscutting.helpers.TextHelper;
import co.edu.uco.spaonline.crosscutting.helpers.UUIDHelper;

public final class ServicioEntity {
	
	private UUID id;
	private String nombre;
	private String descipcion;
	private TipoServicioEntity tiposervicio;
	private Long tarifa;
	
	public ServicioEntity() {
		setId(UUIDHelper.generarUUIDDefecto());
		setNombre(TextHelper.EMPTY);
		setDescipcion(TextHelper.EMPTY);
		setTiposervicio(TipoServicioEntity.build());
		setTarifa(NumHelper.NUM_DEFECT);
	}

	public ServicioEntity(final UUID id,final String nombre,final String descipcion,final TipoServicioEntity tiposervicio,final Long tarifa) {
		setId(id);
		setNombre(nombre);
		setDescipcion(descipcion);
		setTiposervicio(tiposervicio);
		setTarifa(tarifa);
	}
	
	public static final ServicioEntity build() {
		return new ServicioEntity();
	}
	public static final ServicioEntity build(final UUID id,final String nombre,final String descipcion,final TipoServicioEntity tiposervicio,final Long tarifa) {
		return new ServicioEntity(id,nombre,descipcion,tiposervicio,tarifa);
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
	
	public final TipoServicioEntity getTiposervicio() {
		return tiposervicio;
	}
	
	public final ServicioEntity setTiposervicio(final TipoServicioEntity tiposervicio) {
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
