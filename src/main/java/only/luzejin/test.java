package only.luzejin;

import only.luzejin.protostuff.utils.Company;
import only.luzejin.protostuff.utils.Department;
import only.luzejin.protostuff.utils.SerializeUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 包名称only.luzejin
 * 类名称test
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/3/18 23:13
 **/
@SpringBootApplication
public class test {

    public static void main(String[] args) throws Exception {
        Company company = new Company();
        company.setCompanyName("赢和");
        company.setCompanyDetail("深圳");

        List<Department> departmentList = new ArrayList<Department>();

        Department department1 = new Department("风控",20);
        Department department2 = new Department("场外",20);

        departmentList.add(department1);
        departmentList.add(department2);

        company.setJson("fr=jifrinrfnrinjdiqdjifjeifneifenivneinveneininidiwdnnre,{1212:'111'},dkeofekofkrjgrgrrmgrmgeoefowmfowmwm" +
                "fefjfigignefwofkwfkfkewfkewfkwfkewfgirienrengre bje enem rem ok wkpclewpclewclwelcwnvrenvjncwivnwvunrgjrgjsods");

        byte[] bytes = SerializeUtil.serialize(company);

        System.out.println(bytes.length);

        Class.forName("oracle.jdbc.driver.OracleDriver");



        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kminer", "123");

        conn.setAutoCommit(false);

        Statement s = conn.createStatement();

        PreparedStatement preparedStatement = conn.prepareStatement("insert into test values (?,?)");

        preparedStatement.setString(1,"22");
        preparedStatement.setBytes(2,bytes);

        preparedStatement.execute();

        conn.commit();

        /*Company company1 = SerializeUtil.deserialize(bytes,Company.class);

        System.out.println(company1.getCompanyDetail());

        System.out.println(company1.getDepartmentList().get(0).getDepartMentName());*/

    }


}
