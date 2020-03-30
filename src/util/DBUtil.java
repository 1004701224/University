package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DBUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/test1?serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PWD = "123456";
	public static Connection conn = null;
	public static Statement st = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
//		return DriverManager.getConnection(URL,USERNAME,PWD);

        Connection con = null;
        try {
            Context ctx = new InitialContext();  //   获取context.xml文件

            DataSource ds= (DataSource)ctx.lookup("java:comp/env/student");

            con = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return con;
	}

	public static PreparedStatement createPreparedStatement(String sql,Object[] params) throws SQLException, ClassNotFoundException {
		conn = getConnection();
		ps = conn.prepareStatement(sql);

		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1, params[i]);
			}
		}
		return ps;
	}

	public static void closeAll(ResultSet rs,Statement ps,Connection conn) {
		try {
			if(rs != null)rs.close();
			if(ps != null)ps.close();
			if(conn != null)conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//增删改
	public static boolean excuteUpdate(String sql,Object[] params) {
		try {
			ps = createPreparedStatement(sql, params);
			int count = ps.executeUpdate();
			if(count>0) {
				return true;
			}else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			closeAll(null, ps, conn);
		}
	}


	//查
	public static ResultSet executeQuery(String sql,Object[] params) {

		try {
			ps = createPreparedStatement(sql, params);
			rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int getTotalCount(String sql) {
		int count = -1;
		try {
			ps = createPreparedStatement(sql, null);
			rs = ps.executeQuery();

			if(rs.next()) {
				count = rs.getInt(1);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, ps, conn);
		}
		return count;
	}

}

