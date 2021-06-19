package dbmanager;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class Boarddbmanager {
	//1.멤버변수
	private static Boarddbmanager instance=new Boarddbmanager();
	//2.생성자
	public Boarddbmanager() {
		super();
	}
	//3.멤버함수(getter/setter/getConnection)
	public static Boarddbmanager getInstance() {
		return instance;
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Context initContext=new InitialContext();
			Context envContext=(Context)initContext.lookup("java:/comp/env");
			DataSource ds=(DataSource) envContext.lookup("jdbc/bigdata3");
			conn=ds.getConnection();
			System.out.println(" 드라이버 연결 성공!!!");
		}catch(Exception e) {
			System.out.println(" 드라이버 연결 실패!!!!!!!!!!!!!");
		}
		return conn;
		
	}
	
	
	
}
