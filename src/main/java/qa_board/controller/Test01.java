package qa_board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test01 {

	private final String command = "/test01.qa";
	private String getPage = "test";

	@Autowired
	ServletContext servletContext;

	@Autowired
	ServletConfig config;

	@RequestMapping(value=command)
	public void testfile01(HttpServletRequest request,
			HttpServletResponse response) {

		String saveFolder="resources/qa_board/QA_BoardFiles";
		String requestFolder = request.getContextPath()+"/"+saveFolder;
		String uploadFolder = config.getServletContext().getRealPath(saveFolder);

		File file01 = new File(uploadFolder,"memo01.txt");

		String fileName = "memo01.txt";
		response.setHeader("Content-Disposition", "attachment;filename=" + file01.getName()); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더

		FileInputStream fileInputStream;
		try {
			//fileInputStream = new FileInputStream(uploadFolder);
			//fileInputStream = new FileInputStream(uploadFolder+"/"+fileName);
			fileInputStream = new FileInputStream(uploadFolder+"/"+fileName);
			OutputStream out = response.getOutputStream();

			int read = 0;
			byte[] buffer = new byte[1024];
			while ((read = fileInputStream.read(buffer)) != -1) { // 1024바이트씩 계속 읽으면서 outputStream에 저장, -1이 나오면 더이상 읽을 파일이 없음
				out.write(buffer, 0, read);
				System.out.println(read);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 파일 읽어오기 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
