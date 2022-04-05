package company.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import company.model.CompanyBean;
import company.model.CompanyDao;
import member.model.MemberDao;

@Controller
public class Search_corp_number {
	private final String command="/search_corp_num.cp"; //ȸ�����Խ� ����ڵ�Ϲ�ȣ ��ȸ Ŭ��
	private String gotoPage= "redirect:companyRegister.mem"; //���߿� �����ϱ�
	
	
	@Autowired
	private CompanyDao companyDao;

	@RequestMapping(value=command)
	public String doAction(@RequestParam (value="cnum") int cnum, HttpSession session) {
		
		//����ڹ�ȣ�� �Ѱܼ� ȸ����� ��������..?
		CompanyBean companyBean = companyDao.getCompany(cnum);
		System.out.println("cname:" + companyBean.getCname());
		
		session.setAttribute("cname", companyBean.getCname());
		session.setAttribute("cnum", companyBean.getCnum());
		
		return gotoPage;
	}
	
	
}
