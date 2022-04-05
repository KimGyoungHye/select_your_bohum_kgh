package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberDao;

@Controller
public class Search_corp_number {
	private final String command="/search_corp_num.mem"; //회원가입시 사업자등록번호 조회 클릭
	private String getPage="companyRegisterForm";
	private String gotoPage= "companyLoginForm"; //나중에 수정하기
	
	@Autowired
	private MemberDao memberDao;

	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction(@RequestParam (value="corp_num") int corp_num) {
		
		//사업자번호를 넘겨서 회사명을 가져오기..?
		//String comp_name = memberDao.getCompanyName(corp_num);
		
		
		return getPage;
	}
	
	
}