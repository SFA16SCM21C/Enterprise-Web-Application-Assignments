import java.io.Serializable;

public class Login implements Serializable {
	
	private String passWord;
private String firstname;
private String emailid;
	
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	
	public String getEmailId() {
		return emailid;
	}
	public void setEmailId(String emailid) {
		this.emailid = emailid;
	}
	
}
