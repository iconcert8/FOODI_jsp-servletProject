package me.foodi.domain;

public class NotifyVO {
	private int notifyNo;
	private String reqId;
	private String resId;
	private String notifyMsg;
	private String notifyDate;
	private String notifyChk;
	
	public NotifyVO() {
		super();
	}

	public NotifyVO(int notifyNo, String reqId, String resId, String notifyMsg, String notifyDate,
			String notifyChk) {
		super();
		this.notifyNo = notifyNo;
		this.reqId = reqId;
		this.resId = resId;
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
		return "NotificationVO [notifyNo=" + notifyNo + ", reqId=" + reqId + ", resId=" + resId + ", notifyMsg="
				+ notifyMsg + ", notifyDate=" + notifyDate + ", notifyChk=" + notifyChk + "]";
	}
	
	
}
