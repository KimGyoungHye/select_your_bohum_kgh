package company.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import company.model.CompanyBean;
import company.model.CompanyDao;

@Controller
public class Company_insertController {

	private final String command = "companyInsert.cp";
	private String getPage = "company_infoInsertForm";
	private String gotoPage="redirect:/companyInfo.cp";

	
	@Autowired
	private CompanyDao cDao;
	
	@Autowired
	ServletContext servletContext;
	
	//����Ʈ���� �߰��ϱ� �̵�
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(HttpSession session) {
		
			return getPage;
		}
	//�� �Է� ��ư Ŭ��
	@RequestMapping(value=command, method=RequestMethod.POST) 
	 public ModelAndView doAction(@Valid CompanyBean bean,
			 HttpServletRequest request
			 ) {
		 ModelAndView mav = new ModelAndView();

		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String key = (String) names.nextElement();
			System.out.println("MY!!"+key + ": " + request.getParameter(key));
		}
		System.out.println("doAction.POST ����");
		System.out.println("getCname : "+bean.getCname());
		System.out.println("getCadmin : "+bean.getCadmin());
		System.out.println("getCimage : "+bean.getCimage());

		String uploadPath = servletContext.getRealPath("/resources/company/image");
		 MultipartFile multi = bean.getUpload();
		 
		 int cnt = cDao.insertCompany(bean); 
		 if(cnt > 0) {
			 System.out.println("sql�� ���� ����");
			 File f = new File(uploadPath+"\\" + bean.getCimage());
			 
			 try {
				multi.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 mav.setViewName(gotoPage);
		 }
		 else {
			 System.out.println("sql�� ���� ����. ������ �������� ���ư�");
			 mav.setViewName(getPage);
		 }
		 return mav; 
	 }
}

