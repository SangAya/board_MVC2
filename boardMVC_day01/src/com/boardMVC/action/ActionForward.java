package com.boardMVC.action;

public class ActionForward {
	private boolean isRedirect; //forward냐 redirect냐 
	private String path;//어디로 갈껀지 
	
	public ActionForward() {;}

	public boolean isRedirect() { //이자체로 getter
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
}
