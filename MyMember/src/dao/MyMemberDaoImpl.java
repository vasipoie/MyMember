package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import common.MyBatisDao;
import util.MyBatisUtil;
import vo.MyMemberVO;

public class MyMemberDaoImpl extends MyBatisDao implements IMyMemberDao{
	
	private static IMyMemberDao mmDao;
	
	private MyMemberDaoImpl() {
	}

	public static IMyMemberDao getInstance() {
		if(mmDao == null) {
			mmDao = new MyMemberDaoImpl();
		}
		return mmDao;
	}

	
	@Override
	public int insertMember(MyMemberVO mv) {
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.insert("mymember.insertMember", mv);
			
			if(cnt > 0) {
				sqlSession.commit();
			}
		}catch(PersistenceException ex) {
			sqlSession.rollback();
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}

	
	@Override
	public int updateMember(MyMemberVO mv) {
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.update("mymember.updateMember", mv);
			
			if(cnt > 0) {
				sqlSession.commit();
			}
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	

	@Override
	public MyMemberVO getMember(String memId) {
		
		SqlSession sqlSession = MyBatisUtil.getInstance(true);
		
		MyMemberVO mv = null;
		
		try {
			mv = sqlSession.selectOne("mymember.getMember",memId);
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return mv;
	}
	
	
	@Override
	public boolean checkMember(String memId) {
		
		boolean isExist = false;
		
		SqlSession sqlSession = MyBatisUtil.getInstance();

		try {
			int cnt = sqlSession.selectOne("mymember.checkMember", memId);

			if(cnt > 0) {
				isExist = true;
			}
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return isExist;
	}


	@Override
	public int deleteMember(String memId) {
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.delete("mymember.deleteMember", memId);
			
			if(cnt > 0) {
				sqlSession.commit();
			}
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	
	@Override
	public List<MyMemberVO> selectAll() {
		
		List<MyMemberVO> memList = new ArrayList<MyMemberVO>();
		
		SqlSession sqlSession = MyBatisUtil.getInstance(true);
		
		try {
			memList = sqlSession.selectList("mymember.selectAll");
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return memList;
	}
}
