package org.zerock.spring1.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * AOP(Aspect Object Programming) : 관점 지향 프로그래밍이라는 뜻으로 코드를 핵심 비즈니스 기능과 공통 기능으로 나눈 후에 핵심 비즈니스 기능에서 따로 빼놓은 공통 기능을 불러와서 적용하는 방법
 *
 * @EnableAspectJAutoProxy  - 위 어노테이션을 사용하면 AOP를 사용할 수 있다
                            - 최상위 패키지에 있는 클래스에 annotation을 적용해서 AOP를 찾을 수 있게 도와준다.[main method class]
                            - 스프링이 자동으로 개발자의 메소드를 호출하기 전에 가로챌 수 있게 하는 옵션이라고 할 수 있다
 *
 * target : aspect를 적용하는 곳
 * aspect : 추상(로그)
 * advice : 구현클래스
 * pointcut : 결정
 * joinpoint : target의 메소드 (advice가 적용될 위치)
 * advisor : advice + pointcut
 * */

@Configuration
@ComponentScan(basePackages = {"org.zerock.spring1.service","org.zerock.spring1.advice"})
@MapperScan( basePackages = {"org.zerock.spring1.mapper"})
@EnableAspectJAutoProxy //AOP 적용하기 위한 어노테이션 11.12
@EnableTransactionManagement //트랜잭선 관리를 위한 어노테이션 11.13
public class RootConfig {

    //트랜잭션 관리를 위해서 필요한 설정
    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public HikariConfig hikariConfig(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
//        config.setJdbcUrl("jdbc:mariadb://192.168.30.25:3306/webdb");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return config;
    }

    @Bean
    public DataSource dataSource(){
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }


}
