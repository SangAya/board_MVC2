package com.boardMVC.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//컨트롤러라면 Action을 지정 받아야한다는 뜻
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
 