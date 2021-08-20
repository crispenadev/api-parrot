package mx.com.parrot.entity;

import java.util.Date;
/**
 * Clase modelo para gestion del TOKEN JWT
 * 
 * @author Cristian Ivan Peña
 *
 */
public class Principal {

	private String user;

	private String pwd;
	private String token;
	private Date cdate;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	

}
