package utility;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Responsing {
	private HttpServletResponse response;
	private PrintWriter out;
	public Responsing(HttpServletResponse response) {
		super();
		this.response = response;
	}
	public void useAlert(String alertContent) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			out.println("<script>alert('"+alertContent+"');</script>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void useRedirect(String redirectUrl) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			out.println("<script>location.href='"+redirectUrl+"';</script>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean useConfirm(String confirmContent,String gotoPage) {
		boolean confirmFlag = false;
		try {
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			out.println("<script>"
					+ "var confirmFlag = confirm('"+confirmContent+"');"
					+ "if(confirmFlag==true){"
					+ "alert('true');"
					+ "location.href='"+gotoPage+"'"
					+ "}else{"
					+ "alert('이전페이지로 돌아갑니다');"
					+ "history.go(-1);"
					+ "}"
					+ "</script>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return confirmFlag;
	}
	
	public void useHistory(int historyNum) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			out.println("<script>history.go("+historyNum+");</script>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
