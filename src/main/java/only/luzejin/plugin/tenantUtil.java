package only.luzejin.plugin;

/**
 * 包名称only.luzejin.plugin
 * 类名称tenantUtil
 * 类描述 多租户模式工具类
 * 创建人luzejin
 * 创建时间2019/8/17 19:25
 **/
public class tenantUtil {

    private static final ThreadLocal<tenant> tenant_local = new ThreadLocal<tenant>();


    public static void clearTenant(){
        tenant_local.remove();
    }

    public static void setTenant(tenant tenant){
        tenant_local.set(tenant);
    }

    public static tenant getTenant(){
        return tenant_local.get();
    }

    public void tenantId(String id){
        tenant t = new tenant(id);
        setTenant(t);
    }
}
