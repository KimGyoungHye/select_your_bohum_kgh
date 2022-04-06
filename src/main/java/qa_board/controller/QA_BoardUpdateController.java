package qa_board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import qa_board.model.QA_BoardBean;
import qa_board.model.QA_BoardDao;
import utility.Responsing;

@Controller
public class QA_BoardUpdateController {
	private final String command = "/update.qa";
	private String getPage = "updateForm";
	private String gotoPage = "redirect:list.qa";

	@Autowired
	QA_BoardDao qA_BoardDao;

	@Autowired
	ServletContext servletContext;

	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction(@RequestParam("no")String no,
			@RequestParam("pageNumber")String pageNumber,
			HttpServletRequest request) {

		QA_BoardBean qA_boardBean = qA_BoardDao.getArticle(no);

		System.out.println("no : "+qA_boardBean.getNo());
		request.setAttribute("QA_BoardBean", qA_boardBean);
		request.setAttribute("pageNumber", pageNumber);

		return getPage;
	}

	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doAction(@Valid QA_BoardBean qA_BoardBean,
			BindingResult result,
			@RequestParam("pageNumber")String pageNumber,
			HttpServletRequest request,
			HttpServletResponse response) {
		Responsing alerting = new Responsing(response);
		if(result.hasErrors()) {
			request.setAttribute("pageNumber", pageNumber);
			return getPage;
		}
		//alerting.useAlert("에러는 안 남");
		QA_BoardBean article2 = qA_BoardDao.getArticle(String.valueOf(qA_BoardBean.getNo()));
		if(!article2.getPassword().equals(qA_BoardBean.getPassword())) {
			alerting.useAlert("비밀번호 불일치");
			request.setAttribute("pageNumber", pageNumber);
			return getPage;
		}else {
			//alerting.useAlert("파일 업로드");
			QA_BoardBean org_qA_BoardBean = qA_BoardDao.getArticle(String.valueOf(qA_BoardBean.getNo()));
			String org_image = org_qA_BoardBean.getImage();
			String image = qA_BoardBean.getImage();
			if(image==null) {
				qA_BoardBean.setImage(org_image);
			}
			int cnt = qA_BoardDao.updateBoard(qA_BoardBean);
			if(cnt>0) {
				System.out.println("org_image"+org_image);
				System.out.println("qA_BoardBean.getImage()"+qA_BoardBean.getImage());

				if(image!=null) {
					String uploadPath = servletContext.getRealPath("/resources/qa_board/QA_BoardFiles");
					File file = new File(uploadPath+"\\"+image);
					MultipartFile multi = qA_BoardBean.getUpload();
					try {
						multi.transferTo(file);
						if(org_image!=null) {
							//파일 지우는거 빼먹음..!
							//!!!!!!!!!추가하기!!!!!!!!!!!!
						}
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					return gotoPage;
				}
			}
			request.setAttribute("pageNumber", pageNumber);
			return getPage;

		}
	}
}