package member.model;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.Vector;

class DataWrapper {
    private int number;
    private ResultSet rs;

    // 생성자
    public DataWrapper(int number) {
        this.number = number;
    }
    public DataWrapper(int number, ResultSet rs) {
        this.number = number;
        this.rs = rs;
    }

    // Getter와 Setter
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
}

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
	
	// private Connection getConnection() {
	// 	Connection con = null;
		
	// 	try {
	// 		Context initContext = new InitialContext();
	// 		Context envContext  = (Context)initContext.lookup("java:/comp/env");
	// 		DataSource ds = (DataSource)envContext.lookup("jdbc/myOracle");
	// 		con = ds.getConnection();
			
	// 		System.out.println("데이터베이스 연결 성공");
	// 	} catch(NamingException ne) {
	// 		System.out.println("커넥션 생성 실패");
	// 		ne.printStackTrace();
	// 	} catch(SQLException se) {
	// 		System.out.println("커넥션 생성 실패");
	// 		se.printStackTrace();
	// 	} catch(Exception e) {
	// 		System.out.println("데이터베이스 연결 실패");
	// 	}
		
	// 	return con;
	// }
	
    public DataWrapper sql_execute(String func_name, String sql_type, String sql_part, String[] plist) {
        DataWrapper dw = null;
        int result = 1;
        
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

        String sql;
        boolean execute_type = false;
		
        switch(sql_type) {
            case "select":
                sql = "select * from "
                execute_type = true;
                break;
            case "insert":
                sql = "insert into "
                break;
            case "update":
                sql = "update "
                break;
            case "delete":
                sql = "delete from "
                break;

            default:
                break;
        }
                
        sql += db_name + " sql_part";

		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql);
            for(int i = 0; i < plist.length; i++) {
			    pstmt.setString(i + 1, plist[i]);
            }
			
            if(execute_type) { //select
			    rs = pstmt.executeQuery();

                if(!rs.next()) {
                    result = 0;
                }
            } else {
			    result = pstmt.executeUpdate();
            }
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return result;
    }

	//idCheck
	public boolean idCheck(String id) {
		//String sql = "select * from " + db_name + " where id=?";
        String sql_part = " where id=?";
        // TODO 인수로 받은 id를 리스트 형식으로 전달해야함
        String[] plist = {id};
        int result = sql_execute("idCheck", "select", sql_part, plist);

        if(result == 1) {
            return true;
        } else if(result == 0) {
            return false;
        }
	}//end idCheck

	//회원가입
	public boolean memberInsert(StudentVO vo) {
		
		//String sql = "insert into " + db_name + " values(?,?,?,?,null)";
		String sql_part = " values(?,?,?,?,null)";
		String[] plist = {vo.getId(), vo.getPass(), vo.getEmail(), vo.getNick()};

        int result = sql_execute("memberInsert", "insert", sql_part, plist);
        
		boolean flag = false;
        if(result > 0) {
            flag = true;
        }

		return flag;
	}//end of insertMember
	

	//로그인 버튼을 눌렀을 때 입력된 아이디와 패스워드가 데이터베이스에 저장된 값과 일치하는지 체크
	//1 : 로그인 성공 0 :비밀번호 오류 -1:없는 아이디
	public int loginCheck(String id, String pass) {
		// String sql_part = " where id=?";
		// String[] plist = {id};

        // int check = sql_execute("memberInsert", "insert", sql_part, plist);

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int check = -1;
		
		try {
			con = getConnection();
			
			String sql = "select pass from student where id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpass = rs.getString("pass");
				if(pass.equals(dbpass)) {
					check = 1;
				}
				else {
					check = 0; //비밀번호 불일치
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return check;
	} //end of loginCheck
	

	/* 회원정보수정을 위해 정보 수정 버튼을 클릭하면
	 * 현재 로그인한 회원정보를 수정할 수 있도록 미리 화면에 보여주어야함.
	 * 
	 * 세션에 설정된 아이디를 가지고 회원정보를 가져오는 메소드를 구현해야함
	 * 
	 * 아이디를 가지고 회원정보를 가져오는 메소드 구현
	 * */
	public StudentVO getMember(String id) {
		StudentVO vo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			
			String sql = "select * from student where id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new StudentVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone1(rs.getString("phone1"));
				vo.setPhone2(rs.getString("phone2"));
				vo.setPhone3(rs.getString("phone3"));
				vo.setEmail(rs.getString("email"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress1(rs.getString("address1"));
				vo.setAddress2(rs.getString("address2"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return vo;
	} //end of getMember
	
	/* 정보수정을 위한 데이터베이스 update 함수
	 * */
	public void updateMember(StudentVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;

		String sql = "update student set pass=?, phone1=?, phone2=?, phone3=?, email=?, zipcode=?, "
				+ "address1=?, address2=? where id=?";
		
		try {
			con = getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getPhone1());
			pstmt.setString(3, vo.getPhone2());
			pstmt.setString(4, vo.getPhone3());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getZipcode());
			pstmt.setString(7, vo.getAddress1());
			pstmt.setString(8, vo.getAddress2());
			pstmt.setString(9, vo.getId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			//if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
	} //end of updateMember
	
	//회원탈퇴 : 버튼이 클릭되면 비밀번호를 입력받고 일치하는지 확인하여 일치하면 탈퇴
	public int deleteMember(String id, String pass) {		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpass = "";//db에 저장된 비밀번호

		int result = -1; //해당 아이디 없음
		
		try {
			con = getConnection();

			String sql1 = "select pass from student where id=?";
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpass = rs.getString("pass");
				if(dbpass.equals(pass)) {
					String sql2 = "delete from student where id=?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					result = 1; //탈퇴 성공
				}
				else {
					result = 0; //비밀번호 불일치
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return result;
	} //end of deleteMember
	
}
