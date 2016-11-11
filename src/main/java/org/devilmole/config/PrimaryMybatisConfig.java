package org.devilmole.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
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
@MapperScan(basePackages = "org.devilmole.mapper.primary",sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimaryMybatisConfig {


    //DataSource配置
    @Bean(name = "primary")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }




    @Bean(name = "primarySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(oracleDataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapping/primary/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }
    @Bean(name = "primaryTransaction")
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(oracleDataSource());
    }
}
