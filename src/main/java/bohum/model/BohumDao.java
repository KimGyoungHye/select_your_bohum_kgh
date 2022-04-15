package bohum.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("bohumDao")
public class BohumDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "bohum.BohumBean";

	public int insertBohum(BohumDataBean bean) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertBohum", bean);
		return cnt;
	}

	public int getTotalCount() {
		int cnt = 0;
		try {
			cnt = sqlSessionTemplate.selectOne(namespace+".GetAllTotalCount");
		}catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	}
	
	public int getTotalCount(BohumUserBean bohumUserBean) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",bohumUserBean);
		return cnt;
	}
	
	public List<BohumDataBean> selectMyChoochunBohum(Paging pageInfo) {
		List<BohumDataBean> boteArr = new ArrayList<BohumDataBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		boteArr = sqlSessionTemplate.selectList(namespace+".GetAllBoteArr",null,rowBounds);
		return boteArr;
	}

	public List<BohumDataBean> selectMyChoochunBohum(BohumUserBean bohumUserBean, Paging pageInfo) {
		List<BohumDataBean> boteArr = new ArrayList<BohumDataBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		boteArr = sqlSessionTemplate.selectList(namespace+".GetBoteArr",bohumUserBean,rowBounds);
		return boteArr;
	}
	
	

	public List<BohumDataBean> selectBohumDetail(BohumDataBean bohumTestBean) {
		List<BohumDataBean> bohumDataDetailInfoArr = new ArrayList<BohumDataBean>();
		bohumDataDetailInfoArr = sqlSessionTemplate.selectList(namespace+".GetBohumDataDetailInfo",bohumTestBean);
		return bohumDataDetailInfoArr;
	}
}
