package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberDao;

@Controller
public class Search_corp_number {
	private final String command="/search_corp_num.mem"; //ȸ�����Խ� ����ڵ�Ϲ�ȣ ��ȸ Ŭ��
	private String getPage="companyRegisterForm";
	private String gotoPage= "companyLoginForm"; //���߿� �����ϱ�
	
	@Autowired
	private MemberDao memberDao;

	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction(@RequestParam (value="corp_num") int corp_num) {
		
		//����ڹ�ȣ�� �Ѱܼ� ȸ����� ��������..?
		//String comp_name = memberDao.getCompanyName(corp_num);
		
		
		return getPage;
	}
	
	
}