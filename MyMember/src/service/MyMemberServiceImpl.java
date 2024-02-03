package service;

import java.util.List;

import dao.IMyMemberDao;
import dao.MyMemberDaoImpl;
import vo.MyMemberVO;

public class MyMemberServiceImpl implements IMyMemberService{
	
	private static IMyMemberService mmSer;
	
	private IMyMemberDao mmDao = MyMemberDaoImpl.getInstance();
	
	public static IMyMemberService getInstance() {
		if(mmSer == null) {
			mmSer = new MyMemberServiceImpl();
		}
		return mmSer;
	}

	@Override
	public int insertMember(MyMemberVO mv) {
		int cnt = mmDao.insertMember(mv);
		return cnt;
	}

	@Override
	public int updateMember(MyMemberVO mv) {
		int cnt = mmDao.updateMember(mv);
		return cnt;
	}

	@Override
	public MyMemberVO getMember(String memId) {
		MyMemberVO mv = mmDao.getMember(memId);
		return mv;
	}
	
	@Override
	public boolean checkMember(String memId) {
		boolean isExist = mmDao.checkMember(memId);
		return isExist;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt =mmDao.deleteMember(memId);
		return cnt;
	}

	@Override
	public List<MyMemberVO> selectAll() {
		List<MyMemberVO> memList = mmDao.selectAll();
		return memList;
	}
}
