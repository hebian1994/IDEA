package com.how2java.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtils {
    /**
     * 获取连接
     *
     */
    public static Connection getConnection()
    {
        String driverName = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/itxzxy?characterEncoding=utf8";
        String user = "root" ;
        String password = "admin";
        Connection con = null ;
        try {

            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con ;

    }

    /**
     * 关闭连接
     */
    public static void free(ResultSet rs, Statement sta , Connection con)
    {
        try {
            if(null != rs)
            {
                rs.close();
                rs = null ;
            }

            if(null != sta)
            {
                sta.close();
                sta = null ;
            }

            if(null != con)
            {
                con.close();
                con = null ;
            }
            System.out.println("数据库关闭成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
