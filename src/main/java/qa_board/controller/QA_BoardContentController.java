package qa_board.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import qa_board.model.QA_BoardBean;
import qa_board.model.QA_BoardDao;

@Controller
public class QA_BoardContentController {
	private final String command = "/content.qa";
	private String getPage = "content";
	private String gotoPage = "redirect:list.qa";

	@Autowired
	QA_BoardDao qA_BoardDao;

	@RequestMapping(value=command)
	public String doAction(@RequestParam("no")String no,
			@RequestParam("pageNumber")String pageNumber,
			HttpServletRequest request) {

		int cnt1 = qA_BoardDao.updateQA_BoardCount(no);
		if(cnt1>0) {
			QA_BoardBean qA_BoardBean = qA_BoardDao.getArticle(no);

			System.out.println("article.getNum()"+qA_BoardBean.getNo());
			request.setAttribute("qA_BoardBean", qA_BoardBean);
			request.setAttribute("pageNumber", pageNumber);

			return getPage;

		}else {
			return gotoPage;
		}
	}

}
