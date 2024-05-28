package co.edu.uco.spaonline.business.usecase;

public interface UseCaseWithReturn <T , R> {
	
	R execute (T data);

}
