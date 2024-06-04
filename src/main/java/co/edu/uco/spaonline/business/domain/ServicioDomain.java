package co.edu.uco.spaonline.business.domain;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.helpers.NumHelper;
import co.edu.uco.spaonline.crosscutting.helpers.TextHelper;
import co.edu.uco.spaonline.crosscutting.helpers.UUIDHelper;



public class ServicioDomain {
	
	private UUID id;
	private String nombre;
	private String descipcion;
	private TipoServicioDomain tiposervicio;
	private Long tarifa;
	
	
	protected ServicioDomain(final UUID id, final String nombre, final String descripcion, final TipoServicioDomain tiposervicio, final Long tarifa) {
		setId(id);
		setNombre(nombre);
		setDescipcion(descripcion);
		setTiposervicio(tiposervicio);
		setTarifa(tarifa);
		
	}
	
	public static ServicioDomain build(final UUID id, final String nombre, final String descripcion, final TipoServicioDomain tiposervicio, final Long tarifa) {
		return new ServicioDomain(id,nombre, descripcion , tiposervicio, tarifa);
	}
	public static ServicioDomain build(final UUID id) {
		return new ServicioDomain(id,TextHelper.EMPTY, TextHelper.EMPTY, TipoServicioDomain.build(), NumHelper.NUM_DEFECT);
	}
	public static ServicioDomain build() {
		return new ServicioDomain(UUIDHelper.generarUUIDDefecto(), TextHelper.EMPTY, TextHelper.EMPTY, TipoServicioDomain.build(), NumHelper.NUM_DEFECT);
	}

	private final void setId(final UUID id) {
		this.id = UUIDHelper.obtenerValorDefecto(id);
	}

	private final void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}


	private final void setDescipcion(final String descipcion) {
		this.descipcion = TextHelper.applyTrim(descipcion);
	}

	private final void setTiposervicio(final TipoServicioDomain tiposervicio) {
		this.tiposervicio =tiposervicio ;
	}

	private final void setTarifa(final Long tarifa) {
		this.tarifa = NumHelper.getDefaultValue(tarifa);
	}


	public  UUID getId() {
		return id;
	}


	public  String getNombre() {
		return nombre;
	}


	public  String getDescipcion() {
		return descipcion;
	}


	public  TipoServicioDomain getTiposervicio() {
		return tiposervicio;
	}


	public  Long getTarifa() {
		return tarifa;
	}
	
	
}
