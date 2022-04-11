package bohum.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bohum.model.BohumDao;
import bohum.model.BohumDetail;
import bohum.model.BohumUserBean;
import bohum.test.BohumTestBean;
import member.model.MemberBean;
import memberDetail.model.MemberDetailBean;
import memberDetail.model.MemberDetailDao;
import utility.Paging;
import utility.Responsing;


@Controller
public class BohumMyChoochunController {
	private final String command = "/bohumChoochun.bh";
	private String getPage = "/bohumChoochun";
	private String loginPage = "redirect:/login.mem";

	@Autowired
	BohumDao bohumDao;
	
	@Autowired
	MemberDetailDao memberDetailDao;
	
	@RequestMapping(value=command)
	public String doAction(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) {
		
		Responsing responsing = new Responsing(response);
		BohumDetail bohumDetail = new BohumDetail();
		List<BohumTestBean> bohumTestInfoArr = new ArrayList<BohumTestBean>();
		//한화 손보는 cinfo에서 무배당~은  insu에서 27은 loginInfo에서 추춮!!
		
		MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
		if(loginInfo==null) {
			session.setAttribute("destination", "redirect:/bohumChoochun.bh");
			return loginPage;
		}
		MemberDetailBean mDetailBean = memberDetailDao.getMemberDetail(loginInfo.getUserDetail());
		if(mDetailBean!=null) {
			session.setAttribute("myDetailNum", mDetailBean.getNum());
		}else {
			responsing.useConfirm("유저 세부 정보를 등록해야 이용 가능합니다.\n정보를 등록하시겠습니까?","myPage.mem");
			
		}
		Map<String, String> map = new HashMap<String, String>();
		if(whatColumn!=null) {
			map.put("whatColumn", whatColumn);
			map.put("keyword", "%"+keyword.toUpperCase()+"%");
			System.out.println("keyword:"+"%"+keyword.toUpperCase()+"%");
		}
		//내 정보에서 뽑을 것 - age, gender-성별, 유병자인지 4대보험인지, 
		// 지금 내 디테일 정보에서 그그그그그그 뭐냐 지병
		// disease가 null이 아니면 유병자 보험 추천
		// 아니면 그냥 4세대 실손 의료 보험
		int age = mDetailBean.getAge();
		String gender = mDetailBean.getGender();
		String disease = mDetailBean.getDisease();
		int salary = mDetailBean.getSalary();
		
		
		BohumUserBean bohumUserBean = new BohumUserBean(age, gender, disease, salary, map);
		bohumUserBean.setAge(31);

		System.out.println("bohumUserBean.age : "+bohumUserBean.getAge());
		//
		int totalCount = bohumDao.getTotalCount(bohumUserBean);
		
		String url = request.getContextPath()+command;
		Paging pageInfo = new Paging(pageNumber, "5", totalCount, url, whatColumn, keyword, null);

		bohumTestInfoArr = bohumDao.selectMyChoochunBohum(bohumUserBean,pageInfo);
		
		System.out.println("totalCount : "+totalCount);
		System.out.println("bohumTestInfoArr : "+bohumTestInfoArr.size());
		
		request.setAttribute("bohumUserBean",bohumUserBean);
		request.setAttribute("bohumTestInfoArr",bohumTestInfoArr);
		request.setAttribute("pageInfo",pageInfo);
		
		return getPage;
	
	}
}
