package org.devilmole.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Configuration
@MapperScan(basePackages = "org.devilmole.mapper.secondary",sqlSessionFactoryRef = "secondarySqlSessionFactory")
public class SecondaryMybatisConfig {


    //DataSource配置
    @Bean(name = "secondary")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "secondarySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mysqlDataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapping/secondary/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }
    @Bean(name = "secondaryTransaction")
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(mysqlDataSource());
    }
}
