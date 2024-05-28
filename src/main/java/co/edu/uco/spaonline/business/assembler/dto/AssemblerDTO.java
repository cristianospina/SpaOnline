package co.edu.uco.spaonline.business.assembler.dto;

import java.util.List;

import co.edu.uco.spaonline.business.assembler.Assembler;


public interface AssemblerDTO <D, K> extends Assembler<D, K>{

	K toDTO(D domain);
	
	List<K> toDTOCollection( List<D> domain);

}
