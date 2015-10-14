package org.kdea.spring.controller;

public class LoginCommand {
private String id;
private String pw;
private boolean ok;


public boolean isOk() {
	return ok;
}
public void setOk(boolean ok) {
	this.ok = ok;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPw() {
	return pw;
}
public void setPw(String pw) {
	this.pw = pw;
}


}
