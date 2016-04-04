package step28;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class Test01 {

  public static void main(String[] args) throws Exception {
    DriverManager.deregisterDriver(new Driver());
    
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/java80db?user=java80&password=1111");
    System.out.println("연결 성공!");
    con.close();
  }

}
