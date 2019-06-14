package me.foodi.domain;

public class ChatVO {
	private int chatNo;
	private String chatMsg;
	private String chatDate;
	private String chatChk;
	private String chatDel;
	private String chatFile;
	private String reqId;
	private String resId;

	
	
	public ChatVO() {
		super();
	}

	public ChatVO(int chatNo, String chatMsg, String chatDate, String chatChk, String chatDel, String chatFile,
			String reqId, String resId) {

		super();
		this.chatNo = chatNo;
		this.chatMsg = chatMsg;
		this.chatDate = chatDate;
		this.chatChk = chatChk;
		this.chatDel = chatDel;
		this.chatFile = chatFile;
		this.reqId = reqId;
		this.resId = resId;

	}

	public int getChatNo() {
		return chatNo;
	}

	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}

	public String getChatMsg() {
		return chatMsg;
	}

	public void setChatMsg(String chatMsg) {
		this.chatMsg = chatMsg;
	}

	public String getChatDate() {
		return chatDate;
	}

	public void setChatDate(String chatDate) {
		this.chatDate = chatDate;
	}

	public String getChatChk() {
		return chatChk;
	}

	public void setChatChk(String chatChk) {
		this.chatChk = chatChk;
	}

	public String getChatDel() {
		return chatDel;
	}

	public void setChatDel(String chatDel) {
		this.chatDel = chatDel;
	}

	public String getChatFile() {
		return chatFile;
	}

	public void setChatFile(String chatFile) {
		this.chatFile = chatFile;
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

	@Override
	public String toString() {
		return "ChatVO [chatNo=" + chatNo + ", chatMsg=" + chatMsg + ", chatDate=" + chatDate + ", chatChk=" + chatChk
				+ ", chatDel=" + chatDel + ", chatFile=" + chatFile + ", reqId=" + reqId + ", resId=" + resId + "]";

	}

}
