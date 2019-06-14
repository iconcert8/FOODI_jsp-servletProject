package me.foodi.domain;

public class ChatVO {
	private int chatNo;
	private String chatMsg;
	private String chatDate;
	private String chatChk;
	private String chatDel;
	private String chatFile;
	private String requestUserId;
	private String responseUserId;
	
	
	
	public ChatVO() {
		super();
	}
	public ChatVO(int chatNo, String chatMsg, String chatDate, String chatChk, String chatDel, String chatFile,
			String requestUserId, String responseUserId) {
		super();
		this.chatNo = chatNo;
		this.chatMsg = chatMsg;
		this.chatDate = chatDate;
		this.chatChk = chatChk;
		this.chatDel = chatDel;
		this.chatFile = chatFile;
		this.requestUserId = requestUserId;
		this.responseUserId = responseUserId;
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
	public String getRequestUserId() {
		return requestUserId;
	}
	public void setRequestUserId(String requestUserId) {
		this.requestUserId = requestUserId;
	}
	public String getResponseUserId() {
		return responseUserId;
	}
	public void setResponseUserId(String responseUserId) {
		this.responseUserId = responseUserId;
	}
	@Override
	public String toString() {
		return "ChatVO [chatNo=" + chatNo + ", chatMsg=" + chatMsg + ", chatDate=" + chatDate + ", chatChk=" + chatChk
				+ ", chatDel=" + chatDel + ", chatFile=" + chatFile + ", requestUserId=" + requestUserId
				+ ", responseUserId=" + responseUserId + "]";
	}
	
	
}
