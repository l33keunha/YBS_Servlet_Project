package board.model.vo;

public class Attachment {
	private int bNo;
	private int imgNo;
	private String originname;
	private String rename;
	private String imgpath;
	private String thumbnailstatus;
	
	public Attachment() {}
	
	public Attachment(int bNo, int imgNo, String originname,String rename, String imgpath, String thumbnailstatus) {
		super();
		this.bNo = bNo;
		this.imgNo = imgNo;
		this.originname = originname;
		this.rename = rename;
		this.imgpath = imgpath;
		this.thumbnailstatus = thumbnailstatus;
	}
	
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public int getImgNo() {
		return imgNo;
	}
	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}
	public String getOriginname() {
		return originname;
	}
	public void setOriginname(String originname) {
		this.originname = originname;
	}
	public String getRename() {
		return rename;
	}
	public void setRename(String rename) {
		this.rename = rename;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getThumbnailstatus() {
		return thumbnailstatus;
	}
	public void setThumbnailstatus(String thumbnailstatus) {
		this.thumbnailstatus = thumbnailstatus;
	}
	
	@Override
	public String toString() {
		return "Attachment [bNo=" + bNo + ", imgNo=" + imgNo + ", originname=" + originname + ", rename=" + rename
				+ ", imgpath=" + imgpath + ", thumbnailstatus=" + thumbnailstatus + "]";
	}
	
	
}
