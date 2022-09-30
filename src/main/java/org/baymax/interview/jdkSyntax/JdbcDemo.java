package org.baymax.interview.jdkSyntax;

import java.sql.*;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2021/3/30 11:13
 */
public class JdbcDemo {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");//加载及注册JDBC驱动程序
    String url = "jdbc:mysql://localhost:3306/baymax_dev?user=root&password=";
    Connection con = DriverManager.getConnection(url);
    Statement stmt = con.createStatement();
    String query = "select * from xdc";
    ResultSet rs=stmt.executeQuery(query);
    while(rs.next()) {
      System.out.println(rs.getString("name")+" 年龄："+rs.getInt("age"));

    }
  }
}
