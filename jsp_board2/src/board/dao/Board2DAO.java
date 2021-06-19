package board.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbmanager.Boarddbmanager;
import board.dto.Board2;

public class Board2DAO {
	//생성자
	Boarddbmanager db = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String sql = "";
	int result=-1;
	
	
	public ArrayList<Board2> b2listAll() {
		
		sql="select * from mvcboard2 order by bno desc";
		ArrayList<Board2> list = new ArrayList<>();
	
			try {
				conn=Boarddbmanager.getConnection();
				pstmt=conn.prepareStatement(sql);
				rset=pstmt.executeQuery();
				
				while (rset.next()) {

					int bno = rset.getInt("bno");
					String bname = rset.getString("bname");
					String bpass = rset.getString("bpass");
					String btitle = rset.getString("btitle");
					String bcontent = rset.getString("bcontent");
					String bip = rset.getString("bip");
					String bdate = rset.getString("bdate");
					int bhit = rset.getInt("bhit");
					String bfile=rset.getString("bfile");

					Board2 board = new Board2(bno, bname, bpass, btitle, bcontent, bip, bdate, bhit, bfile);
					list.add(board);
				}

			} catch (SQLException e) {
				
			}finally {
				closeAll();
			}
		return list;		
	}
	
	public int b2listCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		sql="select count(*) from mvcboard2";
		int count=-1;
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
		
			while(rset.next()) {
				count=rset.getInt(1);
			}
		} catch(Exception e) {
			
		}finally {
		closeAll();
		}
		return count; 
	
	}
	
	public int b2write(String bname, String bpass, String btitle, String bcontent, String bfile) {
		sql="insert into mvcboard2 (bname,bpass,btitle, bcontent,bip, bdate, bfile) values (?, ?, ?, ?,?,now(),?) ";
		System.out.println(bname+"/"+bpass+"/"+btitle+"/"+bcontent);
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=this.conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, bpass);
			pstmt.setString(3, btitle);
			pstmt.setString(4, bcontent);
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress()); 
			pstmt.setString(6, bfile);
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				result=1;   //성공했을 경우, result=1로 만들어주어야 함.
			}
					
		}catch(Exception e) {
			
		}finally {
			this.closeAll();			
		}
		return result;
	}
	
	public Board2 b2getInfo(int bno) {
		sql="select * from mvcboard2 where bno=?";
		Board2 dto=new Board2();
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bno); //물음표에 bno 집어넣음
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				dto.setBno(bno);
				dto.setBname(rset.getString("bname"));
				dto.setBpass(rset.getString("bpass"));
				dto.setBtitle(rset.getString("btitle"));
				dto.setBcontent(rset.getString("bcontent").replace("\r\n", "<br>"));
				dto.setBhit(rset.getInt("bhit"));
				dto.setBfile(rset.getString("bfile"));
			}
			
		} catch (Exception e) {
		}finally {
			closeAll();
		}

		return dto ;
	}
	
	public String b2check (int bno) {
		
		sql="select bpass from mvcboard2 where bno=?";
		String bpass="";
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				bpass=rset.getString("bpass");
			}

		}catch(Exception e) {
		}finally {
			closeAll();
		}
		return bpass;
	}
	
	public int b2update(String btitle, String bcontent,String bfile, int bno) {
		sql="update mvcboard2 set btitle=?,bcontent=?, bfile=? where bno=?";
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,btitle);
			pstmt.setString(2, bcontent);
			pstmt.setString(3, bfile);
			pstmt.setInt(4, bno);
			
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
	
	public int b2delete(int bno) {
		sql="delete from mvcboard2 where bno=?";
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bno);			
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
	
	public int b2hit(int bno) {
		sql="update mvcboard2 set bhit=bhit+1 where bno=?";
		
		try {
			conn=Boarddbmanager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result=pstmt.executeUpdate();
			if(result>0) {
				result=1;
			}
		}catch(Exception e) {
			closeAll();
		}
		return result;
	}
	

	public ArrayList<Board2> b2list10(int startno, int onepagelimit) {
		
		ArrayList<Board2> boards = new ArrayList<>();
		System.out.println(startno);
		System.out.println(onepagelimit);
		sql = "select * from mvcboard2 order by bno desc limit ?, ?";
		try {
			conn=Boarddbmanager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startno);
			pstmt.setInt(2, onepagelimit);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int bno = rset.getInt("bno");
				String bname = rset.getString("bname");
				String bpass = rset.getString("bpass");
				String btitle = rset.getString("btitle");
				String bcontent =rset.getString("bcontent").replace("\r\n", "<br>");
				String bip = rset.getString("bip");
				String bdate =rset.getString("bdate");
				int bhit =rset.getInt("bhit");
				String bfile =rset.getString("bfile");
				
				Board2 board = new Board2(bno, bname, bpass, btitle, bcontent, bip, bdate, bhit,bfile);
				boards.add(board);
			}
		} catch (SQLException e) {	}
		
		// DB 끊기
		this.closeAll();
		
		return boards;
	}
	///검색하기
	public ArrayList<Board2> b2search(String btitle) {
		ArrayList<Board2> boards = new ArrayList<>();
		
		this.sql = "select * from mvcboard2 where btitle like ? order by bno desc";
		try {
			conn=Boarddbmanager.getConnection();
			this.pstmt = this.conn.prepareStatement(this.sql);
			this.pstmt.setString(1, "%"+btitle+"%");    //btitle이 속해있는 거 다 검색.
			this.rset = this.pstmt.executeQuery();
			while(this.rset.next()) {
				int bno = this.rset.getInt("bno");
				String bname = this.rset.getString("bname");
				String bpass = this.rset.getString("bpass");
				btitle = this.rset.getString("btitle");
				String bcontent = this.rset.getString("bcontent").replace("\r\n", "<br>");
				String bip = this.rset.getString("bip");
				String bdate = this.rset.getString("bdate");
				int bhit = this.rset.getInt("bhit");
				String bfile = this.rset.getString("bfile");
				
				Board2 board = new Board2(bno, bname, bpass, btitle, bcontent, bip, bdate, bhit, bfile);
				boards.add(board);
			}
		} catch (SQLException e) {	}
		
		// DB 끊기
		this.closeAll();
		
		return boards;
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

