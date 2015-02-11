package com.gzctksxt.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class PJBean implements Serializable{
	private int id;
	private String name;
	private String zb;
	private String fhl;
	private String wcjd;
	private String hbts;
	private Timestamp rq;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZb() {
		return zb;
	}
	public void setZb(String zb) {
		this.zb = zb;
	}
	public String getFhl() {
		return fhl;
	}
	public void setFhl(String fhl) {
		this.fhl = fhl;
	}
	public String getWcjd() {
		return wcjd;
	}
	public void setWcjd(String wcjd) {
		this.wcjd = wcjd;
	}
	public String getHbts() {
		return hbts;
	}
	public void setHbts(String hbts) {
		this.hbts = hbts;
	}
	public Timestamp getRq() {
		return rq;
	}
	public void setRq(Timestamp rq) {
		this.rq = rq;
	}
}
