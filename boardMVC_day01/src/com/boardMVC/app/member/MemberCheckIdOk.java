package com.boardMVC.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.boardMVC.action.Action;
import com.boardMVC.action.ActionForward;
import com.boardMVC.app.member.dao.MemberDAO;

public class MemberCheckIdOk implements Action{

	//사용자가 중복확인 누름 -> web.xml -> 프론트 -> 분기처리(MemberCheckIdOk)를 사용 /HttpServletRequest로 받는다
	@Override //사용자가 입력한 매개변수를 받는다.
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		//memberId를 가져온것을 memberId에 저장
		String memberId = req.getParameter("memberId");
		MemberDAO dao = new MemberDAO();
		PrintWriter out = resp.getWriter();
		JSONObject obj = new JSONObject();
		
		if(dao.checkId(memberId)) {
			//아이디가 중복되었을 때
//			out.print("not-ok");
			obj.put("status", "not-ok");
		}else {
			//사용 가능한 아이디일 때
//			out.print("ok");
			obj.put("status", "ok");
		}
		out.print(obj.toJSONString());
		out.close();
		
		//페이지 이동할 필요없으므로 null
		return null;
	}
}
