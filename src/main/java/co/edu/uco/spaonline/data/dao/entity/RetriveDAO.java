package co.edu.uco.spaonline.data.dao.entity;

import java.util.List;

interface RetriveDAO <E> {

	List<E> consultar(E data);
}
