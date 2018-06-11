package pe.edu.cibertec.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
		basePackages = { "pe.edu.cibertec.application.security" },
		entityManagerFactoryRef = "springDataEmbeddedEntityManagerFactory",
		transactionManagerRef = "springDataEmbeddedTransactionManager"
)
@EnableTransactionManagement
public class JpaConfig {

	@Autowired
	private Environment env;

	@Bean
	@Qualifier("springDataEmbeddedDatasource")
	public DataSource embeddedDataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.HSQL).build();
	}
	
	@Bean
	@Qualifier("springDataEmbeddedTransactionManager")
	PlatformTransactionManager springDataEmbeddedTransactionManager(
			@Qualifier("springDataEmbeddedEntityManagerFactory") LocalContainerEntityManagerFactoryBean lcemfb) {
		return new JpaTransactionManager(lcemfb.getObject());
	}
	
	@Bean
	@Qualifier("springDataEmbeddedEntityManagerFactory")
	LocalContainerEntityManagerFactoryBean springDataEmbeddedEntityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(embeddedDataSource());
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPersistenceUnitName("securityPersistenceUnit");
		factoryBean.setPackagesToScan("pe.edu.cibertec.application.security.domain");

		return factoryBean;
	}

}
