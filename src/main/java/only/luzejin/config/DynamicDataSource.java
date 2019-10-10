package only.luzejin.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 包名称only.luzejin.config
 * 类名称DynamicDataSource
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/3/28 22:30
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType.DataBaseType dataBaseType = DataSourceType.getDataBaseType();
        return dataBaseType;
    }
}
