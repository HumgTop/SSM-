package com.itheima.jdbc;

import java.sql.*;

/*
程序的耦合
 */
public class JdbcDemo1 {
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "root");
            PreparedStatement pstm = conn.prepareStatement("select  * from account");
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
            resultSet.close();
            pstm.close();
            conn.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
