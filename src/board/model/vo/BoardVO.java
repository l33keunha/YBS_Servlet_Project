package board.model.vo;

public class BoardVO {
	private int bNo;
	private String name;
	private String title;
	private String content;
	private int writtenDate;
	private int updateDate;
	private int deleteDate;
	private int cateNo;
	private String mainStatus;
	private int likeCnt;
	private String status;
	
	public BoardVO() {}

	public BoardVO(int bNo, String name, String title, String content, int writtenDate, int updateDate, int deleteDate,
			int cateNo, String mainStatus, int likeCnt, String status) {
		super();
		this.bNo = bNo;
		this.name = name;
		this.title = title;
		this.content = content;
		this.writtenDate = writtenDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
		this.cateNo = cateNo;
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

	public int getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(int writtenDate) {
		this.writtenDate = writtenDate;
	}

	public int getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(int updateDate) {
		this.updateDate = updateDate;
	}

	public int getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(int deleteDate) {
		this.deleteDate = deleteDate;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
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
				+ writtenDate + ", updateDate=" + updateDate + ", deleteDate=" + deleteDate + ", cateNo=" + cateNo
				+ ", mainStatus=" + mainStatus + ", likeCnt=" + likeCnt + ", status=" + status + "]";
	}
	
}
