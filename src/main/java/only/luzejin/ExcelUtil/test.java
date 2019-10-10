package only.luzejin.ExcelUtil;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import only.luzejin.ExcelUtil.domain.HouseSource;
import only.luzejin.ExcelUtil.utils.HouseSourceExcelHandler;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * 包名称only.luzejin.ExcelUtil
 * 类名称test
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/8/4 21:56
 **/
public class test {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\luzejin\\Desktop\\深圳租房数据（八爪鱼采集）.xlsx");

        ImportParams importParams = new ImportParams();

        HouseSourceExcelHandler handler = new HouseSourceExcelHandler();

        importParams.setDataHandler(handler);

        try{

            List<Object> objects = ExcelImportUtil.importExcel(new FileInputStream(file),
                    HouseSource.class, importParams);
            System.out.println(objects.size());
            for(Object o : objects){
                System.out.println(o);
            }

//            ExcelImportResult<HouseSource> result = ExcelImportUtil.importExcelMore(new FileInputStream(file),
//                    HouseSource.class,importParams);


//            List<HouseSource> successList = result.getList();
//            List<HouseSource> failList = result.getFailList();
//
//
//            for (HouseSource houseSource : successList) {
//                System.out.println(houseSource);
//            }
//            for (HouseSource houseSource : failList) {
//                System.out.println(houseSource.getHouseName() + ": 导入失败");
//            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
