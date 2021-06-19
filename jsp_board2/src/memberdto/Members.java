package memberdto;

public class Members {
	
	private int userno;
	private String userid;
	private String username;
	private String userpass;
	private String useremail;
	private String userip;
	private String userdate;
	
	public Members() {
		super();
	}

	public Members(int userno, String userid, String username, String userpass, String useremail, String userip,
			String userdate) {
		super();
		this.userno = userno;
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;
		this.useremail = useremail;
		this.userip = userip;
		this.userdate = userdate;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserip() {
		return userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

	public String getUserdate() {
		return userdate;
	}

	public void setUserdate(String userdate) {
		this.userdate = userdate;
	}

	@Override
	public String toString() {
		return "Members [userno=" + userno + ", userid=" + userid + ", username=" + username + ", userpass=" + userpass
				+ ", useremail=" + useremail + ", userip=" + userip + ", userdate=" + userdate + ", getUserno()="
				+ getUserno() + ", getUserid()=" + getUserid() + ", getUsername()=" + getUsername() + ", getUserpass()="
				+ getUserpass() + ", getUseremail()=" + getUseremail() + ", getUserip()=" + getUserip()
				+ ", getUserdate()=" + getUserdate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
