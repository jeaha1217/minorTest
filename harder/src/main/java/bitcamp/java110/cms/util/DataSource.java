package bitcamp.java110.cms.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class DataSource {
    private final String url = "jdbc:mariadb://localhost:3306/studydb";
    private final String user = "study";
    private final String pwd = "1111";
    Connection con;
    
    public Connection getConnection() throws Exception{
        if(con == null) {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);
        }
        return this.con;
    }
    
    public void getCloseConnection() {
        try {
            con.close();
        }   catch(Exception e) {
            System.out.println("Can't Closed Connection.");
            e.getMessage();
        }
    }
}
