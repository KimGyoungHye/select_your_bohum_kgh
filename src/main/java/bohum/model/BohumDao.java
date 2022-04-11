package bohum.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bohum.test.BohumTestBean;

@Component("bohumDao")
public class BohumDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "bohum.BohumBean";

	public int insertBohum(BohumTestBean bean) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertBohum", bean);
		return cnt;
	}
}
