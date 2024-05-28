package co.edu.uco.spaonline.crosscutting.helpers;

public final  class NumHelper {

	public static final Long NUM_DEFECT = 0L;
	
	protected NumHelper() {
		super();
	}
	
	
	public static final boolean isNull(final Long numero) {
		return numero == null;
	}
	
	public static final Long getDefaultValue (final Long numero , final Long valordefecto ) {
		return isNull(numero) ? valordefecto : numero ;
	}
	
	public static final Long getDefaultValue(final Long numero) {
		return getDefaultValue(numero, NUM_DEFECT); 
	}
	public static final boolean isDefaultValue (final Long num) {
		return num == NUM_DEFECT;
	}
}
