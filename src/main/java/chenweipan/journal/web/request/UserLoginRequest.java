package chenweipan.journal.web.request;


public class UserLoginRequest {

	private String user;
	
	private String pwd;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "UserLoginRequest [user=" + user + ", pwd=" + pwd + "]";
	}
	
}
