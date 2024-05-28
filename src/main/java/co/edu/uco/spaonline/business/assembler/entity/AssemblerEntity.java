package co.edu.uco.spaonline.business.assembler.entity;

import co.edu.uco.spaonline.business.assembler.Assembler;

public interface AssemblerEntity <D, K> extends Assembler<D, K>{
	
	K toEntity(D domain);

}
