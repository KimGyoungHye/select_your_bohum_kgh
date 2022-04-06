package bohum.test;

public class BohumTestBean {
	private String basDt;		//YYYYMMDD 기준일자
	private String cmpyCd;		// 회사코드
	private String cmpyNm;		// 회사명
	private String ptrn;		//	유형
	private String mog;			// 담보
	private String prdNm;		// 상품명
	private String age;			// 연령
	private String mlInsRt;		// 남자보험료
	private String fmlInsRt;	// 여자보험료
	public BohumTestBean() {
		super();
	}
	public BohumTestBean(String basDt, String cmpyCd, String cmpyNm, String ptrn, String mog, String prdNm, String age,
			String mlInsRt, String fmlInsRt) {
		super();
		this.basDt = basDt;
		this.cmpyCd = cmpyCd;
		this.cmpyNm = cmpyNm;
		this.ptrn = ptrn;
		this.mog = mog;
		this.prdNm = prdNm;
		this.age = age;
		this.mlInsRt = mlInsRt;
		this.fmlInsRt = fmlInsRt;
	}
	public String getBasDt() {
		return basDt;
	}
	public void setBasDt(String basDt) {
		this.basDt = basDt;
	}
	public String getCmpyCd() {
		return cmpyCd;
	}
	public void setCmpyCd(String cmpyCd) {
		this.cmpyCd = cmpyCd;
	}
	public String getCmpyNm() {
		return cmpyNm;
	}
	public void setCmpyNm(String cmpyNm) {
		this.cmpyNm = cmpyNm;
	}
	public String getPtrn() {
		return ptrn;
	}
	public void setPtrn(String ptrn) {
		this.ptrn = ptrn;
	}
	public String getMog() {
		return mog;
	}
	public void setMog(String mog) {
		this.mog = mog;
	}
	public String getPrdNm() {
		return prdNm;
	}
	public void setPrdNm(String prdNm) {
		this.prdNm = prdNm;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMlInsRt() {
		return mlInsRt;
	}
	public void setMlInsRt(String mlInsRt) {
		this.mlInsRt = mlInsRt;
	}
	public String getFmlInsRt() {
		return fmlInsRt;
	}
	public void setFmlInsRt(String fmlInsRt) {
		this.fmlInsRt = fmlInsRt;
	}
}

