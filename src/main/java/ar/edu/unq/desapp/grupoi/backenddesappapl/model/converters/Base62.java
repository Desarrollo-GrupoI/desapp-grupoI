package ar.edu.unq.desapp.grupoi.backenddesappapl.model.converters;

public class Base62 {
	public static final String BASE62_ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	public static final int BASE62_BASE = 62;
	
	private Base62() {}
	
	public static String encode(long number) {
		StringBuilder stringBuilder = new StringBuilder(1);
	    do {
	      stringBuilder.insert(0, BASE62_ALPHABET.charAt((int) (number % BASE62_BASE)));
	      number /= BASE62_BASE;
	    } while(number > 0);
	    
	    return stringBuilder.toString();
	}
}
