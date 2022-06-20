package com.boardMVC.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boardMVC.action.ActionForward;

public class MemberFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자가 요청한 URL를 받는다
		String requestURI = req.getRequestURI();
		//절대 경로를 사용하기 위해 contextPath ex)naver.com/a.c 중에서 naver.com를 지칭
		String contextPath = req.getContextPath();
		//contextPath.length() 1부터 시작하니깐 naver.com/a.c ->a부터 나머지 (분기별로 나눠준다.)
		String command = requestURI.substring(contextPath.length());
		ActionForward af = null;
		
		//아이디 중복체크 분기처리 //요청이 필요할때 마다 else if에 담아서 사용하기만하면 된다.
		if(command.equals("/member/MemberCheckIdOk.me")) {
			new MemberCheckIdOk().execute(req, resp);
			
			//객체에 null이 들어가있거나/member/MemberJoinOk.me가 객체에 들어가있다
		}else if(command.equals("/member/MemberJoinOk.me")) {
			af = new MemberJoinOk().execute(req, resp);
		}
		
		//어떤것으로 들어갈지 정해준다(일괄처리)
		//전송안할지
		if(af != null) {
			if(af.isRedirect()) {
		//redirect
				resp.sendRedirect(af.getPath());
			}else {
		//forward
				//request객체에서 Dispatch을 가져온 뒤, 이동할 경로를 전달한다.
				//dispatch : 요청과 응답을 관리해주는 객체
				RequestDispatcher dispatcher = req.getRequestDispatcher(af.getPath());
				//dispatcher객체에서 forward()를 사용할 때 request와 response객체 둘 다 전달해주면
				//응답할 화면까지 데이터가 유지된다.
				dispatcher.forward(req, resp);
			}
		}
	}
}
















