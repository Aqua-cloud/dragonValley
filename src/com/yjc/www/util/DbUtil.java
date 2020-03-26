package com.yjc.www.util;

import java.sql.*;

public class DbUtil {

    //数据库地址
    private static String url = "jdbc:mysql://localhost:3306/valley";
    //用户名
    private static String username = "root";
    //密码
    private static String password = "1234";
    //驱动名称
    private static String jdbcName = "com.mysql.jdbc.Driver";

    /*
     获取数据库连接
     */
    public static Connection getConn() {
        try {
            Class.forName(jdbcName);
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (Exception e) {
            throw new RuntimeException("获取数据库连接失败", e);
        }

    }

    /*
     关闭连接
     */
    public static void close(Connection conn, PreparedStatement st, ResultSet rs)  {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
