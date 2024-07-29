package com.hmw.jsp.wifi.db;

import java.sql.*;

public class DBConnect {

    public Connection connectionDB() {
        String url = "jdbc:mariadb://localhost:3306/publicWifiDB";
        String user = "wifiUser";
        String password = "zerobase";

        Connection connection = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");  //JDBC 드라이버 로드
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void close(Connection c, PreparedStatement ps, ResultSet rs) {

        try {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
