package com.boardmvc.model;

import java.sql.*;
import java.util.*;
//import javax.sql.*;
//import javax.naming.*;

public class BoardDAO {
	private static BoardDAO instance = null;
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			synchronized(BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		
		return instance;
	}
	
	// 글 목록 화면 작성
	// 전체 글의 갯수를 가져올 메소드 구현
	public int getArticleCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			con = ConnUtil.getConnection();
			String sql = "select count(*) from board";
			pstmt =  con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return x;
	}
	
	public List<BoardVO> getArticles(int start, int end) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> articleList = null;
		
		try {
			con = ConnUtil.getConnection();
			
			//String sql = "select * from board order by num desc"; //기존 쿼리문
			String sql = "select * from ("
					+ "select rownum rnum, num, writer, email, subject, "
					+ "pass, readcount, ref, step, depth, regdate, content, ip from ("
					+ "select * from board order by ref desc, step asc)) "
					+ "where rnum >= ? and rnum <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<BoardVO>(end - start + 1);
				do {
					BoardVO article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					
					articleList.add(article);
				} while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return articleList;
	}

	//데이터베이스에 데이터 추가
	public void insertArticle(BoardVO article) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = article.getNum();
		int ref = article.getRef();
		int step = article.getStep();
		int depth = article.getDepth();
		
		int number = 0;
		String sql = "";
		
		try {
			con = ConnUtil.getConnection();
			pstmt =  con.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				number = rs.getInt(1);
			} else {
				number = 1;
			}
			
			if(number != 0) {//답글일 경우
				sql = "update board set step=step+1 where ref=? and step > ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);
				pstmt.executeUpdate();
				step++;
				depth++;
				
			} else {//새글일 경우
				ref = number;
				step = 0;
				depth = 0;
			}
			//데이터 추가하는 쿼리문
			sql = "insert into board(num, writer, email, subject, pass, ref, step, depth, regdate, content, ip) "
					+ "values(board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getEmail());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getPass());
			//pstmt.setInt(5, 0);
			pstmt.setInt(5, ref);
			pstmt.setInt(6, step);
			pstmt.setInt(7, depth);
			pstmt.setTimestamp(8, article.getRegdate());
			pstmt.setString(9, article.getContent());
			pstmt.setString(10, article.getIp());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
	}
	
	//글 제목을 클릭하면 글 내용을 볼 수 있는 작업을 한다.
	//글 번호를 매개변수로 해서 하나의 글에 대한 상세 정보를 데이터베이스에서 가져온다.
	public BoardVO getArticle(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		
		try {
			con = ConnUtil.getConnection();
			String sql1 = "update board set readcount=readcount+1 where num=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			String sql2 = "select * from board where num=?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}
		} catch(SQLException se) {
			se.printStackTrace();
		} finally {
			if(rs!=null){try {rs.close();} catch(Exception e) {e.printStackTrace();}}
			if(pstmt!=null){try {pstmt.close();} catch(Exception e) {e.printStackTrace();}}
			if(con!=null){try {con.close();} catch(Exception e) {e.printStackTrace();}} 
		}
		
		return article;
	}
	
	//글 수정 / 글 목록 보기와는 다르게 조회수를 증가 시킬 필요가 없음
	//따라서 num에 해당하는 글을 가져옴
	public BoardVO updateGetArticle(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		
		try {
			con = ConnUtil.getConnection();
			String sql = "select * from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return article;
	}//end of updateGetArticle
	
	//글 수정 버튼을 클릭하면 실제 데이터베이스의 글이 수정되어야함.
	public int updateArticle(BoardVO article) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			con = ConnUtil.getConnection();
			String sql = "select pass from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getNum());
			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				String dbpasswd = rs.getString("pass");
				if(dbpasswd.equals(article.getPass())) {
					String sql2 = "update board set writer=?, email=?, subject=?, content=? where num=?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getEmail());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getContent());
					pstmt.setInt(5, article.getNum());
					
					pstmt.executeUpdate();
					
					result = 1;
				} else {
					result = 0; //비밀번호 오류, 수정 실패
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return result;
	}
	
	//글 삭제 버튼을 클릭하면 삭제처리가 되어야한다.
	//비밀번호를 입력 받아 기존 비밀번호와 동일하면 삭제
	public int deleteArticle(int num, String pass) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1; //번호에 해당하는 글이 존재하지 않는 경우, -1을 반환
		
		try {
			con = ConnUtil.getConnection();
			String sql1 = "select pass from board where num=?";
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, num);			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				String dbpasswd = rs.getString("pass");
				if(dbpasswd.equals(pass)) {
					String sql2 = "delete from board where num=?";
					
					pstmt = con.prepareStatement(sql2);
					pstmt.setInt(1, num);					
					pstmt.executeUpdate();
					
					result = 1;
				} else {
					result = 0; //비밀번호 오류, 삭제 실패
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return result;
	}//deleteArticle
	
	

	//검색한 내용이 몇개인지를 반환함(what:검색조건, content: 검색내용)
	public int getArticleCount(String find, String find_box) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			con = ConnUtil.getConnection();
			//String sql = "select count(*) from board";
			//String sql = "select count(*) from board where " + find + " like '%" + find_box + "%'";
			//pstmt =  con.prepareStatement(sql);
			
			if(find.equals("writer")) {
				pstmt = con.prepareStatement("select count(*) from board where writer=?");
				pstmt.setString(1, find_box);
			} else if(find.equals("subject")) {
				pstmt = con.prepareStatement("select count(*) from board where subject like '%" + find_box + "%'");
			} else if(find.equals("content")) {
				pstmt = con.prepareStatement("select count(*) from board where content like '%" + find_box + "%'");
			} else {
				pstmt = con.prepareStatement("select count(*) from board");
			}

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return x;
	}//getArticleCount(String what, String content)
	
	//검색할 내용을 리스트로 받아옴
	public List<BoardVO> getArticles(String find, String find_box, int start, int end) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> articleList = null;
		
		try {
			con = ConnUtil.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * from ");
			sql.append("(select rownum rnum, num, writer, email, subject, pass, readcount, ref, step, depth, regdate, content, ip from ");
			sql.append("");
			
			if(find.equals("writer")) {
				sql.append("(select * from board where writer=? order by ref desc, step asc)) where rnum >= ? and rnum <= ?");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, find_box);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			} else if(find.equals("subject")) {
				sql.append("(select * from board where subject like '%" + find_box + "%' order by ref desc, step asc)) where rnum >= ? and rnum <= ?");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			} else if(find.equals("content")) {
				sql.append("(select * from board where content like '%" + find_box + "%' order by ref desc, step asc)) where rnum >= ? and rnum <= ?");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			} else {
				sql.append("(select * from board order by ref desc, step asc)) where rnum >= ? and rnum <= ?");
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
			
			// 2
			//String sql = "select * from board order by num desc"; //기존 쿼리문
//			String sql = "select * from ("
//					+ "select rownum rnum, num, writer, email, subject, "
//					+ "pass, readcount, ref, step, depth, regdate, content, ip from ("
//					+ "select * from board where "
//					+ find + " like '%" + find_box + "%' order by ref desc, step asc)) "
//					+ "where rnum >= ? and rnum <= ?";
			
			
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, start);
//			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<BoardVO>(end - start + 1);
				do {
					BoardVO article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					
					articleList.add(article);
				} while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return articleList;
	}
}
