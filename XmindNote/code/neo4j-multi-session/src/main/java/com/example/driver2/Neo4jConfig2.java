package com.example.driver2;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

import static com.example.driver2.Neo4jConfig2.*;

/**
 * @author admin
 */
@Configuration
@EnableNeo4jRepositories(
        sessionFactoryRef = SESSION_FACTORY,
        transactionManagerRef = TRANSACTION_MANGER,
        basePackages = BASE_PACKAGE,
        sessionBeanName = SESSION_BEAN_NAME
)
public class Neo4jConfig2 {
    public static final String SESSION_FACTORY = "sessionFactory2";
    public static final String SESSION_BEAN_NAME = "aSessionToInstance2";
    public static final String TRANSACTION_MANGER = "transactionManager2";

    // 驱动位置
    static final String BASE_PACKAGE = "com.example.driver2";

    /**
     * 从配置拿到属性，属性映射到对象
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.data.neo4j.domain")
    public Neo4jProperties neo4jPropertiesDomain2(){
        return new Neo4jProperties();
    }

    /**
     * 获取驱动配置，生成配置对象
     * @return
     */
    @Bean
    public org.neo4j.ogm.config.Configuration ogmConfigurationDomain2(){
        return neo4jPropertiesDomain2().createConfiguration();
    }

    /**
     * 根据驱动配置，用配置对象生成连接池
     * @return
     */
    @Bean(name = SESSION_FACTORY)
    public SessionFactory sessionFactory(){
        return new SessionFactory(ogmConfigurationDomain2(),BASE_PACKAGE);
    }

    /**
     * 生成连接池管理器
     * @return
     */
    @Bean(name = TRANSACTION_MANGER)
    public Neo4jTransactionManager neo4jTransactionManager(){
        return new Neo4jTransactionManager(sessionFactory());
    }

}
