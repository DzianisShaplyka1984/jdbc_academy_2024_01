package com.academy;

import static java.sql.JDBCType.VARCHAR;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {

  public static void main(String[] args)
      throws ClassNotFoundException, SQLException, IOException {
    //Class.forName("com.mysql.cj.jdbc.Driver");

    Properties properties = new Properties();

    InputStream inputStream = new FileInputStream("src/main/resources/db.properties");

    properties.load(inputStream);

    Connection connection = DriverManager.getConnection(properties.getProperty("db.url"),properties.getProperty("db.user"),
        properties.getProperty("db.password"));

    String name = "Ivan";

    PreparedStatement statement = connection.prepareStatement("select * from employee where name=?");
    statement.setString(1, name);

    ResultSet result = statement.executeQuery();

    while (result.next()) {
      System.out.println(result.getString("id") + " " + result.getString("name") + " " +  result.getString("job") + " " + result.getString("year"));
    }

//    int result  = statement.executeUpdate("update employee set year = 2010 where id = 10");

    CallableStatement callableStatement = connection.prepareCall("{call employeecount(?)}");
    callableStatement.registerOutParameter(1, VARCHAR);
    callableStatement.execute();

    System.out.println(callableStatement.getInt(1));

    result.close();
    statement.close();
    connection.close();

    System.out.println("Hello world");
  }
}
