package com.boardMVC.app.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.boardMVC.app.member.vo.MemberVO;
import com.boardMVC.mybatis.config.MyBatisConfig;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessoinFactory();
	SqlSession sqlSession;
	
	//MemberDAO()생성자를 호출할때 마다 sqlSession을 오픈해준다.
	public MemberDAO() {
		sqlSession = sqlSessionFactory.openSession(true); //오토커밋
	}
	
	//아이디 중복검사
	public boolean checkId(String memberId) {
		//session.selectOne 메서드를 이용하여 쿼리문에 해당하는 id 값을 가져옵니다
		return (Integer)sqlSession.selectOne("Member.checkId", memberId) == 1;
	}
	
	//회원가입
	public void join(MemberVO member) {
		sqlSession.insert("Member.join", member);
	}
	
}












