package co.edu.uco.spaonline.business.assembler.dto.impl;


import java.util.ArrayList;
import java.util.List;


import co.edu.uco.spaonline.business.assembler.dto.AssemblerDTO;
import co.edu.uco.spaonline.business.domain.ServicioDomain;
import co.edu.uco.spaonline.business.domain.TipoServicioDomain;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;
import co.edu.uco.spaonline.dto.ServicioDTO;
import co.edu.uco.spaonline.dto.TipoServicioDTO;

public class ServicioAssemblerDTO implements AssemblerDTO<ServicioDomain, ServicioDTO>{

	private static final AssemblerDTO<TipoServicioDomain, TipoServicioDTO> tiposervicioAssembler = TipoServicioAssemblerDTO.getinstace();
	private static final AssemblerDTO<ServicioDomain, ServicioDTO> instance = new ServicioAssemblerDTO();
	
	protected ServicioAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<ServicioDomain, ServicioDTO> getinstace(){
		return instance;
	}

	@Override
	public ServicioDomain toDomain(ServicioDTO data) {
		var tiposervicio =  tiposervicioAssembler.toDomain(data.getTiposervicio());
		return ServicioDomain.build(data.getId(),data.getNombre() , data.getDescipcion(), tiposervicio, data.getTarifa());
	}

	@Override
	public List<ServicioDomain> toDomainCollection(List<ServicioDTO> entityCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection, new ArrayList<ServicioDTO>());		
		return dtoCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public ServicioDTO toDTO(ServicioDomain domain) {
		var tiposervicio =  tiposervicioAssembler.toDTO(domain.getTiposervicio());
		return ServicioDTO.build().setId(domain.getId()).setNombre(domain.getNombre()).setDescipcion(domain.getDescipcion()).setTiposervicio(tiposervicio).setTarifa(domain.getTarifa());
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
