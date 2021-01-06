package com.example.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchExecute {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:3306/employees?characterEncoding=utf-8&useSSL=false",
                            "root", "123456");

            connection.setAutoCommit(false);
            PreparedStatement cmd = connection
                    .prepareStatement("insert into wyc_test('name', 'date', 'scount') values(?,?,?)");

            for (int i = 0; i < 500; i++) {
                cmd.setInt(1, i);
                cmd.setString(2, "2020-01-01");
                cmd.setInt(3, 3000);
                cmd.addBatch();
            }
            cmd.executeBatch();
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
