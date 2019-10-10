package only.luzejin.Controller;

import lombok.extern.slf4j.Slf4j;
import only.luzejin.plugin.tenant;
import only.luzejin.plugin.tenantUtil;
import only.luzejin.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 包名称only.luzejin.Controller
 * 类名称testController
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/3/29 12:34
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class testController {

    @Autowired
    private testService testService;

    @RequestMapping("test1")
    public void test1(){
        List<String> names =  testService.getAllName();
        log.info(names.toString());
    }

    @RequestMapping("test2")
    public void test2(){
        tenant t = new tenant("WUDX");
        tenantUtil.setTenant(t);
        List<String> names = testService.getAllName();

        log.info(names.toString());
    }
}



