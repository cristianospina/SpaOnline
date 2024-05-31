package co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.spaonline.crosscutting.exceptions.custom.CrosscuttingSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.spaonline.crosscutting.helpers.ObjectHelper;



public final class MessageCatalogBase  implements MessageCatalog{

	private final Map<String, Mensaje> mensajes = new HashMap<>();
	@Override
	public void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00001.getIdentificador(), new Mensaje(CodigoMensaje.M00001,
				"El código del mensaje que quiere obtener del catálogo mensajes llegó nulo..."));
		mensajes.put(CodigoMensaje.M00002.getIdentificador(), new Mensaje(CodigoMensaje.M00002,
				"Se ha presentado un problema tratando de llevar a cabo la operación deseada..."));
		mensajes.put(CodigoMensaje.M00003.getIdentificador(), new Mensaje(CodigoMensaje.M00003,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00004.getIdentificador(), new Mensaje(CodigoMensaje.M00004,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00005.getIdentificador(), new Mensaje(CodigoMensaje.M00005,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes externo..."));
		mensajes.put(CodigoMensaje.M00006.getIdentificador(), new Mensaje(CodigoMensaje.M00006,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes externo..."));
		mensajes.put(CodigoMensaje.M00007.getIdentificador(), new Mensaje(CodigoMensaje.M00007,
				"Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00008.getIdentificador(), new Mensaje(CodigoMensaje.M00008,
				"Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00009.getIdentificador(), new Mensaje(CodigoMensaje.M00009,
				"Se ha intentado realizar el cierre de una conexión SQL que ya estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00010.getIdentificador(), new Mensaje(CodigoMensaje.M00010,
				"Se ha presentado un problema tratando de cerrar la conexión SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00011.getIdentificador(), new Mensaje(CodigoMensaje.M00011,
				"Se ha presentado un problema INESPERADO tratando de cerrar la conexión SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00012.getIdentificador(), new Mensaje(CodigoMensaje.M00012,
				"Se ha intentado confirmar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00013.getIdentificador(), new Mensaje(CodigoMensaje.M00013,
				"Se ha intentado confirmar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
		mensajes.put(CodigoMensaje.M00014.getIdentificador(), new Mensaje(CodigoMensaje.M00014,
				"Se ha presentado un problema tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00015.getIdentificador(), new Mensaje(CodigoMensaje.M00015,
				"Se ha presentado un problema INESPERADO tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00016.getIdentificador(), new Mensaje(CodigoMensaje.M00016,
				"Se ha intentado cancelar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00017.getIdentificador(), new Mensaje(CodigoMensaje.M00017,
				"Se ha intentado cancelar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
		mensajes.put(CodigoMensaje.M00018.getIdentificador(), new Mensaje(CodigoMensaje.M00018,
				"Se ha presentado un problema tratando de cancelar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00019.getIdentificador(), new Mensaje(CodigoMensaje.M00019,
				"Se ha presentado un problema INESPERADO tratando de cancelar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00020.getIdentificador(), new Mensaje(CodigoMensaje.M00020,
				"Se ha intentado iniciar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00021.getIdentificador(), new Mensaje(CodigoMensaje.M00021,
				"Se ha presentado un problema tratando de iniciar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00022.getIdentificador(), new Mensaje(CodigoMensaje.M00022,
				"Se ha presentado un problema INESPERADO tratando de iniciar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00023.getIdentificador(), new Mensaje(CodigoMensaje.M00023,
				"No es posible crear el DAO deseado con una conexion cerrada"));
		mensajes.put(CodigoMensaje.M00024.getIdentificador(), new Mensaje(CodigoMensaje.M00024,
				"Se ha presentado un problema tratando de consultar los servicios..."));
		mensajes.put(CodigoMensaje.M00025.getIdentificador(), new Mensaje(CodigoMensaje.M00025,
				"Se ha presentado un problema de tipo SQLException en el método consultar de la clase ServicioAzureSqlDAO tratando de realizar la consulta de servicios \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00026.getIdentificador(), new Mensaje(CodigoMensaje.M00026,
				"Se ha presentado un problema de tipo Exception en el método consultar de la clase ServicioAzureSqlDAO tratando de realizar la consulta de servicios \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00027.getIdentificador(), new Mensaje(CodigoMensaje.M00027,
				"Se ha presentado un problema tratando de crear el servicio \\\"${1}\\\". Por favor intente de nuevo y si el problema persiste contacte al administrador"));
		mensajes.put(CodigoMensaje.M00028.getIdentificador(), new Mensaje(CodigoMensaje.M00028,
				"Se ha presentado una excepcion de tipo SQL exception tratando realizar  el insert de los servicios \\\"${1}\\\" en la tabla \\\"Servicios\\\" de la tabla AzureSQL, para mas detalles, revise de forma completa la excepcion raíz presentada..."));
		mensajes.put(CodigoMensaje.M00029.getIdentificador(), new Mensaje(CodigoMensaje.M00029,
				"Se ha presentado  un problema INESPERADO con una excepcion de tipo SQL exception tratando realizar  el insert de los servicios \\\"${1}\\\" en la tabla \\\"Servicios\\\" de la tabla AzureSQL, para mas detalles, revise de forma completa la excepcion raíz presentada..."));
		mensajes.put(CodigoMensaje.M00030.getIdentificador(), new Mensaje(CodigoMensaje.M00030,
				"Se ha presentado un problema tratando de crear los servicios"));
		mensajes.put(CodigoMensaje.M00031.getIdentificador(), new Mensaje(CodigoMensaje.M00031,
				"Se ha presentado un problema tratando de eliminar los servicios"));
		mensajes.put(CodigoMensaje.M00032.getIdentificador(), new Mensaje(CodigoMensaje.M00032,
				"Se ha presentado un problema tratando de modificar los servicios"));
		mensajes.put(CodigoMensaje.M00033.getIdentificador(), new Mensaje(CodigoMensaje.M00033,
				"Se ha presentado un problema de tipo SQLException en el método crear de la clase ServicioAzureSqlDAO tratando de realizar la creacion de servicios \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00034.getIdentificador(), new Mensaje(CodigoMensaje.M00034,
				"Se ha presentado un problema de tipo SQLException en el método eliminar de la clase ServicioAzureSqlDAO tratando de realizar la eliminacion de servicios \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00035.getIdentificador(), new Mensaje(CodigoMensaje.M00035,
				"Se ha presentado un problema de tipo SQLException en el método modificar de la clase ServicioAzureSqlDAO tratando de realizar la modificacion de servicios \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00036.getIdentificador(), new Mensaje(CodigoMensaje.M00036,
				"Se ha presentado un problema de tipo Exception en el método crear de la clase ServicioAzureSqlDAO tratando de realizar la creacion de servicios \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00037.getIdentificador(), new Mensaje(CodigoMensaje.M00037,
				"Se ha presentado un problema de tipo Exception en el método eliminar de la clase ServicioAzureSqlDAO tratando de realizar la eliminacion de servicios \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00038.getIdentificador(), new Mensaje(CodigoMensaje.M00038,
				"Se ha presentado un problema de tipo Exception en el método consultar de la clase ServicioAzureSqlDAO tratando de realizar la consulta de servicios \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00039.getIdentificador(), new Mensaje(CodigoMensaje.M00039,
				"Se ha presentado un problema intentando consultar un servicio"));
		mensajes.put(CodigoMensaje.M00040.getIdentificador(), new Mensaje(CodigoMensaje.M00040,
				"Se ha presentado un problema intentando registrar un Servicio"));
		mensajes.put(CodigoMensaje.M00041.getIdentificador(), new Mensaje(CodigoMensaje.M00041,
				"Se ha presentado un problema intentando Eliminar un servicio"));
		mensajes.put(CodigoMensaje.M00042.getIdentificador(), new Mensaje(CodigoMensaje.M00042,
				"Se ha presentado un problema intentando modificar un servicio"));
		mensajes.put(CodigoMensaje.M00043.getIdentificador(), new Mensaje(CodigoMensaje.M00043,
				"Se ha presentado un problema tratando de consultar la informacion de Servicio"));
		mensajes.put(CodigoMensaje.M00044.getIdentificador(), new Mensaje(CodigoMensaje.M00044,
				"Se ha presentado un problema INESPERADO tratando de consultar la informacion de Servicio"));
		mensajes.put(CodigoMensaje.M00045.getIdentificador(), new Mensaje(CodigoMensaje.M00045,
				"Se ha presentado un problema tratando de ingresar la informacion de servicio"));
		mensajes.put(CodigoMensaje.M00046.getIdentificador(), new Mensaje(CodigoMensaje.M00046,
				"Se ha presentado un problema INESPERADO tratando de ingresar la informacion de servicio"));
		mensajes.put(CodigoMensaje.M00047.getIdentificador(), new Mensaje(CodigoMensaje.M00047,
				"Se ha presentado un problema tratando de modificar la informacion de servicio"));
		mensajes.put(CodigoMensaje.M00048.getIdentificador(), new Mensaje(CodigoMensaje.M00048,
				"Se ha presentado un problema INESPERADO tratando de modificar la informacion de servicio"));
		mensajes.put(CodigoMensaje.M00049.getIdentificador(), new Mensaje(CodigoMensaje.M00049,
				"Se ha presentado un problema tratando de ingresar la informacion de la servicio"));
		mensajes.put(CodigoMensaje.M00050.getIdentificador(), new Mensaje(CodigoMensaje.M00050,
				"Se ha presentado un problema INESPERADO tratando de ingresar la informacion de la servicio"));
		mensajes.put(CodigoMensaje.M00051.getIdentificador(), new Mensaje(CodigoMensaje.M00051,
				"Se ha presentado un problema tratando de consultar la informacion de los servicios"));
		mensajes.put(CodigoMensaje.M00052.getIdentificador(), new Mensaje(CodigoMensaje.M00052,
				"Se ha presentado un problema INESPERADO tratando de consultar la informacion de los servicios"));
		mensajes.put(CodigoMensaje.M00053.getIdentificador(), new Mensaje(CodigoMensaje.M00053,
				"Se ha presentado un problema tratando de validar la informacion de los servicios con el tiposervicio"));
		mensajes.put(CodigoMensaje.M00054.getIdentificador(), new Mensaje(CodigoMensaje.M00054,
				"Se ha presentado un problema tratando de validar la longitud"));
		mensajes.put(CodigoMensaje.M00055.getIdentificador(), new Mensaje(CodigoMensaje.M00055,
				"Se ha presentado un problema tratando de eliminar la informacion de los servicios"));
		mensajes.put(CodigoMensaje.M00056.getIdentificador(), new Mensaje(CodigoMensaje.M00056,
				"Se ha presentado un problema INESPERADO tratando de eliminar la informacion de los servicios"));
		mensajes.put(CodigoMensaje.M00057.getIdentificador(), new Mensaje(CodigoMensaje.M00057,
				"Se ha presentado un problema tratando de modificar la informacion de los servicios"));
		mensajes.put(CodigoMensaje.M00058.getIdentificador(), new Mensaje(CodigoMensaje.M00058,
				"Se ha presentado un problema INESPERADO tratando de modificar la informacion de los servicios"));
		mensajes.put(CodigoMensaje.M00059.getIdentificador(), new Mensaje(CodigoMensaje.M00059,
				"Se ha presentado un problema tratando de validar la obligatoriedad de la informacion de los servicios"));
		mensajes.put(CodigoMensaje.M00060.getIdentificador(), new Mensaje(CodigoMensaje.M00060,
				"Se ha presentado un problema tratando de validar el formato la informacion de los servicios"));
		mensajes.put(CodigoMensaje.M00061.getIdentificador(), new Mensaje(CodigoMensaje.M00061,
				"Se ha presentado un problema tratando de registrar la informacion de los servicios"));
		mensajes.put(CodigoMensaje.M00062.getIdentificador(), new Mensaje(CodigoMensaje.M00062,
				"Se ha presentado un problema INESPERADO tratando de registrar la informacion de los servicios"));
		mensajes.put(CodigoMensaje.M00063.getIdentificador(), new Mensaje(CodigoMensaje.M00063,
				"Se ha presentado un error al intentar crear un servicio, por favor intentarlo más tardes..."));
		mensajes.put(CodigoMensaje.M00064.getIdentificador(), new Mensaje(CodigoMensaje.M00064,
				"Se ha presentado un error de tipo SQLException tratando de crear un nuevo servicio"));
		mensajes.put(CodigoMensaje.M00065.getIdentificador(), new Mensaje(CodigoMensaje.M00065,
				"Se ha presentado un error INESPERADO al intentar crear un servicio, por favor intentarlo más tardes..."));
		mensajes.put(CodigoMensaje.M00066.getIdentificador(), new Mensaje(CodigoMensaje.M00066,
				"Se ha presentado un error de tipo Exception tratando de crear un nuevo servicio"));
		mensajes.put(CodigoMensaje.M00067.getIdentificador(), new Mensaje(CodigoMensaje.M00067,
				"se ha presentado un problema tratando de modificar un Servicio"));
		mensajes.put(CodigoMensaje.M00068.getIdentificador(), new Mensaje(CodigoMensaje.M00068,
				"Se ha presentado un problema de tipo SQLException en el método modificar de la clase ServicioAzureSqlDAO tratando de llevar a cabo la modificación de Servicio \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00069.getIdentificador(), new Mensaje(CodigoMensaje.M00069,
				"Sse ha presentado un problema tratando de modificar un Servicio"));
		mensajes.put(CodigoMensaje.M00070.getIdentificador(), new Mensaje(CodigoMensaje.M00070,
				"Se ha presentado un problema de tipo Exception en el método modificar de la clase ServicioAzureSqlDAO tratando de llevar a cabo la modificación de Servicio \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00071.getIdentificador(), new Mensaje(CodigoMensaje.M00071,
				"Se ha presentado un problema tratando de consultar los servicios..."));
		mensajes.put(CodigoMensaje.M00072.getIdentificador(), new Mensaje(CodigoMensaje.M00072,
				"Se ha presentado un problema de tipo SQLException en el método consultar de la clase ServicioAzureSqlDAO tratando de realizar la consulta de Servicio \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00073.getIdentificador(), new Mensaje(CodigoMensaje.M00073,
				"Se ha presentado un problema de tipo SQLEXCEPTION tratando de colocar los parametros de consulta"));
		mensajes.put(CodigoMensaje.M00074.getIdentificador(), new Mensaje(CodigoMensaje.M00074,
				"Se ha presentado un problema de tipo Exception en el método consultar de la clase ServicioAzureSqlDAO tratando de realizar la consulta de Servicio \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00075.getIdentificador(), new Mensaje(CodigoMensaje.M00075,
				"Se ha presentado un problema INESPERADO tratando de consultar los servicios..."));
		mensajes.put(CodigoMensaje.M00076.getIdentificador(), new Mensaje(CodigoMensaje.M00076,
				"Se ha presentado un problema de tipo Exception tratandode colocar los parametros de consulta..."));
		mensajes.put(CodigoMensaje.M00077.getIdentificador(), new Mensaje(CodigoMensaje.M00077,
				"Se ha presentado un problema tratando de eliminar la información del servicio..."));
		mensajes.put(CodigoMensaje.M00078.getIdentificador(), new Mensaje(CodigoMensaje.M00078,
				"Se ha presentado un problema de tipo SQLException en el método eliminar de la clase ServicioAzureSqlDAO tratando de eliminar el Servicio \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00079.getIdentificador(), new Mensaje(CodigoMensaje.M00079,
				"Se ha presentado un problema de tipo Exception en el método eliminar de la clase ServicioAzureSqlDAO tratando de eliminar el Servicio \\\"${1}\\\". Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		mensajes.put(CodigoMensaje.M00080.getIdentificador(), new Mensaje(CodigoMensaje.M00080,
				"Se ha presentado un problema tratando de obtener la conexión con la base de datos"));
		mensajes.put(CodigoMensaje.M00081.getIdentificador(), new Mensaje(CodigoMensaje.M00081,
				"Se ha presentado un problema INESPERADO tratando de obtener la conexión con la base de datos"));
	}

	@Override
	public String obtenerContenidoMensaje(final CodigoMensaje codigo, String... parametros) {
		
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public Mensaje obtenerMensaje(final CodigoMensaje codigo, String... parametros) {
		if(ObjectHelper.isNull(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscuttingSpaOnlineException (mensajeTecnico,mensajeUsuario);
		}
		if(!codigo.esBase()) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00005, codigo.getIdentificador());
			throw new CrosscuttingSpaOnlineException (mensajeTecnico,mensajeUsuario);
		}
		if(!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00003, codigo.getIdentificador());
			throw new CrosscuttingSpaOnlineException (mensajeTecnico,mensajeUsuario);
		}

		
		return mensajes.get( codigo.getIdentificador());
	}
}
