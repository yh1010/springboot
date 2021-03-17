package com.yanghao.boot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @author yanghao
 * @create 2020-03-20 0:48
 * @Description: 配置数据源的sqlSessionFactory
 */
@Configuration
@MapperScan(basePackages = {"com.yanghao.boot.mapper.redaccount"}, sqlSessionFactoryRef = "redPacketSqlSessionFactory")
public class RedPacketDataSourceConfiguration {

    public static final String MAPPER_XML_LOCATION = "classpath*:com/yanghao/boot/mapper/redaccount/xml/*.xml";

    @Autowired
    @Qualifier("RedPacketDataSource")
    DataSource redPacketDataSource;

    /**
     * 配置sql session工厂
     */
    @Bean
    public SqlSessionFactory redPacketSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(redPacketDataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_LOCATION));
        return factoryBean.getObject();
    }

    /**
     * 配置sql session模板
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(redPacketSqlSessionFactory());
    }

    /**
     * 配置事务
     */
    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(redPacketDataSource);
    }
}
