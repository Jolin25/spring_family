package top.jrl.springfamily.purejdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author jrl
 * @date Create in 11:24 2022-2-17
 */
public class jdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://47.115.148.27:3306/school4?user=root&password=123456&allowMultiQueries=true");
    }
}
