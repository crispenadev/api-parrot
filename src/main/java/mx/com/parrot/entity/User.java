package mx.com.parrot.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "os.user")
public class User {

	    
	    public String getEmail() {
		return email;
	}
	    
	    
	    
	public void setEmail(String email) {
		this.email = email;
	}
		@Id
	    private String email;
		
		
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
		private String user;
	    
		private String pwd;
	    private String token;
	    
	    private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	   

}
