package company.model;

import org.springframework.web.multipart.MultipartFile;

public class CompanyBean {
	private int cnum;
	private String cname;
	private String cimage;
	private String cinsurance;
	private String cadmin;
	private MultipartFile upload;

	public CompanyBean() {
		super();
	}
	public CompanyBean(int cnum, String cname, String cimage, String cinsurance, String cadmin) {
		super();
		this.cnum = cnum;
		this.cname = cname;
		this.cimage = cimage;
		this.cinsurance = cinsurance;
		this.cadmin = cadmin;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCimage() {
		return cimage;
	}
	public void setCimage(String cimage) {
		this.cimage = cimage;
	}
	public String getCinsurance() {
		return cinsurance;
	}
	public void setCinsurance(String cinsurance) {
		this.cinsurance = cinsurance;
	}
	public String getCadmin() {
		return cadmin;
	}
	public void setCadmin(String cadmin) {
		this.cadmin = cadmin;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		setCimage(upload.getOriginalFilename());
	}
}
