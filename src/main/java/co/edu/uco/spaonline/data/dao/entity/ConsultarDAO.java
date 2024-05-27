package co.edu.uco.spaonline.data.dao.entity;

import java.util.List;

public interface ConsultarDAO<E> {
	
	List<E> consultar(E data);

}
