package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberDao;
import memberDetail.model.MemberDetailBean;
import memberDetail.model.MemberDetailDao;
import utility.Responsing;
import utility.Paging;

@Controller
public class MemberListController {
	private final String command = "/memberList.mem";
	private String getPage = "/admin/memberList";
	private String loginPage = "redirect:login.mem";
	private String mainPage = "redirect:main.isp";

	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value=command)
	public String doAction(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response) {
		MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
		if(loginInfo==null) {
			session.setAttribute("destination", "redirect:/memberList.mem");
			return loginPage;
		}
		Responsing alerting = new Responsing(response);
		Map<String, String> map = new HashMap<String, String>();
		if(!loginInfo.getUserState().equals("관리자")) {
			alerting.useAlert("권한이 없습니다");
			alerting.useRedirect("main.isp");
		}
		if(whatColumn!=null) {
			map.put("whatColumn", whatColumn);
			map.put("keyword", "%"+keyword.toUpperCase()+"%");
			System.out.println("keyword:"+"%"+keyword.toUpperCase()+"%");
		}
		int totalCount = memberDao.getTotalCount();
		String url = request.getContextPath()+command;
		Paging pageInfo = new Paging(pageNumber, "5", totalCount, url, whatColumn, keyword, null);

		List<MemberBean> memberList = new ArrayList<MemberBean>();
		memberList = memberDao.getMemberList(map,pageInfo);
		
		request.setAttribute("whatColumn", whatColumn);
		request.setAttribute("keyword", keyword);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("memberList", memberList);
		request.setAttribute("pageInfo", pageInfo);
		
		return getPage;
	}
}
