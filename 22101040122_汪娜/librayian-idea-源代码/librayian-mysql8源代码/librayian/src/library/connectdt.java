package library;

import java.sql.*;
public class connectdt {//此类为连接数据库的类
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/emp?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
	static final String USER = "root";
	static final String PASS = "root";
	String struser = "username", strpass = "password", strtable1 = "admindt", strtable2 = "books",ID="id";//连接数据库中emp中admindt
	Connection conn = null;
	Statement stmt = null;

	public connectdt() {
		try {
			Class.forName(JDBC_DRIVER);// 工程要连接额外的jar包
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
}
