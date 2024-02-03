package dao;

import java.util.List;

import vo.MyMemberVO;

public interface IMyMemberDao {
	
	public int insertMember(MyMemberVO mv);
	
	public int updateMember(MyMemberVO mv);
	
	public boolean checkMember(String memId);
	
	public MyMemberVO getMember(String memId);
	
	public int deleteMember(String memId);
	
	public List<MyMemberVO> selectAll();
}
