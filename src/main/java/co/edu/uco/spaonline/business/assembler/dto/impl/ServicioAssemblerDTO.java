package co.edu.uco.spaonline.business.assembler.dto.impl;


import java.util.ArrayList;
import java.util.List;


import co.edu.uco.spaonline.business.assembler.dto.AssemblerDTO;
import co.edu.uco.spaonline.business.domain.ServicioDomain;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;
import co.edu.uco.spaonline.dto.ServicioDTO;

public class ServicioAssemblerDTO implements AssemblerDTO<ServicioDomain, ServicioDTO>{


	private static final AssemblerDTO<ServicioDomain, ServicioDTO> instance = new ServicioAssemblerDTO();
	
	protected ServicioAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<ServicioDomain, ServicioDTO> getinstace(){
		return instance;
	}

	@Override
	public ServicioDomain toDomain(ServicioDTO data) {
		return ServicioDomain.build(data.getId(),data.getNombre() , data.getDescipcion(), data.getTiposervicio(), data.getTarifa());
	}

	@Override
	public List<ServicioDomain> toDomainCollection(List<ServicioDTO> entityCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection, new ArrayList<ServicioDTO>());		
		return dtoCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public ServicioDTO toDTO(ServicioDomain domain) {
		return ServicioDTO.build().setId(domain.getId()).setNombre(domain.getNombre()).setDescipcion(domain.getDescipcion()).setTiposervicio(domain.getTiposervicio()).setTarifa(domain.getTarifa());
	}

	@Override
	public List<ServicioDTO> toDTOCollection(List<ServicioDomain> domain) {
		List<ServicioDTO> resultados = new ArrayList<>();
		for (int i = 0; i < domain.size(); i++) {
			resultados.add(ServicioAssemblerDTO.getinstace().toDTO(domain.get(i)));
		}		
		return resultados;
	}

}
