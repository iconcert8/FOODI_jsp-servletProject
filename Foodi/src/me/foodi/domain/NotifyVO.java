package me.foodi.domain;

public class NotifyVO {
	private int notifyNo;
	private int feedNo;
	private String reqId;
	private String resId;
	private String notifyType;
	private String notifyMsg;
	private String notifyDate;
	private String notifyChk;
	
	public NotifyVO() {
		super();
	}

	public NotifyVO(int notifyNo, int feedNo, String reqId, String resId, String notifyType, String notifyMsg,
			String notifyDate, String notifyChk) {
		super();
		this.notifyNo = notifyNo;
		this.feedNo = feedNo;
		this.reqId = reqId;
		this.resId = resId;
		this.notifyType = notifyType;
		this.notifyMsg = notifyMsg;
		this.notifyDate = notifyDate;
		this.notifyChk = notifyChk;
	}


	public int getNotifyNo() {
		return notifyNo;
	}

	public void setNotifyNo(int notifyNo) {
		this.notifyNo = notifyNo;
	}

	public int getFeedNo() {
		return feedNo;
	}

	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getNotifyType() {
		return notifyType;
	}

	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}

	public String getNotifyMsg() {
		return notifyMsg;
	}

	public void setNotifyMsg(String notifyMsg) {
		this.notifyMsg = notifyMsg;
	}

	public String getNotifyDate() {
		return notifyDate;
	}

	public void setNotifyDate(String notifyDate) {
		this.notifyDate = notifyDate;
	}

	public String getNotifyChk() {
		return notifyChk;
	}

	public void setNotifyChk(String notifyChk) {
		this.notifyChk = notifyChk;
	}

	@Override
	public String toString() {
		return "NotifyVO [notifyNo=" + notifyNo + ", feedNo=" + feedNo + ", reqId=" + reqId + ", resId=" + resId
				+ ", notifyType=" + notifyType + ", notifyMsg=" + notifyMsg + ", notifyDate=" + notifyDate
				+ ", notifyChk=" + notifyChk + "]";
	}

	
	
	
}
