package member.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;
import utility.Responsing;

@Controller
public class MemberUserStateUpdateController {
	private final String command = "/userStateUpdate.mem";
	private String getPage = "redirect:memberList.mem";
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value=command)
	public String doAction(MemberBean memberBean,
			HttpServletResponse response) {
		int cnt = memberDao.userStateUpdate(memberBean);
		Responsing responsing = new Responsing(response);
		if(cnt>0) {
			responsing.useAlert("수정 성공");			
			responsing.useRedirect("memberList.mem");
		}else {
			responsing.useAlert("수정 실패");
			responsing.useRedirect("memberList.mem");
		}
		responsing.useRedirect("memberList.mem");
		return getPage;
	}
}
