package co.edu.uco.spaonline.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.business.assembler.entity.AssemblerEntity;
import co.edu.uco.spaonline.business.domain.TipoServicioDomain;
import co.edu.uco.spaonline.entity.TipoServicioEntity;

public class TipoServicioAssemblerEntity implements AssemblerEntity< TipoServicioDomain, TipoServicioEntity> {


	public static final AssemblerEntity< TipoServicioDomain, TipoServicioEntity> instance = new TipoServicioAssemblerEntity();
	
	public TipoServicioAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity<TipoServicioDomain, TipoServicioEntity>  getinstace(){
		return instance;
	}
	@Override
	public TipoServicioDomain toDomain(TipoServicioEntity data) {
		return TipoServicioDomain.build(data.getId(),data.getNombre());
	}

	@Override
	public List<TipoServicioDomain> toDomainCollection(List<TipoServicioEntity> entityCollection) {
		List<TipoServicioDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entityCollection.size(); i++) {
			resultados.add(TipoServicioAssemblerEntity.getinstace().toDomain(entityCollection.get(i)));
		}		
		return resultados;
	}

	@Override
	public TipoServicioEntity toEntity(TipoServicioDomain domain) {
		return TipoServicioEntity.build(domain.getId(), domain.getNombre());
	}

}
