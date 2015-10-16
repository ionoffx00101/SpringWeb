package org.kdea.upload;

public class UploadVO {

	private int fnum;
	private String orginfname;
	private String changefname;
	private String fdesc;
	private java.sql.Date fdate ;
	
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public String getOrginfname() {
		return orginfname;
	}
	public void setOrginfname(String orginfname) {
		this.orginfname = orginfname;
	}
	public String getChangefname() {
		return changefname;
	}
	public void setChangefname(String changefname) {
		this.changefname = changefname;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
	public java.sql.Date getFdate() {
		return fdate;
	}
	public void setFdate(java.sql.Date fdate) {
		this.fdate = fdate;
	}
	
	
	
}
