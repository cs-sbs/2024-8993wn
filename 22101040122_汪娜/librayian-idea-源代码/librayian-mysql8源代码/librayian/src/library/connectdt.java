package library;

import java.sql.*;
public class connectdt {//����Ϊ�������ݿ����
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/emp?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
	static final String USER = "root";
	static final String PASS = "root";
	String struser = "username", strpass = "password", strtable1 = "admindt", strtable2 = "books",ID="id";//�������ݿ���emp��admindt
	Connection conn = null;
	Statement stmt = null;

	public connectdt() {
		try {
			Class.forName(JDBC_DRIVER);// ����Ҫ���Ӷ����jar��
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
}
