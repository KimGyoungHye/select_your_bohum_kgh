package qa_board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import qa_board.model.QA_BoardBean;
import qa_board.model.QA_BoardDao;
import utility.Responsing;

@Controller
public class QA_BoardDeleteController {
	private final String command = "/delete.qa";
	private String getPage = "deleteForm";
	private String gotoPage = "redirect:list.qa";

	@Autowired
	QA_BoardDao qA_BoardDao;

	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction(
			@RequestParam("no")String no,
			@RequestParam("pageNumber")String pageNumber,
			HttpServletRequest request) {

		request.setAttribute("no", no);
		request.setAttribute("pageNumber", pageNumber);
		return getPage;
	}

	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doAction(
			QA_BoardBean boardBean,
			@RequestParam("pageNumber") int pageNumber,
			HttpServletResponse response) {


		QA_BoardBean qa_bb=qA_BoardDao.getArticle(String.valueOf(boardBean.getNo()));
		
		Responsing responsing = new Responsing(response);
		if(qa_bb.getPassword().equals(boardBean.getPassword())) { 
			int cnt = qA_BoardDao.deleteQA_board(boardBean);
			if(cnt>0) {
				responsing.useAlert("삭제 성공");
				responsing.useRedirect("list.qa");
			}else {
				responsing.useAlert("삭제 실패");
				responsing.useRedirect("list.qa");
			}
		}
		else { 
			responsing.useAlert("비밀번호가 일치하지 않습니다");
			responsing.useHistory(-1);
		}//else
		return gotoPage;
	}
}
