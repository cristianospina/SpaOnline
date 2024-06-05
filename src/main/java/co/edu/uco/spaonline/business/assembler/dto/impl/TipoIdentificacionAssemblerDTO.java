package co.edu.uco.spaonline.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.business.assembler.dto.AssemblerDTO;
import co.edu.uco.spaonline.business.domain.TipoIdentificacionDomain;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;
import co.edu.uco.spaonline.dto.TipoIdentificacionDTO;

public class TipoIdentificacionAssemblerDTO implements AssemblerDTO<TipoIdentificacionDomain, TipoIdentificacionDTO> {
	
private static final AssemblerDTO<TipoIdentificacionDomain, TipoIdentificacionDTO> instance = new TipoIdentificacionAssemblerDTO();
	
	protected TipoIdentificacionAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<TipoIdentificacionDomain, TipoIdentificacionDTO> getinstace(){
		return instance;
	}

	@Override
	public TipoIdentificacionDomain toDomain(TipoIdentificacionDTO data) {
		return TipoIdentificacionDomain.build(data.getId(), data.getNombre());
	}

	@Override
	public List<TipoIdentificacionDomain> toDomainCollection(List<TipoIdentificacionDTO> entityCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection, new ArrayList<TipoIdentificacionDTO>());		
		return dtoCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public TipoIdentificacionDTO toDTO(TipoIdentificacionDomain domain) {
		return TipoIdentificacionDTO.build(domain.getId(), domain.getNombre());
	}

	@Override
	public List<TipoIdentificacionDTO> toDTOCollection(List<TipoIdentificacionDomain> domain) {
		List<TipoIdentificacionDTO> resultados = new ArrayList<>();
		for (int i = 0; i < domain.size(); i++) {
			resultados.add(TipoIdentificacionAssemblerDTO.getinstace().toDTO(domain.get(i)));
		}		
		return resultados;
	}


}
