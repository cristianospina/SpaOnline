package co.edu.uco.spaonline.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.business.assembler.entity.AssemblerEntity;
import co.edu.uco.spaonline.business.domain.TipoIdentificacionDomain;
import co.edu.uco.spaonline.entity.TipoIdentificacionEntity;



public class TipoIdentificacionAssemblerEntity implements AssemblerEntity< TipoIdentificacionDomain, TipoIdentificacionEntity> {


	public static final AssemblerEntity< TipoIdentificacionDomain, TipoIdentificacionEntity> instance = new TipoIdentificacionAssemblerEntity();
	
	public TipoIdentificacionAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity<TipoIdentificacionDomain, TipoIdentificacionEntity>  getinstace(){
		return instance;
	}
	@Override
	public TipoIdentificacionDomain toDomain(TipoIdentificacionEntity data) {
		return TipoIdentificacionDomain.build(data.getId(),data.getNombre());
	}

	@Override
	public List<TipoIdentificacionDomain> toDomainCollection(List<TipoIdentificacionEntity> entityCollection) {
		List<TipoIdentificacionDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entityCollection.size(); i++) {
			resultados.add(TipoIdentificacionAssemblerEntity.getinstace().toDomain(entityCollection.get(i)));
		}		
		return resultados;
	}

	@Override
	public TipoIdentificacionEntity toEntity(TipoIdentificacionDomain domain) {
		return TipoIdentificacionEntity.build(domain.getId(), domain.getNombre());
	}


}
