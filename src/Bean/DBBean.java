package Bean;
import java.sql.*;
public class DBBean {
	private String driverStr = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String connStr = "jdbc:sqlserver://localhost:1433; DatabaseName=JXP";
	private String dbusername = "root";
	private String dbpassword = "hanhan";
	private Connection conn = null;
	private Statement stmt = null;

	public DBBean()
	{
		try
		{
			Class.forName(driverStr);
			conn = DriverManager.getConnection(connStr, dbusername, dbpassword);
			stmt = conn.createStatement();
		} 
		catch (Exception ex) {
			System.out.println("数据连接失败！");
		} 
		
	}

	public int executeUpdate(String s) {
		int result = 0;
		System.out.println("--更新语句:"+s+"\n");
		try {
			result = stmt.executeUpdate(s);
		} catch (Exception ex) {
			System.out.println("执行更新错误！");
		}
		return result;
	}

	public ResultSet executeQuery(String s) {
		ResultSet rs = null;
		System.out.print("--查询语句:"+s+"\n");
		try {
			rs = stmt.executeQuery(s);
		} catch (Exception ex) {
			System.out.println("ִ执行查询错误！");
		}
		return rs;
	}
	public void execQuery(String s){
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行插入错误！");
		}
	}

	public void close() {
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}
	}
}

