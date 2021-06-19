package member.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbmanager.Boarddbmanager;
import memberdto.Members;

public class MemberDAO {
	
	Boarddbmanager db = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String sql = "";
	int result=-1;
	
	//mypage  - 완료  ( 아이디에 맞는 나머지 정보 가져오기)
	//b1join  - 완료 ( 가입하기)
	//id_check - 완료 ( 아이디 중복 체크)
	//m1check  - 완료 ( 로그인 아이디, 비밀번호 확인 과정)
	//m1delete  - 완료 ( 개인 정보 삭제 )
	//m1update - 완료 ( 개인 정보 업데이트)
	
	public Members mypage(String userid) {
		//joincom
		sql="select * from members1 where userid=?";
		Members dto=new Members();
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				dto.setUserid(rset.getString("userid"));
				dto.setUsername(rset.getString("username"));
				dto.setUserpass(rset.getString("userpass"));
				dto.setUseremail(rset.getString("useremail"));
				dto.setUserip(rset.getString("userip"));
				dto.setUserdate(rset.getString("userdate"));
			}//end if
		
		}catch(Exception e) {
			
		}finally {
			closeAll();
		}
		return dto;
	}
	
	public int login (String userid, String userpass) {
		
		sql="select count(*) from members1 where userid=? and userpass=?";
		int count=0;
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpass);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count(*)");
			}
		} catch (Exception e) {
			
		} finally { // DB 끊기
			try {
				
				closeAll();
				
			} catch(Exception e1) {	}
		}
		
		return count;
			
	}
	
	public int idcheck(String userid) {
		sql="select * from members1 where userid=?";
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rset=pstmt.executeQuery();
			result=-1;
			
			if(rset.next()) {
				result=1;
			}else {
			}
		}catch(Exception e) {
			
		}finally {
			closeAll();
		}
		return result;	
		
	}
	
	
	public int b1join(String userid, String username, String userpass, String useremail) {
		
		sql="insert into members1 (userid, username, userpass, "
				+ "useremail, userip, userdate) values ( ?,?,?,?,?,now() )";
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=this.conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, username);
			pstmt.setString(3, userpass);
			pstmt.setString(4, useremail);
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			result=pstmt.executeUpdate();
			
			if(result > 0) {
				result=1;   //성공했을 경우, result=1로 만들어주어야 함.
			}			
		}catch(Exception e) {
			
		}finally {
			this.closeAll();			
		}
		return result;
	}
	
	public String m1check(String userid) {
		
		sql="select userpass from members1 where userid=?";
		String userpass="";
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			if(rset.next()) {
				userpass=rset.getString("userpass");
			}
		}catch(Exception e) {
			
		}finally {
			closeAll();
		}
		return userpass;
	}
	
	public int m1update(String username, String userpass, String useremail, String userid) {
		String sql="update members1 "
				+ "set username=?, userpass=?, useremail=? where userid=?";
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2, userpass);
			pstmt.setString(3, useremail);
			pstmt.setString(4, userid);
			result=pstmt.executeUpdate();
			if(result>0) {
				result=1;
			}
		}catch(Exception e) {
			
		}finally {
			closeAll();
		}
		return result;
		
	}
	
	public int m1delete(String userid) {
		sql="delete from members1 where userid=?";
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);			
			result=pstmt.executeUpdate();
			if(result>0) {
				result=1;
			}
		}catch(Exception e) {
			
		}finally {
			closeAll();
		}
		return result;
	}
	
	
	
	public void closeAll() {
		
		try {
			if (rset != null) {
				rset.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
		} // try 작은
	}

}
