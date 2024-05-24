package co.edu.uco.spaonline.data.dao.entity;

import java.util.UUID;

import co.edu.uco.spaonline.entity.ServicioEntity;


public interface ServicioDAO extends CreateDAO<ServicioEntity>, RetriveDAO<ServicioEntity>, UpdateDAO<ServicioEntity>, DeleteDAO<UUID>{

}
