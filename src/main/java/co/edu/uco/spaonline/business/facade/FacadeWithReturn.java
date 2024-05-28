package co.edu.uco.spaonline.business.facade;

public interface FacadeWithReturn <T , K >{
	
	K execute(T dto);

}
