package member.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("memberDao")
public class MemberDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "member.MemberBean";
	
	public MemberBean getMember(String id) {
		MemberBean member = sqlSessionTemplate.selectOne(namespace+".GetMember",id);
		return member;
	}

	public MemberBean getMemberKakao(MemberBean memberBean) {
		MemberBean member = sqlSessionTemplate.selectOne(namespace+".GetMemberKakao",memberBean);
		return member;
	}

	public List<MemberBean> getMemberList(Map<String, String> map, Paging pageInfo) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<MemberBean> memberList = sqlSessionTemplate.selectList(namespace+".GetMemberList",map,rowBounds);
		return memberList;
	}

	public int getTotalCount() {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount");
		return cnt;
	}

	public int userStateUpdate(MemberBean memberBean) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UserStateUpdate",memberBean);
		return cnt;
	}

	//이름,주민번호로 id찾기
	public String getIdByNameRrn(MemberBean member) {
		String id = sqlSessionTemplate.selectOne(namespace+".GetIdByName", member);
		System.out.println("ID:"+id);
		return id;
	}
	
	public String getPwByIdNameRrn(MemberBean member) {
		String pw = sqlSessionTemplate.selectOne(namespace+".GetPwById", member);
		System.out.println("pw:" + pw);
		return pw;
	}

}
