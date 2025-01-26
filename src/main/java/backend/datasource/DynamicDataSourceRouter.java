package backend.datasource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
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

    // 主库数据源（写库）
    @Primary
    @Bean
    public DataSource masterDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://47.130.53.29:3306/meeting-for-you")
                .username("root")
                .password("liuxingzhao")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    // 从库数据源配置（读库）
    @Bean(name = "slaveDataSource")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://47.130.53.29:3307/meeting-for-you")
                .username("root")
                .password("liuxingzhao")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
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
