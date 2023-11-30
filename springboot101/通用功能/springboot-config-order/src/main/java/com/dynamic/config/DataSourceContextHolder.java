package com.dynamic.config;

/**
 * ThreadLocal存放数据源变量
 *
 * @author 公众号：程序员小富
 * @date 2023/11/27 11:02
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> DATASOURCE_HOLDER = new ThreadLocal<>();

    /**
     * 获取当前线程的数据源
     *
     * @return 数据源名称
     */
    public static String getDataSource() {
        return DATASOURCE_HOLDER.get();
    }

    /**
     * 设置数据源
     *
     * @param dataSourceName 数据源名称
     */
    public static void setDataSource(String dataSourceName) {
        DATASOURCE_HOLDER.set(dataSourceName);
    }

    /**
     * 删除当前数据源
     */
    public static void removeDataSource() {
        DATASOURCE_HOLDER.remove();
    }
}