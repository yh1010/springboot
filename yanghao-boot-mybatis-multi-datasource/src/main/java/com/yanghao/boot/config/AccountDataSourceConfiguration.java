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
 * @create 2020-03-20 0:26
 * @Description: 配置数据源的sessionFactory
 */
@Configuration
@MapperScan(basePackages = {"com.yanghao.boot.mapper.account"}, sqlSessionFactoryRef = "accountSqlSessionFactory")
public class AccountDataSourceConfiguration {

    public static final String MAPPER_XML_LOCATION = "classpath*:com/yanghao/boot/mapper/account/xml/*.xml";

    @Autowired
    @Qualifier("AccountDataSource")
    DataSource accountDataSource;

    /**
     * 配置sql session工厂
     */
    @Bean
    public SqlSessionFactory accountSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(accountDataSource);
        //指定xml文件路径
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置sql session模板
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(accountSqlSessionFactory());
    }

    /**
     * 配置事务
     */
    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(accountDataSource);
    }

}
