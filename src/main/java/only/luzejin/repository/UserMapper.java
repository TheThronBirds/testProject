package only.luzejin.repository;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * 包名称only.luzejin.repository
 * 接口名称UserMapper
 * 接口描述 TODO
 * 创建人luzejin
 * 创建时间2019/3/29 12:42
 **/
@Repository
public interface UserMapper {

    @Select("<script> select name from student </script>")
    public Set<String> getAllUserNameSet();

    @Select("<script> select name,school from student </script>")
    public List<String> getAllUserName();
}
