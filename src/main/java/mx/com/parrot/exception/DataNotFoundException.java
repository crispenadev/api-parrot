package mx.com.parrot.exception;

public class DataNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String nameHermo) {
        super("Data not found by filter:" + nameHermo);
    }

}
