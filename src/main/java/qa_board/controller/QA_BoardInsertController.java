package qa_board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import company.model.CompanyBean;
import company.model.CompanyDao;
import member.model.MemberBean;
import qa_board.model.QA_BoardBean;
import qa_board.model.QA_BoardDao;
import utility.Paging;

@Controller
public class QA_BoardInsertController {
	private final String command = "/insert.qa";
	private String getPage = "insertForm";
	private String gotoPage = "redirect:list.qa";
	private String loginPage = "redirect:/login.mem";

	@Autowired
	QA_BoardDao qA_BoardDao;
	
	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction(HttpServletRequest request) {
		getLists(request);
		return getPage;
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doAction(@Valid QA_BoardBean qA_BoardBean,
			BindingResult result,
			HttpServletRequest request,
			HttpSession session) {
		System.out.println(qA_BoardBean.getPassword());
		MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
		if(loginInfo==null) {
			session.setAttribute("destination", "redirect:/insert.qa");
			return loginPage;
		}
		getLists(request);
		
		if(result.hasErrors()) {
			return getPage;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp reg_date = Timestamp.valueOf(simpleDateFormat.format(System.currentTimeMillis()));
		System.out.println("reg_date : "+reg_date);
		String ip = request.getRemoteAddr();
		qA_BoardBean.setReg_date(String.valueOf(reg_date));
		qA_BoardBean.setIp(ip);
		
		String image = qA_BoardBean.getImage();
		if(image!=null) {
			int cnt = qA_BoardDao.insertQA_Board(qA_BoardBean);
			if(cnt>0) {
				String uploadPath = servletContext.getRealPath("/resources/qa_board/QA_BoardFiles");
				File file = new File(uploadPath+"\\"+image);
				MultipartFile multi = qA_BoardBean.getUpload();
				try {
					multi.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return gotoPage;
	}

	public void getLists(HttpServletRequest request) {
		List<CompanyBean> companyList = new ArrayList<CompanyBean>();
		companyList = companyDao.getCompanyList();
		request.setAttribute("companyList", companyList);
	}
}
