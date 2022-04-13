package bohum.model;

public class BohumDetailBean {
	String basDt;
	String cmpyCd;
	String cmpyNm;
	String ptrn;
	String mog; 	 
	String age; 	 
	String prdNm;
	String mlInsRt;
	String fmlInsRt; 
	String priceSum;	//여자/남자 보험료 더한거
	String mogCount;	//특약 갯수
	public BohumDetailBean() {
		super();
	}
	public BohumDetailBean(String basDt, String cmpyCd, String cmpyNm, String ptrn, String mog, String prdNm,
			String mlInsRt, String fmlInsRt, String priceSum, String mogCount,String age) {
		super();
		this.basDt = basDt;
		this.cmpyCd = cmpyCd;
		this.cmpyNm = cmpyNm;
		this.ptrn = ptrn;
		this.mog = mog;
		this.prdNm = prdNm;
		this.mlInsRt = mlInsRt;
		this.fmlInsRt = fmlInsRt;
		this.priceSum = priceSum;
		this.mogCount = mogCount;
		this.age = age;
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
	public String getPriceSum() {
		return priceSum;
	}
	public void setPriceSum(String priceSum) {
		this.priceSum = priceSum;
	}
	public String getMogCount() {
		return mogCount;
	}
	public void setMogCount(String mogCount) {
		this.mogCount = mogCount;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
