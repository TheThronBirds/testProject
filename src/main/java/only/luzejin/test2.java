package only.luzejin;

import java.sql.*;

/**
 * 包名称only.luzejin
 * 类名称test2
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/3/18 23:39
 **/
public class test2 {

    public static void main(String[] args) throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.199.152:1521:orcl", "kminer", "123");

        conn.setAutoCommit(false);

        Statement s = conn.createStatement();

        boolean flag = s.execute("update student set name = 'luzejinzuishuai' where id = 24");
        conn.commit();
        System.out.println(flag);
        PreparedStatement ps1 = conn.prepareStatement("select * from student");

        ResultSet rs = ps1.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("name") + "1111");
        }

    }
}
