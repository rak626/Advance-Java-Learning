package org.rakesh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FirstJDBC {
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

            String q = "create table table1(tID int(30) primary key auto_increment," +
                    " tName varchar(200) not null , " +
                    "tCity varchar(400))";

            //create statement
            Statement statement = con.createStatement();
            //execute statement
            statement.executeUpdate(q);

            System.out.println("table created in DB..............");

            //closing connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
