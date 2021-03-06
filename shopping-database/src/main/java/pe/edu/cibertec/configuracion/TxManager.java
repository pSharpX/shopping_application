package pe.edu.cibertec.configuracion;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by CHRISTIAN on 19/05/2018.
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class TxManager {

    @Autowired
    private Environment env;

    @Value("${database.driverClassName}")
    private String driverClassName;

    @Bean
    @Qualifier("defaultTransactionManager")
    public PlatformTransactionManager defaultTransactionManager(
    		@Qualifier("defaultEntityManagerFactory") LocalContainerEntityManagerFactoryBean lcemfb){
        return new JpaTransactionManager(lcemfb.getObject());
    }
    
    @Bean
    @Qualifier("embeddedTransactionManager")
    public PlatformTransactionManager embeddedTransactionManager(
    		@Qualifier("embeddedEntityManagerFactory") LocalContainerEntityManagerFactoryBean lcemfb){
        return new JpaTransactionManager(lcemfb.getObject());
    }

    @Bean
    @Qualifier("defaultEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean defaultEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
        lcemfb.setDataSource(getDefaultDataSource());
        lcemfb.setPersistenceUnitName("defaultPersistenceUnit");
        lcemfb.setPackagesToScan("pe.edu.cibertec.dominio");
        lcemfb.setJpaProperties(jpaProperties());
        return lcemfb;
    }

    @Bean
    @Qualifier("embeddedEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean embeddedEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
        lcemfb.setDataSource(getEmbeddedDataSource());
        lcemfb.setPersistenceUnitName("defaultPersistenceUnit");
        lcemfb.setPackagesToScan("pe.edu.cibertec.dominio");
        lcemfb.setJpaProperties(getHSQLProperties());
        return lcemfb;
    }

    @Bean
    public JpaVendorAdapter getJpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    @Qualifier("defaultDatasource")
    public DataSource getDefaultDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
        dataSource.setUrl(env.getProperty("database.url"));
        dataSource.setUsername(env.getProperty("database.username"));
        dataSource.setPassword(env.getProperty("database.password"));
        return dataSource;
    }

    @Bean
    @Qualifier("embeddedDatasource")
    public DataSource getEmbeddedDataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }
    
    @Bean
    @Qualifier("embeddedHSQLDatasource")
    public DataSource getHSQLDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("database.hsql.driverClassName"));
        dataSource.setUrl(env.getProperty("database.hsql.url"));
        dataSource.setUsername(env.getProperty("database.hsql.username"));
        dataSource.setPassword(env.getProperty("database.hsql.password"));
        return dataSource;
    }
    
    @Bean
    @Qualifier("HSQLProperties")
    public Properties getHSQLProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("hibernate.hsql.dialect"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hsql.hbm2ddl.auto"));
        //properties.put("hibernate.id.new_generator_mappings", env.getProperty("hibernate.id.new_generator_mappings"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    public Properties jpaProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.id.new_generator_mappings", env.getProperty("hibernate.id.new_generator_mappings"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        return properties;
    }
}
