package backend.datasource;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {

    // 读操作：标记 @ReadOperation 注解的方法，使用从库
    @Before("@annotation(ReadOperation)")
    public void setSlaveDataSource() {
        System.out.println("Use slave database");
        DataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE);  // 切换到从库
    }

    // 写操作：标记 @WriteOperation 注解的方法，使用主库
    @Before("@annotation(WriteOperation)")
    public void setMasterDataSource() {
        System.out.println("Use master database");
        DataSourceContextHolder.setDataSourceType(DataSourceType.MASTER);  // 切换到主库
    }

    // 如果没有 @ReadOperation 注解，默认使用主库
    @Before("execution(* backend.mapper.*.*(..)) && !@annotation(ReadOperation)")
    public void defaultMasterDataSource() {
        System.out.println("Use master database");
        DataSourceContextHolder.setDataSourceType(DataSourceType.MASTER);  // 默认切换到主库
    }

    // 方法执行完后清除数据源设置
    // 方法执行完后清除数据源设置
    @After("execution(* backend.mapper.*.*(..))")
    public void clearDataSource() {
        System.out.println("Clear database");
        DataSourceContextHolder.clearDataSourceType();
    }
}

