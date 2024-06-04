package co.edu.uco.spaonline.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.multi.MultiPopupMenuUI;

import co.edu.uco.spaonline.business.assembler.dto.AssemblerDTO;
import co.edu.uco.spaonline.business.domain.ServicioDomain;
import co.edu.uco.spaonline.business.domain.TipoServicioDomain;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;
import co.edu.uco.spaonline.dto.ServicioDTO;
import co.edu.uco.spaonline.dto.TipoServicioDTO;

public class TipoServicioAssemblerDTO implements AssemblerDTO<TipoServicioDomain, TipoServicioDTO> {
	
private static final AssemblerDTO<TipoServicioDomain, TipoServicioDTO> instance = new TipoServicioAssemblerDTO();
	
	protected TipoServicioAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<TipoServicioDomain, TipoServicioDTO> getinstace(){
		return instance;
	}

	@Override
	public TipoServicioDomain toDomain(TipoServicioDTO data) {
		return TipoServicioDomain.build(data.getId(), data.getNombre());
	}

	@Override
	public List<TipoServicioDomain> toDomainCollection(List<TipoServicioDTO> entityCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection, new ArrayList<TipoServicioDTO>());		
		return dtoCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public TipoServicioDTO toDTO(TipoServicioDomain domain) {
		return TipoServicioDTO.build(domain.getId(), domain.getNombre());
	}

	@Override
	public List<TipoServicioDTO> toDTOCollection(List<TipoServicioDomain> domain) {
		List<TipoServicioDTO> resultados = new ArrayList<>();
		for (int i = 0; i < domain.size(); i++) {
			resultados.add(TipoServicioAssemblerDTO.getinstace().toDTO(domain.get(i)));
		}		
		return resultados;
	}

}
