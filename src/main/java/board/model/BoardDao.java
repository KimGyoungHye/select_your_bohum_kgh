package board.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("boardDao")
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "board.BoardBean";

	public int getTotalCount() {
		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount");
		return cnt;
	}
}
