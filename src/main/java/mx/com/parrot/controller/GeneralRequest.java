package mx.com.parrot.controller;


/**
 * Clase generica para request de peticiones y modelado.
 * 
 * @author Cristian Ivan Peña
 *
 */
public class GeneralRequest {
	
	
	
	
	private String origin;

	
	private Metadata metadata;


	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}



}
