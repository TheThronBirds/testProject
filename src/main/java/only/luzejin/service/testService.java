package only.luzejin.service;

import only.luzejin.Annotation.dynamicSourceMain;
import only.luzejin.Annotation.dynamicSourceSub;
import only.luzejin.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 包名称only.luzejin.service
 * 类名称testService
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/3/29 12:36
 **/
@Service
public class testService {

    @Autowired
    private UserMapper userMapper;

    @dynamicSourceMain
    public List<String> getAllName(){
        return userMapper.getAllUserName();
    }
}
