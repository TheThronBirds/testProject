import lombok.extern.slf4j.Slf4j;
import only.luzejin.ProjectApplication;
import only.luzejin.repository.UserMapper;
import only.luzejin.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

/**
 * 包名称PACKAGE_NAME
 * 类名称test
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/3/18 23:15
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProjectApplication.class)
@Slf4j
public class test1 {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        Set<String> names = userMapper.getAllUserNameSet();

        for(String name:names){
            System.out.println(name);
        }

    }
}
