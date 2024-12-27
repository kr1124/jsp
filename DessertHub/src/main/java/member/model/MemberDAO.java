package member.model;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.Vector;

public class MemberDAO {
    private static StudentDAO instance = null;
    private String db_name = "member";
	
	public MemberDAO() {}

	public static MemberDAO getInstance() {
		if(instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		
		return instance;
	}
	
	//idCheck
	public boolean idCheck(String id) {
		//String sql = "select * from " + db_name + " where id=?";
        String sql_part1 = " * from ";
        String sql_part2 = " where id=?";
        String[] plist = {id};
        boolean result = true;

        DataWrapper dw = DataWrapper.sql_execute("idCheck", "select", sql_part1, sql_part1, plist);

        if(!dw.getRs.next()) {
            result = false;
        }
        
        dw.close();
        return result;
	}//end idCheck

	//회원가입
	public boolean memberInsert(StudentVO vo) {//String sql = "insert into " + db_name + " values(?,?,?,?,null)";
		String sql_part1 = " into ";
		String sql_part2 = " values(?,?,?,?,null)";
		String[] plist = {vo.getId(), vo.getPass(), vo.getEmail(), vo.getNick()};

        DataWrapper dw = DataWrapper.sql_execute("memberInsert", "insert", sql_part1, sql_part2, plist);
        
		boolean flag = false;

        if(dw.getNumber > 0) {
            flag = true;
        }

        dw.close();
		return flag;
	}//end of insertMember
	

	//로그인 버튼을 눌렀을 때 입력된 아이디와 패스워드가 데이터베이스에 저장된 값과 일치하는지 체크
	//1 : 로그인 성공 0 :비밀번호 오류 -1:없는 아이디
	public int loginCheck(String id, String pass) { //"select pass from student where id=?";
		String sql_part1 = " pass from ";
		String sql_part2 = " where id=?";
		String[] plist = {id};

        DataWrapper dw = DataWrapper.sql_execute("loginCheck", "select", sql_part1, sql_part2, plist);

		int check = -1;
		
        if(dw.getRs.next()) {
            String dbpass = dw.getRs.getString("pass");
            if(pass.equals(dbpass)) {
                check = 1;
            }
            else {
                check = 0; //비밀번호 불일치
            }
        }
		
        dw.close();
		return check;
	} //end of loginCheck
	

	/* 회원정보수정을 위해 정보 수정 버튼을 클릭하면
	 * 현재 로그인한 회원정보를 수정할 수 있도록 미리 화면에 보여주어야함.
	 * 
	 * 세션에 설정된 아이디를 가지고 회원정보를 가져오는 메소드를 구현해야함
	 * 
	 * 아이디를 가지고 회원정보를 가져오는 메소드 구현
	 * */
	public MemberVO getMember(String id) {//"select * from student where id=?";
		String sql_part1 = " * from ";
		String sql_part2 = " where id=?";
		String[] plist = {id};

        DataWrapper dw = DataWrapper.sql_execute("getMember", "select", sql_part1, sql_part2, plist);
		MemberVO vo = null;
		
		if(dw.getRs.next()) {
            vo = new MemberVO();
            vo.setId(rs.getString("id"));
            vo.setPass(rs.getString("pass"));
            vo.setEmail(rs.getString("email"));
            vo.setNick(rs.getString("nick"));
        }
		
        dw.close();
		return vo;
	} //end of getMember
	
	/* 정보수정을 위한 데이터베이스 update 함수
	 * */
    ///////////////////////////////////////////////
    // TODO 데이터베이스가 달라서 쿼리문 재작성 필요
    ///////////////////////////////////////////////
	public void updateMember(MemberVO vo) {//"update student set pass=?, phone1=?, phone2=?, phone3=?";
		String sql_part1 = " ";
		String sql_part2 = " set id=? pass=?, email=?, nick=?";
		String[] plist = {vo.getId(), vo.getPass(), vo.getEmail(), vo.getNick()};

        DataWrapper dw = DataWrapper.sql_execute("updateMember", "update", sql_part1, sql_part2, plist);
        
        dw.close();
	} //end of updateMember
	
	//회원탈퇴 : 버튼이 클릭되면 비밀번호를 입력받고 일치하는지 확인하여 일치하면 탈퇴
	public int deleteMember(String id, String pass) {//"select pass from student where id=?";	
		String sql_part1 = " pass from ";
		String sql_part2 = " where id=?";
		String[] plist = {id};

        DataWrapper dw = DataWrapper.sql_execute("deleteMember", "select", sql_part1, sql_part2, plist);
        
		String dbpass = "";//db에 저장된 비밀번호

		int result = -1; //해당 아이디 없음
		
		if(dw.getRs.next()) {
            dbpass = dw.getRs.getString("pass");
            if(dbpass.equals(pass)) {
                	
                String sql_part21 = " from ";
                String sql_part22 = " where id=?";
                String[] plist = {id};

                DataWrapper dw = DataWrapper.sql_execute("deleteMember2", "delete", sql_part21, sql_part22, plist);

                String sql2 = "delete from student where id=?";
                result = 1; //탈퇴 성공
            }
            else {
                result = 0; //비밀번호 불일치
            }
        }
        
        dw.close();
		return result;
	} //end of deleteMember
	
}
