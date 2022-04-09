package qa_board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import qa_board.model.QA_BoardBean;
import qa_board.model.QA_BoardDao;
import utility.Responsing;

@Controller
public class QA_BoardDownloadController {
	private final String command = "/download.qa";
	@Autowired
	QA_BoardDao qA_BoardDao;
	
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value=command,method = RequestMethod.GET)
	public void doAction(HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam("downloadFileName")String downloadFileName,
			@RequestParam("downloadFilePath")String downloadFilePath
			) {

			System.out.println("downloadFilePath : "+downloadFilePath);
//			String downloadPath = servletContext.getRealPath("/resources");
//			java.io.FileNotFoundException: 
//			D:\Servlet_kgh\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\select_your_bohum_kgh\resources (액세스가 거부되었습니다)			
//			애는 그그그... 업로드가 실제로 되는 실제 경로!!인거!!
//			업로드시 사용이 됨!!		
			String downloadPath = request.getContextPath()+"/resources/qa_board/QA_BoardFiles";
//	        ex\resources\qa_board\QA_BoardFiles (지정된 경로를 찾을 수 없습니다)
//			내가 생각하는 request를 이용한 파일을 찾아가는 방법인데...
//			src에서의 경로와 컨트롤러상의 경로가 다른것인가..?

			// 웹서버 경로로.............  
			// 절대 주소로 가져와야 할까요????????????????????????
			
			downloadPath = "D:\\Servlet_kgh\\select_your_bohum_kgh\\src\\main\\webapp\\resources\\qa_board\\QA_BoardFiles";
			
			System.out.println("request.getContextPath() : "+request.getContextPath());
			System.out.println("servletContext.getRealPath(\"/resources\")"+servletContext.getRealPath("/resources"));
			downloadFileName = "memo.txt";
	        	File file = new File(downloadPath+"//"+downloadFileName);
	        	response.setHeader("Content-Disposition", "attachment;filename=" + file.getName()); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
	        	
	        	FileInputStream fileInputStream;
				try {
					fileInputStream = new FileInputStream(downloadPath);
					OutputStream out = response.getOutputStream();
		        	
		        	int read = 0;
		                byte[] buffer = new byte[1024];
		                while ((read = fileInputStream.read(buffer)) != -1) { // 1024바이트씩 계속 읽으면서 outputStream에 저장, -1이 나오면 더이상 읽을 파일이 없음
		                    out.write(buffer, 0, read);
		                }
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	      
		
	}

}