package bohum.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bohum.test.BohumTestBean;
import utility.Paging;

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

	public int getTotalCount(BohumUserBean bohumUserBean) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",bohumUserBean);
		return cnt;
	}

	public List<BohumTestBean> selectMyChoochunBohum(BohumUserBean bohumUserBean, Paging pageInfo) {
		List<BohumTestBean> boteArr = new ArrayList<BohumTestBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		boteArr = sqlSessionTemplate.selectList(namespace+".GetBoteArr",bohumUserBean,rowBounds);
		return boteArr;
	}

	public List<BohumTestBean> selectBohumDetail(BohumTestBean bohumTestBean) {
		List<BohumTestBean> bohumDataDetailInfoArr = new ArrayList<BohumTestBean>();
		bohumDataDetailInfoArr = sqlSessionTemplate.selectList(namespace+".GetBohumDataDetailInfo",bohumTestBean);
		return bohumDataDetailInfoArr;
	}
}
