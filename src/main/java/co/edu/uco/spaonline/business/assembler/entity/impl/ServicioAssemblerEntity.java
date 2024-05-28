package co.edu.uco.spaonline.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;


import co.edu.uco.spaonline.business.assembler.entity.AssemblerEntity;
import co.edu.uco.spaonline.business.domain.ServicioDomain;
import co.edu.uco.spaonline.entity.ServicioEntity;

public class ServicioAssemblerEntity implements AssemblerEntity< ServicioDomain, ServicioEntity>{
	
	
private static final AssemblerEntity< ServicioDomain, ServicioEntity> instance = new ServicioAssemblerEntity();
	
	private ServicioAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity<ServicioDomain, ServicioEntity>  getinstace(){
		return instance;
	}
	
	@Override
	public ServicioDomain toDomain(ServicioEntity data) {
		return ServicioDomain.build(data.getId(), data.getNombre(), data.getDescipcion() , data.getTiposervicio() , data.getTarifa());
	}

	@Override
	public List<ServicioDomain> toDomainCollection(List<ServicioEntity> entityCollection) {
		List<ServicioDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entityCollection.size(); i++) {
			resultados.add(ServicioAssemblerEntity.getinstace().toDomain(entityCollection.get(i)));
		}		
		return resultados;
	}

	@Override
	public ServicioEntity toEntity(ServicioDomain domain) {
		return ServicioEntity.build().setId(domain.getId()).setNombre(domain.getNombre()).setDescipcion(domain.getDescipcion()).setTiposervicio(domain.getTiposervicio()).setTarifa(domain.getTarifa());
	}

	

}
