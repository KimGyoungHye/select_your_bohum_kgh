package qa_board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import qa_board.model.QA_BoardBean;
import qa_board.model.QA_BoardDao;
import utility.Paging;

@Controller
public class QA_BoardListController {
	private final String command = "/list.qa";
	private String getPage = "boardList";
	private String loginPage = "redirect:/login.mem";
	
	@Autowired
	QA_BoardDao qandADao;
	
	@RequestMapping(value=command)
	public String doAction(@RequestParam(value="pageNumber",required = false) String pageNumber,
			HttpServletRequest request,
			HttpSession session) {

		MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
		if(loginInfo==null) {
			session.setAttribute("destination", "redirect:/list.qa");
			return loginPage;
		}
		int totalCount = qandADao.getTotalCount(loginInfo);

		String url = request.getContextPath()+command;
		System.out.println("url:" + url);
		//여기서 /가 없으면 안됨

		Paging pageInfo = new Paging(pageNumber, "5", totalCount, url, null, null, null);
		System.out.println("offset:" + pageInfo.getOffset());
		System.out.println("limit:" + pageInfo.getLimit());

		List<QA_BoardBean> boardList = qandADao.getQandAList(loginInfo,pageInfo);
		
		System.out.println("boardList.size()"+boardList.size());
		
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("boardList", boardList);

		return getPage;
	}

}
