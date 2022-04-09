package qa_board.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

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
public class Test {
	private final String command = "/test.qa";
	private String getPage = "test";
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	@RequestMapping(value=command,method = RequestMethod.POST)
	public void doAction(HttpServletResponse response) {

		System.out.println("일단 들어 옴");
		String path = "D:\\upload\\test.txt"; // 경로에 접근할 때 역슬래시('\') 사용

		File file = new File(path);
		response.setHeader("Content-Disposition", "attachment;filename=" + file.getName()); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더

		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(path);
			OutputStream out = response.getOutputStream();

			int read = 0;
			byte[] buffer = new byte[1024];
			while ((read = fileInputStream.read(buffer)) != -1) { // 1024바이트씩 계속 읽으면서 outputStream에 저장, -1이 나오면 더이상 읽을 파일이 없음
				out.write(buffer, 0, read);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 파일 읽어오기 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		String downloadPath = "D:\\upload";
//		String downloadFileName = "test.txt";
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
