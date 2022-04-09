package qa_board.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

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
public class Test02 {
	private final String command = "/test02.qa";
	private String getPage = "test";

	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command)
	public void doAction(HttpServletResponse response,
			HttpServletRequest request) {

//		System.out.println("일단 들어 옴");
//		String DATA_DIRECTORY = "D:\\Servlet_kgh\\select_your_bohum_kgh\\src\\main\\webapp\\resources\\qa_board\\QA_BoardFiles"; 
//		File dir = new File(DATA_DIRECTORY); 
//		String[] filenames = dir.list(); 
//		for (String filename : filenames) { 
//			System.out.println("filename : " + filename);
//		}
//		String downloadPath = servletContext.getRealPath("/WEB-INF/fileTest01");
//java.io.FileNotFoundException: D:\Servlet_kgh\select_your_bohum_kgh\src\main\webapp\resources\qa_board\QA_BoardFiles (액세스가 거부되었습니다)		
//		
//		System.out.println("downloadFilePath : "+downloadFilePath);
//		String downloadPath = servletContext.getRealPath("//WEB-INF/fileTest01");
////		java.io.FileNotFoundException: 
////		D:\Servlet_kgh\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\select_your_bohum_kgh\resources (액세스가 거부되었습니다)			
////		애는 그그그... 업로드가 실제로 되는 실제 경로!!인거!!
////		업로드시 사용이 됨!!		
		String downloadPath = request.getContextPath()+"/WEB-INF/fileTest01";
////        ex\resources\qa_board\QA_BoardFiles (지정된 경로를 찾을 수 없습니다)
////		내가 생각하는 request를 이용한 파일을 찾아가는 방법인데...
////		src에서의 경로와 컨트롤러상의 경로가 다른것인가..?
//
//		
//		// 절대 주소로 가져와야 할까요????????????????????????
//		
//		downloadPath = "D:\\Servlet_kgh\\select_your_bohum_kgh\\src\\main\\webapp\\resources\\qa_board\\QA_BoardFiles";
		
		//System.out.println("request.getContextPath() : "+request.getContextPath());
		System.out.println("servletContext.getRealPath(\"/resources\")"+servletContext.getRealPath("/resources"));
		String downloadFileName = "memo.txt";
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
//		String path = "D:\\upload\\test.txt"; 
//
//		File file = new File(path);
//		response.setHeader("Content-Disposition", "attachment;filename=" + file.getName()); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
//
//		FileInputStream fileInputStream;
//		try {
//			fileInputStream = new FileInputStream(path);
//			OutputStream out = response.getOutputStream();
//
//			int read = 0;
//			byte[] buffer = new byte[1024];
//			while ((read = fileInputStream.read(buffer)) != -1) { // 1024바이트씩 계속 읽으면서 outputStream에 저장, -1이 나오면 더이상 읽을 파일이 없음
//				out.write(buffer, 0, read);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // 파일 읽어오기 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		//java.io.FileNotFoundException: 
//		//(액세스가 거부되었습니다)
//		String downloadPath = "D:\\upload";
//		String downloadFileName = "test02.txt";
//		File file = new File(downloadPath+"//"+downloadFileName);
//		response.setHeader("Content-Disposition", "attachment;filename=" + file.getName()); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
//
//		FileInputStream fileInputStream;
//		try {
//			fileInputStream = new FileInputStream(downloadPath);
//			OutputStream out = response.getOutputStream();
//
//			int read = 0;
//			byte[] buffer = new byte[1024];
//			while ((read = fileInputStream.read(buffer)) != -1) { // 1024바이트씩 계속 읽으면서 outputStream에 저장, -1이 나오면 더이상 읽을 파일이 없음
//				out.write(buffer, 0, read);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
