package bohum.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bohum.model.BohumDetail;
import bohum.test.BohumTestBean;
import member.model.MemberBean;
import utility.Responsing;


@Controller
public class BohumDetailController {
	private final String command = "/bohumDetail.bh";
	private String getPage = "/bohumInfo";
	
	@RequestMapping(value=command)
	public String doAction(
			HttpServletRequest request,
			HttpSession session) {
		BohumDetail bohumDetail = new BohumDetail();
		ArrayList<BohumTestBean> bohumTestInfoArr = bohumDetail.getHohumDetail("한화손보", "무배당 참 편한 실손의료보험(간편고지, 갱신형)2204", "27");
		//한화 손보는 cinfo에서 무배당~은  insu에서 27은 loginInfo에서 추춮!!
		
		request.setAttribute("bohumTestInfoArr",bohumTestInfoArr);
		
		return getPage;
	
	}
}
