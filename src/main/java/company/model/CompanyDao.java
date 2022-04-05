package company.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("companyDao")
public class CompanyDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "company.CompanyBean";

	public List<CompanyBean> getCompanyList() {
		List<CompanyBean> companyList = new ArrayList<CompanyBean>();
		companyList = sqlSessionTemplate.selectList(namespace+".GetCompanyList");
		return companyList;
	}
	
	public int insertCompany(CompanyBean bean) {
		int cnt = -1;
		System.out.println("getCadmin"+bean.getCadmin());
		System.out.println("getCname"+bean.getCname());
		System.out.println("getUpload"+bean.getUpload().getOriginalFilename());
		System.out.println("getCimage"+bean.getCimage());
		cnt = sqlSessionTemplate.insert(namespace+".InsertCompany", bean);
		return cnt;
	}
	
}
