package board.dto;

public class Board2 {
	
	private int bno;
	private String bname;
	private String bpass;
	private String btitle;
	private String bcontent;
	private String bip;
	private String bdate;
	private int bhit;
	private String bfile;
	
	public Board2() {
		super();
	}
	
	
	public Board2(int bno, String bname, String bpass, String btitle, String bcontent, String bip, String bdate,
			int bhit, String bfile) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.bpass = bpass;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bip = bip;
		this.bdate = bdate;
		this.bhit = bhit;
		this.bfile = bfile;
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}


	public String getBpass() {
		return bpass;
	}


	public void setBpass(String bpass) {
		this.bpass = bpass;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public String getBip() {
		return bip;
	}


	public void setBip(String bip) {
		this.bip = bip;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}


	public int getBhit() {
		return bhit;
	}


	public void setBhit(int bhit) {
		this.bhit = bhit;
	}


	public String getBfile() {
		return bfile;
	}


	public void setBfile(String bfile) {
		this.bfile = bfile;
	}


	@Override
	public String toString() {
		return "Board2 [bno=" + bno + ", bname=" + bname + ", bpass=" + bpass + ", btitle=" + btitle + ", bcontent="
				+ bcontent + ", bip=" + bip + ", bdate=" + bdate + ", bhit=" + bhit + ", bfile=" + bfile + ", getBno()="
				+ getBno() + ", getBname()=" + getBname() + ", getBpass()=" + getBpass() + ", getBtitle()="
				+ getBtitle() + ", getBcontent()=" + getBcontent() + ", getBip()=" + getBip() + ", getBdate()="
				+ getBdate() + ", getBhit()=" + getBhit() + ", getBfile()=" + getBfile() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	


}
