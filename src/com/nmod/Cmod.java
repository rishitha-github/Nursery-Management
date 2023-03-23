package com.nmod;

public class Cmod {
private int id;
private String cname;
 private Long cnumber;
private int amt;
public Cmod(int id, String cname, Long cnumber, int amt) {
	super();
	this.id = id;
	this.cname = cname;
	this.cnumber = cnumber;
	this.amt = amt;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public Long getCnumber() {
	return cnumber;
}
public void setCnumber(Long cnumber) {
	this.cnumber = cnumber;
}
public int getAmt() {
	return amt;
}
public void setAmt(int amt) {
	this.amt = amt;
}

}
