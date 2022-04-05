package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class Find_id_Controller {
	private final String command = "/findid.mem";
	private String getPage = "findid";
	private String gotoPage = "redirect:/companyLogin.mem";
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction1() {
		
		return getPage;
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView doAction(MemberBean member) {
		
		System.out.println("member.getName() : "+member.getName());
		System.out.println("member.getRegi_number1() : "+member.getRegi_number1());
		System.out.println("member.getRegi_number2() : "+member.getRegi_number2());
		
		String id = memberDao.getIdByNameRrn(member);  
		System.out.println("searchId:" + id);
		
		ModelAndView mav = new ModelAndView();
	
		mav.addObject("id", id);
		mav.setViewName(getPage);
		return mav;
	}
	
}
