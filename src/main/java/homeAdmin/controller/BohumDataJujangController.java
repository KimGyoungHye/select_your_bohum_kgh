package homeAdmin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bohum.model.BohumDao;
import bohum.model.BohumDataBean;
import bohum.model.BohumDetail;
import utility.Paging;
import utility.UserKindClassify;


@Controller
public class BohumDataJujangController {
	private final String command = "/bohumJujang.ha";
	private String getPage = "/bohum/bohumJujang";

	@Autowired
	BohumDao bohumDao;

	@RequestMapping(value=command)
	public String doAction(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,

			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) {

		//관리자 구분
		UserKindClassify classify = new UserKindClassify();
		classify.areYouAdmin(session, response, "redirect:bohumJujang.ha");

		int totalCount = bohumDao.getTotalCount();

		if(totalCount==0) {

			BohumDetail bohumDetail = new BohumDetail();
			ArrayList<BohumDataBean> bohumTestInfoArr = new ArrayList<BohumDataBean>();
			int count = 0;
			bohumTestInfoArr = bohumDetail.getHohumDetail(String.valueOf(1));
			for(int j=10;j<101;j=j+10) {
				bohumTestInfoArr = bohumDetail.getHohumDetail(String.valueOf(j));
				System.out.println("j"+j);
				//한화 손보는 cinfo에서 무배당~은  insu에서 27은 loginInfo에서 추춮!!
				for(int i=0;i<bohumTestInfoArr.size();i++) {
					BohumDataBean bohumTestBean = bohumTestInfoArr.get(i);
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
		}

		System.out.println("totalCount:"+totalCount);
		String url = request.getContextPath()+command;
		Paging pageInfo = new Paging(pageNumber, "5", totalCount, url, whatColumn, keyword, null);
		List<BohumDataBean> bohumJujangInfoArr = new ArrayList<BohumDataBean>();

		bohumJujangInfoArr = bohumDao.selectMyChoochunBohum(pageInfo);

		request.setAttribute("whatColumn", whatColumn);
		request.setAttribute("keyword", keyword);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("bohumJujangInfoArr",bohumJujangInfoArr);
		return getPage;
	}
}
