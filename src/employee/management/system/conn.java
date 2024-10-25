package employee.management.system;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

 Connection connection;
 Statement statement;


 public conn() {


     try{
        Class.forName( "com.mysql.cj.jdbc.Driver" );
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","5773");
        statement = connection.createStatement();


     }catch (Exception e){
         e.printStackTrace();
     }
 }

}
