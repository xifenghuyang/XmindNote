package com.example.driver1;

import org.neo4j.ogm.driver.Driver;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import static com.example.driver1.Neo4jConfig1.*;

/**
 * @author admin
 */
@Configuration
@EnableNeo4jRepositories(
        sessionFactoryRef = SESSION_FACTORY,
        transactionManagerRef = TRANSACTION_MANGER,
        basePackages = BASE_PACKAGE
)
public class Neo4jConfig1 {
    public static final String SESSION_FACTORY = "sessionFactory1";
    public static final String TRANSACTION_MANGER = "transactionManager1";

    // 驱动位置
    static final String BASE_PACKAGE = "com.example.driver1";

    /**
     * 从配置拿到属性，属性映射到对象
     * @return
     */
    @Primary
    @Bean
    @ConfigurationProperties("spring.data.neo4j")
    public Neo4jProperties neo4jPropertiesDomain1(){
        return new Neo4jProperties();
    }

    /**
     * 获取驱动配置，生成配置对象
     * @return
     */
    @Primary
    @Bean
    public org.neo4j.ogm.config.Configuration ogmConfigurationDomain1(){
        return neo4jPropertiesDomain1().createConfiguration();
    }

    /**
     * 根据驱动配置，用配置对象生成连接池
     * @return
     */
    @Primary
    @Bean(name = SESSION_FACTORY)
    public SessionFactory sessionFactory(){
        return new SessionFactory(ogmConfigurationDomain1(),BASE_PACKAGE);
    }

    /**
     * 生成连接池管理器
     * @return
     */
    @Bean(name = TRANSACTION_MANGER)
    public Neo4jTransactionManager neo4jTransactionManager(){
        return new Neo4jTransactionManager(sessionFactory());
    }

    @Bean("neo4jTemplate")
    public TransactionTemplate neo4jTransactionTemplate(){
        Driver aaa = sessionFactory().getDriver();
        return new TransactionTemplate(neo4jTransactionManager());
    }

}
