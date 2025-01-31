package com.mvcmem.model;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.Vector;

public class StudentDAO {
	private static StudentDAO instance = null;
	
	public StudentDAO() {}

	public static StudentDAO getInstance() {
		if(instance == null) {
			synchronized (StudentDAO.class) {
				instance = new StudentDAO();
			}
		}
		
		return instance;
	}
	
	private Connection getConnection() {
		Connection con = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myOracle");
			con = ds.getConnection();
			
			System.out.println("데이터베이스 연결 성공");
		} catch(NamingException ne) {
			System.out.println("커넥션 생성 실패");
			ne.printStackTrace();
		} catch(SQLException se) {
			System.out.println("커넥션 생성 실패");
			se.printStackTrace();
		} catch(Exception e) {
			System.out.println("데이터베이스 연결 실패");
		}
		
		return con;
	}
	
	//여기서부터 메소드를 하나씩 추가하여 구현하면 됨
	
	//idCheck
	public boolean idCheck(String id) {
		boolean result = true;
		String sql = "select * from student where id=?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				result = false;
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return result;
	}//end idCheck

	public Vector<ZipCodeVO> zipcodeRead(String dong) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();
		
		try {
			con = getConnection();
			
			String sql = "select * from zipcode where dong like '" + dong + "%'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipCodeVO tempZipCode = new ZipCodeVO();
				tempZipCode.setZipcode(rs.getString("zipcode"));
				tempZipCode.setSido(rs.getString("sido"));
				tempZipCode.setGugun(rs.getString("gugun"));
				tempZipCode.setDong(rs.getString("dong"));
				tempZipCode.setRi(rs.getString("ri"));
				tempZipCode.setBunji(rs.getString("bunji"));
				vecList.add(tempZipCode);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return vecList;
	}//end zipcodeRead
	

	//회원가입
	public boolean memberInsert(StudentVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		
		boolean flag = false;
		
		try {
			con = getConnection();
			
			String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getPhone3());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getZipcode());
			pstmt.setString(9, vo.getAddress1());
			pstmt.setString(10, vo.getAddress2());
			
			int count = pstmt.executeUpdate();
			if(count > 0) {
				flag = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			//if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return flag;
	}//end of insertMember
	

	//로그인 버튼을 눌렀을 때 입력된 아이디와 패스워드가 데이터베이스에 저장된 값과 일치하는지 체크
	//1 : 로그인 성공 0 :비밀번호 오류 -1:없는 아이디
	public int loginCheck(String id, String pass) {		
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
