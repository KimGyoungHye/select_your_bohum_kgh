package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class Find_pw_Controller {
	private final String command = "/findpw.mem";
	private String getPage = "findpw";
	private String gotoPage = "redirect:/companyLogin.mem";
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction1() {
		
		return getPage;
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView doAction(MemberBean member) {
		
		String pw = memberDao.getPwByIdNameRrn(member); 
		System.out.println("searchPw:" + pw);
		
		ModelAndView mav = new ModelAndView();
	
		mav.addObject("pw", pw);
		mav.setViewName(getPage);
		return mav;
	}
	
}
