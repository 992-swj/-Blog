package com.swj.bean;

public class Jurisdiction {
	private Integer id;
	private String jname;
	private String urls;
	private Integer identitys;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	
	public Integer getIdentitys() {
		return identitys;
	}
	public void setIdentitys(Integer identitys) {
		this.identitys = identitys;
	}
	@Override
	public String toString() {
		return "Jurisdiction [id=" + id + ", jname=" + jname + ", urls=" + urls
				+ ", identity=" + identitys + "]";
	}
	
}
