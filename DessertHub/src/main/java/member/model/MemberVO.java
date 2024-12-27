package member.model;

import java.sql.Blob;

public class MemberVO {
	private String id;
	private String pass;
	private String email;
	private String nick;
	private Blob pfp;
	
	public MemberVO() {}
	
	public MemberVO(String id, String pass, String email, String nick, Blob pfp) {
		this.id = id;
		this.pass = pass;
		this.email = email;
		this.nick = nick;
		this.pfp = pfp;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Blob getPfp() {
		return pfp;
	}

	public void setPfp(Blob pfp) {
		this.pfp = pfp;
	}
}
