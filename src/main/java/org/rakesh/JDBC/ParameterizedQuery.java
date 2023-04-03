package org.rakesh.JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ParameterizedQuery {
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

            //parameterised query
            String q = "insert into table1(tName, tCity) values(?,?)";

            //prepared statement object creation
            PreparedStatement preparedStatement = con.prepareStatement(q);

            //setup buffer reader for taking input from user

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter name : ");
            String name = bufferedReader.readLine();

            System.out.println("Enter City :");
            String city = bufferedReader.readLine();


            //set the values to query
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,city);

            preparedStatement.executeUpdate(); // don't pass query again, it will send as new query

            System.out.println("Data inserted .....");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
