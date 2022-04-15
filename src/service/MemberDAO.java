package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.MemberVo;

public class MemberDAO {

	public void delete(String id) {
	      Connection conn= null;
	      PreparedStatement pstmt = null;
	      
	      String dbURL = "jdbc:mysql://127.0.0.1:3306/jspTestDB?useSSL=false";
	      String dbID = "root";
	      String dbPW = "rootroot";
	      
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
	         
	         String sql = "delete from t_member where id = ?";
	         System.out.println("작동");
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         int de = pstmt.executeUpdate();
	         System.out.println("반환" + de);
	        
	         
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {

	         e.printStackTrace();
	      } finally {
	         if(pstmt != null) {
	            try {
	               pstmt.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	         
	         if(conn != null) {
	            try {
	               conn.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	   }
	   
	
	
	public List<MemberVo> listMembers() {

		List<MemberVo> list = new ArrayList<MemberVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbURL = "jdbc:mysql://127.0.0.1:3306/jspTestDB?useSSL=false";
		String dbID = "root";
		String dbPW = "rootroot";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);

			String sql = "select * from t_member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setJoinDate(rs.getDate("joinDate"));

				list.add(vo);
			}

			for (MemberVo m : list) {
				System.out.println(m.toString());
			}

			System.out.println("MemberVO selectAll() 메서드 실행 완료");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;

	}

	public MemberVo searchMember(String searchID) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbURL = "jdbc:mysql://127.0.0.1:3306/jspTestDB?useSSL=false";
		String dbID = "root";
		String dbPW = "rootroot";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);

			String sql = "select * from t_member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setJoinDate(rs.getDate("joinDate"));
				
				return vo;

			}else {
				return null;
			}

		

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}
	
		   
		   public void insert(String id, String pwd, String name , String email) {
		      Connection conn= null;
		      PreparedStatement pstmt = null;
		      
		      String dbURL = "jdbc:mysql://127.0.0.1:3306/jspTestDB?useSSL=false";
		      String dbID = "root";
		      String dbPW = "rootroot";
		      
		      try {
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
		         
		         String sql = "insert into t_member(id, pwd, name, email) "
		               + " values (?, ?, ?, ?)";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, id);
		         pstmt.setString(2, pwd);
		         pstmt.setString(3, name);
		         pstmt.setString(4, email);
		       pstmt.executeUpdate();
		       
		       
		         
		     
		         
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         if(pstmt != null) {
		            try {
		               pstmt.close();
		            } catch (SQLException e) {
		               e.printStackTrace();
		            }
		         }
		         
		         if(conn != null) {
		            try {
		               conn.close();
		            } catch (SQLException e) {
		               e.printStackTrace();
		            }
		         }
		      }
		
		   }
	}

		   


