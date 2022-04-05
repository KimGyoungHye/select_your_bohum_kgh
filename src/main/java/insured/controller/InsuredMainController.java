package insured.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsuredMainController {
	private final String command = "/main.isp";
	private String getPage = "main";
	
	@RequestMapping(value=command)
	public String doAction(HttpSession session) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yy");
		
		String formattedDate = dateFormat.format(date);
		
		session.setAttribute("todayYear", formattedDate );
		System.out.println("formattedDate"+formattedDate);
		return getPage;
	}
	
}
