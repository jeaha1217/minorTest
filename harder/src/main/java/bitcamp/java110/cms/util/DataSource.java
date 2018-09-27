package bitcamp.java110.cms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
    Connection con;
    
    public DataSource (String driver, String url,
            String username, String password) throws Exception {
        Class.forName(driver);
        con = DriverManager.getConnection(url, username, password);
    }
    
    public Connection getConnection() {
        return this.con;
    }
}
/*
 취업 최소 프로그래밍 요구조건.
 "왜 하는지 의미를 알고" 어디에 무엇을 어떻게 복붙 해야 하는지 아는 것.
*/