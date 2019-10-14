package only.luzejin.service;

import lombok.extern.slf4j.Slf4j;
import only.luzejin.Annotation.dynamicSourceMain;
import only.luzejin.Annotation.dynamicSourceSub;
import only.luzejin.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 包名称only.luzejin.service
 * 类名称testService
 * 类描述 测试服务类
 * 创建人luzejin
 * 创建时间2019/3/29 12:36
 **/
@Service
@Slf4j
public class testService {


    @Autowired
    @Qualifier("fmpJdbcOperation")
    //@Resource(name = "fmpJdbcOperation")
    private JdbcOperations jdbcOperations;


    public void test(){
        try{
            SqlRowSet sqlRowSet =  jdbcOperations.queryForRowSet("select * from student");
            while(sqlRowSet.next()){
                log.info("name:{}",sqlRowSet.getString("NAME"));
            }
        }catch (Exception e){
            log.error("查询错误{}",e.getMessage());
        }

    }
}
