package member.model;

public class MemberBean {
	private String id;
	private String password;
	private String name;
	private int regi_number1 ;
	private int regi_number2 ;
	private int phone1 ;
	private int phone2 ;
	private int phone3 ;
	private String email1 ;
	private String email2 ;
	private String userState;
	private int userDetail;
	private String companyInfo;
	public MemberBean() {
		super();
	}
	public MemberBean(String id, String password, String name, int regi_number1, int regi_number2, int phone1,
			int phone2, int phone3, String email1, String email2, String userState, int userDetail,
			String companyInfo) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.regi_number1 = regi_number1;
		this.regi_number2 = regi_number2;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.email1 = email1;
		this.email2 = email2;
		this.userState = userState;
		this.userDetail = userDetail;
		this.companyInfo = companyInfo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRegi_number1() {
		return regi_number1;
	}
	public void setRegi_number1(int regi_number1) {
		this.regi_number1 = regi_number1;
	}
	public int getRegi_number2() {
		return regi_number2;
	}
	public void setRegi_number2(int regi_number2) {
		this.regi_number2 = regi_number2;
	}
	public int getPhone1() {
		return phone1;
	}
	public void setPhone1(int phone1) {
		this.phone1 = phone1;
	}
	public int getPhone2() {
		return phone2;
	}
	public void setPhone2(int phone2) {
		this.phone2 = phone2;
	}
	public int getPhone3() {
		return phone3;
	}
	public void setPhone3(int phone3) {
		this.phone3 = phone3;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public int getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(int userDetail) {
		this.userDetail = userDetail;
	}
	public String getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}
	
}
