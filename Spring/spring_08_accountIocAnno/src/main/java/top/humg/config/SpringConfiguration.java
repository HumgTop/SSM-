package top.humg.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 是一个配置类替代bean.xml的作用
 */
@Configuration
@ComponentScan("top.humg")//创建容器时要扫描的包
@PropertySource("classpath:JdbcConfig.properties")
public class SpringConfiguration {
    @Value("${driverClass}")
    private String driverClass;
    @Value("${jdbcUrl}")
    private String url;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;

    //创建一个QueryRunner对象并存入容器中
    @Bean("queryRunner")
    @Scope("prototype")
    public QueryRunner getRunner(@Qualifier("dataSource01") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean("dataSource01")
    public DataSource getDataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(driverClass);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取连接池失败");
            return null;
        }
    }

    @Bean("dataSource02")
    public DataSource getDataSource02() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(driverClass);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取连接池失败");
            return null;
        }
    }
}
