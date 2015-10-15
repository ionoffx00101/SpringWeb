package org.kdea.spring.eventcon;

public class Event {
    
    private int eno;
    private java.sql.Date edate;
    private String eorg;
    private String eplace;
    private String phone;

    public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public java.sql.Date getEdate() {
		return edate;
	}
	public void setEdate(java.sql.Date edate) {
		this.edate = edate;
	}
	public String getEorg() {
		return eorg;
	}
	public void setEorg(String eorg) {
		this.eorg = eorg;
	}
	public String getEplace() {
		return eplace;
	}
	public void setEplace(String eplace) {
		this.eplace = eplace;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
