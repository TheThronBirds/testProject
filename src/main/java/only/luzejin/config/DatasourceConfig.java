package only.luzejin.config;

import com.zaxxer.hikari.HikariDataSource;
import only.luzejin.plugin.tenantInterceptor;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * 包名称only.luzejin.config
 * 类名称DatasourceConfig
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/3/18 22:58
 **/
@Configuration
public class DatasourceConfig {


    @Value("${luzejin.data.maxPoolSize:100}")
    private int maxPoolSize;
    @Value("${luzejin.data.minIdle:50}")
    private int minIdle;

    /*@Primary
    @Bean("dataSource1")
    @ConfigurationProperties("luzejin.dataSource1")
    public DataSource getDataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Bean("dataSource2")
    @ConfigurationProperties("luzejin.dataSource2")
    public DataSource getDataSource2(){
        return DataSourceBuilder.create().build();
    }*/

    @Primary
    @Bean("dataSource1")
    @ConfigurationProperties("luzejin.dataSource1")
    public DataSource getDataSource1(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setMaximumPoolSize(maxPoolSize);
        hikariDataSource.setMinimumIdle(minIdle);
        return hikariDataSource;
    }

    @Bean("dataSource2")
    @ConfigurationProperties("luzejin.dataSource2")
    public DataSource getDataSource2(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setMaximumPoolSize(maxPoolSize);
        hikariDataSource.setMinimumIdle(minIdle);
        return hikariDataSource;
    }


    @Bean(name = "dynamicDataSource")
    public DynamicDataSource DataSource(@Qualifier("dataSource1") DataSource test1DataSource,
                                        @Qualifier("dataSource2") DataSource test2DataSource) {
        Map<Object, Object> targetDataSource = new HashMap<Object,Object>();
        targetDataSource.put(DataSourceType.DataBaseType.TEST01, test1DataSource);
        targetDataSource.put(DataSourceType.DataBaseType.TEST02, test2DataSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(test1DataSource);
        return dataSource;
    }

    @Bean
    public tenantInterceptor gettenantInterceptor(){
        tenantInterceptor interceptor = new tenantInterceptor();
        Properties properties = new Properties();
        properties.setProperty("name","luzejin");
        interceptor.setProperties(properties);
        return  interceptor;
    }


    @Bean(value = "riskJdbcOpreation")
    @Primary
    public JdbcOperations riskJdbcOperation(){
        return new JdbcTemplate(getDataSource1());
    }

    @Bean(value = "fmpJdbcOperation")
    public JdbcOperations fmpJdbcOperation(){
        return new JdbcTemplate(getDataSource2());
    }

    @Bean("fmpTransactionManager")
    public PlatformTransactionManager fmpTransactionManager(){
        return new DataSourceTransactionManager(getDataSource2());
    }

    @Bean("riskTransactionManager")
    @Primary
    public PlatformTransactionManager riskTransactionManager(){
        return new DataSourceTransactionManager(getDataSource1());
    }


}
