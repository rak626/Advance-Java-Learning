package org.rakesh.JDBC;

import java.io.FileInputStream;
import java.sql.*;

public class InsertImage {
    public static void main(String[] args) {
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // create a connection
            String url = "jdbc:mysql://localhost:3306/jdbc_project";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password);

            //check connection is still open or not
            if (con.isClosed()) {
                System.out.println("Connection is closed.........");
            } else {
                System.out.println("Connection is open...........");
            }

            // create a query

            String query = "insert into images(pic) values(?)";

            //create prepared Statement
            PreparedStatement preparedStatement = con.prepareStatement(query);

            //inserting image
            FileInputStream fileInputStream = new FileInputStream("D:\\VOLUME_D\\IntellijProject\\Advance_Java_Learning\\src\\main\\resources\\Images\\IMG_0803.jpg");
            preparedStatement.setBinaryStream(1, fileInputStream, fileInputStream.available());

            preparedStatement.executeUpdate();

            System.out.println("table created in DB..............");

            //closing connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
