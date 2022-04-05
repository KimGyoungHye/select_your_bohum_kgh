package member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;
import memberDetail.model.MemberDetailBean;
import utility.Responsing;

@Controller
public class MemberFindPwEmailController {
	private final String command = "/findPwEmail.mem";

	private String getPage = "findPwEmail";
	private String gotoPage = "redirect:main.isp";
	
	@Autowired
	private MemberDao memberDao;
	
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction() {

		return getPage;
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doAction(MemberBean memberBean,
			HttpSession session,
			HttpServletResponse response,
			Model model) {

		model.addAttribute("id",memberBean.getId());
		System.out.println("memberBean.getId()"+memberBean.getId());
		System.out.println("memberBean.getName()"+memberBean.getName());

		MemberBean searchBean = memberDao.getMember(memberBean.getId());

		Responsing alerting = new Responsing(response);

		if(searchBean==null) {
			alerting.useAlert("ID가 존재하지 않음");
			return getPage;
		}else {
			if(searchBean.getName().equals(memberBean.getName())) {
				if(searchBean.getEmail1()==null||searchBean.getEmail1().equals("")||searchBean.getEmail1().equals("null")
						||searchBean.getEmail2()==null||searchBean.getEmail2().equals("")||searchBean.getEmail2().equals("null")) {
					alerting.useAlert("저장된 이메일이 없습니다");
					return getPage;
				}else {
					alerting.useAlert("저장된 이메일로 비밀번호가 전송되었습니다.");
					
				}
			}else {
				alerting.useAlert("사용자 이름 불일치");
				return getPage;
			}
		}
		return getPage;
	}
}
