package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import memberDetail.model.MemberDetailDao;
import utility.Responsing;

@Controller
public class MemberLoginController {
	private final String command = "/login.mem";
	private String getPage = "loginForm";
	private String gotoPage = "redirect:main.isp";

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private MemberDetailDao memberDetailDao;

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
		System.out.println("memberBean.getPassword()"+memberBean.getPassword());

		MemberBean searchBean = memberDao.getMember(memberBean.getId());

		Responsing alerting = new Responsing(response);

		if(searchBean==null) {
			System.out.println("ID가 존재하지 않음");
			alerting.useAlert("ID가 존재하지 않음");
			return getPage;
		}else {
			if(searchBean.getPassword().equals(memberBean.getPassword())) {
				session.setAttribute("loginInfo", searchBean);

				MemberDetailBean mDetailBean = memberDetailDao.getMemberDetail(searchBean.getUserDetail());
				if(mDetailBean!=null) {
					session.setAttribute("myDetailNum", mDetailBean.getNum());
				}

				String destination = (String)session.getAttribute("destination");
				System.out.println("destination1"+destination);
				if(destination==null) {
					destination = gotoPage;
				}
				System.out.println("destination2"+destination);

				return destination; //"redirect:/insert.prd"
			}else {
				alerting.useAlert("PW 불일치");

				return getPage;

			}
		}
	}
}
