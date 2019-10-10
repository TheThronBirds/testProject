package only.luzejin.config;

import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 包名称only.luzejin.config
 * 类名称MybatisConfig
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/9/21 13:46
 **/
@Configuration
public class MybatisConfig {

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory getSqlsessionFactory(@Qualifier("dynamicDataSource") DataSource dataSource) throws Exception{

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCacheEnabled(false);
        configuration.setLocalCacheScope(LocalCacheScope.STATEMENT);
        configuration.setLogPrefix("Mybatis");
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));

        return sqlSessionFactoryBean.getObject();

    }
}
