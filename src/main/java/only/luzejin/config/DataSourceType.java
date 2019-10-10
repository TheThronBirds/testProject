package only.luzejin.config;

/**
 * 包名称only.luzejin.config
 * 类名称DataSourceType
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/3/28 22:31
 **/
public class DataSourceType {

    public enum DataBaseType{
        TEST01,
        TEST02
    }

    private static final ThreadLocal<DataBaseType> TYPE = new ThreadLocal<DataBaseType>();

    /**
     * 设置数据源类型
     * @param dataBaseType
     */
    public static void setDataBaseType(DataBaseType dataBaseType) {
        if (dataBaseType == null) {
            throw new NullPointerException();
        }
        System.err.println("[将当前数据源改为]：" + dataBaseType);
        TYPE.set(dataBaseType);
    }


    /**
     * 获取数据源类型
     * @return
     */
    public static DataBaseType getDataBaseType() {
        DataBaseType dataBaseType = TYPE.get() == null ? DataBaseType.TEST01 : TYPE.get();
        System.err.println("[获取当前数据源的类型为]：" + dataBaseType);
        return dataBaseType;
    }

    public static void clearDataBaseType() {
        TYPE.remove();
    }
}
