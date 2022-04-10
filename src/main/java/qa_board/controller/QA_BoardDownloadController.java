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
	private String getPage = "test";

	@Autowired
	QA_BoardDao qA_BoardDao;

	@Autowired
	ServletContext servletContext;

	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction(HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam("downloadFileName")String downloadFileName,
			@RequestParam("downloadFilePath")String downloadFilePath
			) {

		String downloadPath = request.getContextPath()+"/resources/qa_board/QA_BoardFiles";
		downloadPath = "D:\\Servlet_kgh\\select_your_bohum_kgh\\src\\main\\webapp\\resources\\qa_board\\QA_BoardFiles";

		System.out.println("request.getContextPath() : "+request.getContextPath());
		System.out.println("servletContext.getRealPath(\"/resources\")"+servletContext.getRealPath("/resources"));
		downloadFileName = "memo.txt";
		File file = new File(downloadPath+"//"+downloadFileName);
		response.setHeader("Content-Disposition", "attachment;filename=" + file.getName()); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더

		FileInputStream fileInputStream;
		try {
			System.out.println("try: in");
			fileInputStream = new FileInputStream(downloadPath+"//"+downloadFileName);
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

		return getPage;

	}

}