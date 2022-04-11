package bohum.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bohum.model.BohumDao;
import bohum.model.BohumDetail;
import bohum.test.BohumTestBean;
import member.model.MemberBean;
import utility.Responsing;


@Controller
public class BohumDataJujangController {
	private final String command = "/bohumJujang.bh";
	private String getPage = "/bohumJujang";
	
	@Autowired
	BohumDao bohumDao;
	
	@RequestMapping(value=command)
	public String doAction(
			HttpServletRequest request,
			HttpSession session) {
		BohumDetail bohumDetail = new BohumDetail();
		ArrayList<BohumTestBean> bohumTestInfoArr = new ArrayList<BohumTestBean>();
		int count = 0;
		for(int j=1;j<102;j=j+10) {
			bohumTestInfoArr = bohumDetail.getHohumDetail(String.valueOf(j));
			System.out.println("j"+j);
			//한화 손보는 cinfo에서 무배당~은  insu에서 27은 loginInfo에서 추춮!!
			for(int i=0;i<bohumTestInfoArr.size();i++) {
				BohumTestBean bohumTestBean = bohumTestInfoArr.get(i);
				System.out.println("getFmlInsRt ! "+bohumTestBean.getFmlInsRt()+"!!");
					if(!(bohumTestBean.getFmlInsRt().equals("0")&&bohumTestBean.getMlInsRt().equals("0"))
						&&(!bohumTestBean.getCmpyNm().equals("null")&&bohumTestBean.getCmpyNm()!=null)) {
						int cnt = bohumDao.insertBohum(bohumTestBean);
						if(cnt>0) {
							System.out.println("보험 정상 입력");
							count++;
						}
					}
				}
		}
		System.out.println("저장 갯수 : "+count);
		request.setAttribute("bohumTestInfoArr",bohumTestInfoArr);
		return getPage;
	}
}
