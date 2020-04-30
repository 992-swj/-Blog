package com.swj.bean;

public class UserInfo {
	private Integer userid;
	private String loginid;
	private String loginpwd;
	private String username;
	private String QQ;
	private String mail;
	private Integer adminis;
	
	
	public Integer getAdminis() {
		return adminis;
	}

	public void setAdminis(Integer adminis) {
		this.adminis = adminis;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getLoginpwd() {
		return loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", loginid=" + loginid
				+ ", loginpwd=" + loginpwd + ", username=" + username + ", QQ="
				+ QQ + ", mail=" + mail + "]";
	}

}
