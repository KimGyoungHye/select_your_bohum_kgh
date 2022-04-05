package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberDao;
import memberDetail.model.MemberDetailBean;
import memberDetail.model.MemberDetailDao;
import utility.Responsing;

@Controller
public class MemberKakaoTestController {
	private final String command = "/kakaoLogin.mem";

	private String getPage = "loginForm";
	private String gotoPage = "redirect:main.isp";
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberDetailDao memberDetailDao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction() {
		
		return "testKakao";
	}

	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doAction(@RequestParam(value = "userinfo", required = false)String userinfo,
			HttpSession session,
			HttpServletResponse response) {
		
		Responsing alerting = new Responsing(response);
		System.out.println("####kakaoInfo####\n" + userinfo);
		//alerting.useAlert(userinfo);
		String emailKey = "\"email\":\"";
		String genderKey = "\",\"has_gender\":";
		int index_emailKey = userinfo.indexOf(emailKey);
		int index_genderKey = userinfo.indexOf(genderKey);
		String userEmail = userinfo.substring(index_emailKey+emailKey.length(),index_genderKey);
		System.out.println("userEmail : "+userEmail);
		//이거는 데이터 처리하는거 한번 다시 해보는게 좋을 것 같음
		String email1 = userEmail.substring(0,userEmail.indexOf("@"));
		String email2 = userEmail.substring(userEmail.indexOf("@")+1,userEmail.length());
		
		System.out.println(email1+"/"+email2);
		
		MemberBean memberBean = new MemberBean();
		memberBean.setEmail1(email1);
		memberBean.setEmail2(email2);
		
		MemberBean searchBean = memberDao.getMemberKakao(memberBean);
		
		if(searchBean==null) {
			alerting.useAlert("등록된 이메일이 없습니다");
			return getPage;
		}else{
			session.setAttribute("loginInfo", searchBean);

			MemberDetailBean mDetailBean = memberDetailDao.getMemberDetail(searchBean.getUserDetail());
			if(mDetailBean!=null) {
				session.setAttribute("myDetailNum", mDetailBean.getNum());
			}
			String destination = (String)session.getAttribute("destination");
			System.out.println("destination1"+destination);
			if(destination==null) {
				destination = gotoPage;
			}
			System.out.println("destination2"+destination);

			return destination; //"redirect:/insert.prd"
		}
		/*{"has_email":true,"email_needs_agreement":
		 * false,"is_email_valid":true,"is_email_verified":true,
		 * "email":"kimgyhye@naver.com","has_gender":true,"gender_needs_agreement":true,"host":"kakao"}
		 */

	}
	
}
