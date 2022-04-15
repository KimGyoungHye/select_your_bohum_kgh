package graph.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("graphDao")
public class GraphDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	private String namespace = "graph.GraphBean";

	public List<GraphBean> GetGraphDataAgeNBohum() {
		List<GraphBean> graphDataAgeNBohum = new ArrayList<GraphBean>();
			graphDataAgeNBohum = sqlSessionTemplate.selectList(namespace+".GetGraphDataAgeNBohum");
		
		System.out.println("DAO : graphDataAgeNBohum.size()"+graphDataAgeNBohum.size());
		return graphDataAgeNBohum;
	}

}
