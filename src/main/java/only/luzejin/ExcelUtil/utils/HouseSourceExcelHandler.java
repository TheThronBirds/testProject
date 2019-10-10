package only.luzejin.ExcelUtil.utils;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import only.luzejin.ExcelUtil.domain.HouseSource;

/**
 * 包名称only.luzejin.ExcelUtil.utils
 * 类名称HouseSourceExcelHandler
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/8/4 21:51
 **/
public class HouseSourceExcelHandler extends ExcelDataHandlerDefaultImpl<HouseSource> {

    @Override
    public Object importHandler(HouseSource obj,String name,Object value){

        System.out.println("导入房源信息");

        return super.importHandler(obj,name,value);

    }
}
