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
	
}
