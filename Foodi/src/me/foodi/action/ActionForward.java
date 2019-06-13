package me.foodi.action;

public class ActionForward {

	private boolean isRedirect;
	private String path;

	public ActionForward() {
		// TODO Auto-generated constructor stub
	}

	public ActionForward(boolean isRedirect, String path) {
		super();
		this.isRedirect = isRedirect;
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ActionForward [isRedirect=" + isRedirect + ", path=" + path + "]";
	}

}
