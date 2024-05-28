package co.edu.uco.spaonline.crosscutting.helpers;

public final class TextHelper {
	
	public static final String EMPTY = "";
	public static final String UNDERLINE = "_";
	private static final String PATTER_SOLO_LETRAS="^[A-Za-záéíóúÁÉÍÓÚ]+$";
	private static final String PATTER_SOLO_LETRAS_DIGITOS_ESPACIOS="^[0-9A-Za-záéíóúÁÉÍÓÚ]+$";
	

	
	private TextHelper() {
		super();
	}

	public static final boolean isNull (final String string) {
		return string == null;
	}
	
	public static final boolean isNullOrEmpty (final String string) {
		return isNull (string)|| EMPTY.equals(string.trim());
	}
	
	public static final String getDefaultValue(final String string, final String defaultValue) {
		return isNullOrEmpty(string) ? defaultValue : string; 
	}
	public static final String getDefaultValue(final String string) {
		return getDefaultValue(string, EMPTY); 
	}
	public static final String applyTrim(final String string) {
		return getDefaultValue(string).trim();
	}
	public static final boolean contieneSoloLetras(final String valor) {
		return getDefaultValue(valor).matches(PATTER_SOLO_LETRAS);
	}
	public static final boolean contieneSoloLetrasDigitosEspacios(final String valor) {
		return getDefaultValue(valor).matches(PATTER_SOLO_LETRAS_DIGITOS_ESPACIOS);
	}
	public static boolean longitudMinimaValida (final String valor, final int longitud) {
		return applyTrim(valor).length()>= longitud;
	}
	public static boolean longitudMaximaValida (final String valor, final int longitud) {
		return applyTrim(valor).length()<= longitud;
	}



	public static final String concatenate ( final String... strings) {
		final var stringBuilder = new StringBuilder(EMPTY);

	    if (strings != null) {
	        
	        boolean anyNull = false;
	        for (final var string : strings) {
	            if (isNull(string)) {
	                anyNull = true;
	                break;
	            }
	        }
	        if (!anyNull) {
	            for (final var string : strings) {
	                stringBuilder.append(applyTrim(string));
	            }
	        }
	    }

	    return stringBuilder.toString();
	}
	
	public static String reemplazarParametro(String mensaje, String... parametros) {
	    String mensajeReemplazado = mensaje;
	    for (int i = 0; i < parametros.length; i++) {
	        String marcador = "${" + (i + 1) + "}"; 
	        mensajeReemplazado = mensajeReemplazado.replace(marcador, parametros[i]);
	    }
	    return mensajeReemplazado;
	}
	
}
