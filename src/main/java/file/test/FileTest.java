package file.test;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		String DATA_DIRECTORY = "D:/upload/"; 
		File dir = new File(DATA_DIRECTORY); 
		String[] filenames = dir.list(); 
		for (String filename : filenames) { 
			System.out.println("filename : " + filename);
		}
		String DATA_DIRECTORY2 = "D:/Servlet_kgh/"; 
		File dir2 = new File(DATA_DIRECTORY2); 
		String[] filenames2 = dir2.list(); 
		for (String filename2 : filenames2) { 
			System.out.println("filename2 : " + filename2);
		}
	}
}
