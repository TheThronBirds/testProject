package only.luzejin.plugin;

/**
 * 包名称only.luzejin.plugin
 * 类名称tenant
 * 类描述 租户bean
 * 创建人luzejin
 * 创建时间2019/8/17 19:26
 **/
public class tenant {

    private String tenantId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public tenant(String id){
        this.tenantId = id;
    }
}
