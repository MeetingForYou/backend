package backend.datasource;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceRouter {

    // 主库配置
    @Value("${spring.datasource.master.url}")
    private String masterUrl;

    @Value("${spring.datasource.master.username}")
    private String masterUsername;

    @Value("${spring.datasource.master.password}")
    private String masterPassword;

    @Value("${spring.datasource.master.driver-class-name}")
    private String masterDriverClassName;

    // 从库配置
    @Value("${spring.datasource.slave.url}")
    private String slaveUrl;

    @Value("${spring.datasource.slave.username}")
    private String slaveUsername;

    @Value("${spring.datasource.slave.password}")
    private String slavePassword;

    @Value("${spring.datasource.slave.driver-class-name}")
    private String slaveDriverClassName;

    // 连接池配置
    @Value("${spring.datasource.hikari.minimum-idle}")
    private int minimumIdle;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private int maximumPoolSize;

    @Value("${spring.datasource.hikari.pool-name}")
    private String poolName;

    @Value("${spring.datasource.hikari.idle-timeout}")
    private long idleTimeout;

    @Value("${spring.datasource.hikari.max-lifetime}")
    private long maxLifetime;

    // 主库连接池
    @Primary
    @Bean(name = "masterDataSource")
    public DataSource masterDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(masterUrl);
        config.setUsername(masterUsername);
        config.setPassword(masterPassword);
        config.setDriverClassName(masterDriverClassName);
        config.setMinimumIdle(minimumIdle);
        config.setMaximumPoolSize(maximumPoolSize);
        config.setPoolName(poolName);
        config.setIdleTimeout(idleTimeout);
        config.setMaxLifetime(maxLifetime);
        return new HikariDataSource(config);
    }

    // 从库连接池
    @Bean(name = "slaveDataSource")
    public DataSource slaveDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(slaveUrl);
        config.setUsername(slaveUsername);
        config.setPassword(slavePassword);
        config.setDriverClassName(slaveDriverClassName);
        config.setMinimumIdle(minimumIdle);
        config.setMaximumPoolSize(maximumPoolSize);
        config.setPoolName(poolName + "_Slave");
        config.setIdleTimeout(idleTimeout);
        config.setMaxLifetime(maxLifetime);
        return new HikariDataSource(config);
    }

    // 动态数据源
    @Bean
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource()); // 默认使用主库
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER, masterDataSource());
        targetDataSources.put(DataSourceType.SLAVE, slaveDataSource());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }

    // MyBatis SqlSessionFactory 配置
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    // MyBatis SqlSessionTemplate 配置
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
