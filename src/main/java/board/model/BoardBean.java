package board.model;

import org.springframework.web.multipart.MultipartFile;

public class BoardBean {
		private int bnum;
		private String btitle;
		private String bcontents;
		private String bimage;
		private String bdate;
		private MultipartFile upload;
		public BoardBean() {
			super();
		}
		public BoardBean(int bnum, String btitle, String bcontents, String bimage, String bdate, MultipartFile upload) {
			super();
			this.bnum = bnum;
			this.btitle = btitle;
			this.bcontents = bcontents;
			this.bimage = bimage;
			this.bdate = bdate;
			this.upload = upload;
		}
		public int getBnum() {
			return bnum;
		}
		public void setBnum(int bnum) {
			this.bnum = bnum;
		}
		public String getBtitle() {
			return btitle;
		}
		public void setBtitle(String btitle) {
			this.btitle = btitle;
		}
		public String getBcontents() {
			return bcontents;
		}
		public void setBcontents(String bcontents) {
			this.bcontents = bcontents;
		}
		public String getBimage() {
			return bimage;
		}
		public void setBimage(String bimage) {
			this.bimage = bimage;
		}
		public String getBdate() {
			return bdate;
		}
		public void setBdate(String bdate) {
			this.bdate = bdate;
		}
		public MultipartFile getUpload() {
			return upload;
		}
		public void setUpload(MultipartFile upload) {
			this.upload = upload;
		}
}
