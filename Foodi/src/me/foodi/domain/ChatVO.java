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
		// TODO Auto-generated constructor stub
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chatChk == null) ? 0 : chatChk.hashCode());
		result = prime * result + ((chatDate == null) ? 0 : chatDate.hashCode());
		result = prime * result + ((chatDel == null) ? 0 : chatDel.hashCode());
		result = prime * result + ((chatFile == null) ? 0 : chatFile.hashCode());
		result = prime * result + ((chatMsg == null) ? 0 : chatMsg.hashCode());
		result = prime * result + chatNo;
		result = prime * result + ((reqId == null) ? 0 : reqId.hashCode());
		result = prime * result + ((resId == null) ? 0 : resId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatVO other = (ChatVO) obj;
		if (chatChk == null) {
			if (other.chatChk != null)
				return false;
		} else if (!chatChk.equals(other.chatChk))
			return false;
		if (chatDate == null) {
			if (other.chatDate != null)
				return false;
		} else if (!chatDate.equals(other.chatDate))
			return false;
		if (chatDel == null) {
			if (other.chatDel != null)
				return false;
		} else if (!chatDel.equals(other.chatDel))
			return false;
		if (chatFile == null) {
			if (other.chatFile != null)
				return false;
		} else if (!chatFile.equals(other.chatFile))
			return false;
		if (chatMsg == null) {
			if (other.chatMsg != null)
				return false;
		} else if (!chatMsg.equals(other.chatMsg))
			return false;
		if (chatNo != other.chatNo)
			return false;
		if (reqId == null) {
			if (other.reqId != null)
				return false;
		} else if (!reqId.equals(other.reqId))
			return false;
		if (resId == null) {
			if (other.resId != null)
				return false;
		} else if (!resId.equals(other.resId))
			return false;
		return true;
	}
}
