package com.yanghao.boot.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

/**
 * @author yanghao
 * @create 2020-03-20 0:06
 * @Description: 配置数据源
 */
@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfiguration {

    /**
     * account数据配置的前缀
     */
    final static String ACCOUNT_PREFIX = "spring.datasource.druid.account";
    /**
     * redpacket数据库配置前缀.
     */
    final static String REDPACKET_PREFIX = "spring.datasource.druid.redpacket";

    /**
     * 配置account数据源
     * @return
     */
    @Bean(name = "AccountDataSource")
    @ConfigurationProperties(prefix = ACCOUNT_PREFIX)
    public DataSource accountDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 配置redPacket数据源
     * @return
     */
    @Bean(name = "RedPacketDataSource")
    @ConfigurationProperties(prefix = REDPACKET_PREFIX)
    public DataSource redPacketDatasource(){
        return DruidDataSourceBuilder.create().build();
    }
}
