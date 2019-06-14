package me.foodi.domain;

public class ChatVO {
	private int chatNo;
	private String chatMsg;
	private String chatDate;
	private String chatChk;
	private String chatDel;
	private String chatFile;
	private String reqUserId;
	private String resUserId;
	
	
	
	public ChatVO() {
		super();
	}
	public ChatVO(int chatNo, String chatMsg, String chatDate, String chatChk, String chatDel, String chatFile,
			String reqUserId, String resUserId) {
		super();
		this.chatNo = chatNo;
		this.chatMsg = chatMsg;
		this.chatDate = chatDate;
		this.chatChk = chatChk;
		this.chatDel = chatDel;
		this.chatFile = chatFile;
		this.reqUserId = reqUserId;
		this.resUserId = resUserId;
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
	public String getReqUserId() {
		return reqUserId;
	}
	public void setReqUserId(String reqUserId) {
		this.reqUserId = reqUserId;
	}
	public String getResUserId() {
		return resUserId;
	}
	public void setResUserId(String resUserId) {
		this.resUserId = resUserId;
	}
	@Override
	public String toString() {
		return "ChatVO [chatNo=" + chatNo + ", chatMsg=" + chatMsg + ", chatDate=" + chatDate + ", chatChk=" + chatChk
				+ ", chatDel=" + chatDel + ", chatFile=" + chatFile + ", reqUserId=" + reqUserId
				+ ", resUserId=" + resUserId + "]";
	}
	
	
}
