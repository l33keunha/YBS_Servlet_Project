package board.model.vo;

import java.sql.Date;

public class BoardVO {
	private int bNo;
	private String name;
	private String title;
	private String content;
	private Date writtenDate;
	private Date updateDate;
	private Date deleteDate;
	private int cateNo;
	private int cnt;
	private String mainStatus;
	private int likeCnt;
	private String status;
	
	public BoardVO() {}

	public BoardVO(int bNo, String name, String title, String content, Date writtenDate, Date updateDate, Date deleteDate,
			int cateNo, int cnt, String mainStatus, int likeCnt, String status) {
		super();
		this.bNo = bNo;
		this.name = name;
		this.title = title;
		this.content = content;
		this.writtenDate = writtenDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
		this.cateNo = cateNo;
		this.cnt = cnt;
		this.mainStatus = mainStatus;
		this.likeCnt = likeCnt;
		this.status = status;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public String getMainStatus() {
		return mainStatus;
	}

	public void setMainStatus(String mainStatus) {
		this.mainStatus = mainStatus;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BoardVO [bNo=" + bNo + ", name=" + name + ", title=" + title + ", content=" + content + ", writtenDate="
				+ writtenDate + ", updateDate=" + updateDate + ", deleteDate=" + deleteDate + ", cateNo=" + cateNo + ", cnt=" + cnt
				+ ", mainStatus=" + mainStatus + ", likeCnt=" + likeCnt + ", status=" + status + "]";
	}
	
}
