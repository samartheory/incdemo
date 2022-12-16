//import org.apache.log4j.BasicConfigurator;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.logging.Logger;
public class Main {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        try {
            Properties props = new Properties();
//        InputStream ins = new FileInputStream("employee.properties");
//        props.load(ins);
            Connection con;
            Class.forName(("com.mysql.cj.jdbc.Driver"));
            System.out.println("hello");

            con = DriverManager.getConnection(
                    ("jdbc:mysql://localhost:3306/employee"),
                    ("root"),
                    ("my5qlpass")
            );


            Statement stmt = con.createStatement();
//            insert(con);
            ResultSet rs = stmt.executeQuery("select * from employee");

            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
    public static void insert(Connection con) throws SQLException {
        System.out.println("inserting");
        Statement stmt=con.createStatement();
        stmt.executeUpdate("insert into employee values(11,\"kishou\",45)");
    }
}
