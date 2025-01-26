package backend.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // 返回当前线程的数据库类型（主库或从库）
        return DataSourceContextHolder.getDataSourceType();
    }
}
