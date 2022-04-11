package bohum.model;

import java.util.Map;

import member.model.MemberBean;
import memberDetail.model.MemberDetailBean;
import memberDetail.model.MemberDetailDao;

public class BohumUserBean {
	private int age;
	private String gender;
	private String disease;
	private int salary;
	private Map<String,String> map;
	public BohumUserBean() {
		super();
	}
	public BohumUserBean(int age, String gender, String disease, int salary, Map<String, String> map) {
		super();
		this.age = age;
		this.gender = gender;
		this.disease = disease;
		this.salary = salary;
		this.map = map;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String isDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
}
