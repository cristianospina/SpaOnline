package co.edu.uco.spaonline.data.dao.entity;

import java.util.UUID;

import co.edu.uco.spaonline.entity.ServicioEntity;

public interface ServicioDAO extends CrearDAO<ServicioEntity>, ModificarDAO<ServicioEntity>,
									 ConsultarDAO<ServicioEntity>, EliminarDAO<UUID> { 
	

}
