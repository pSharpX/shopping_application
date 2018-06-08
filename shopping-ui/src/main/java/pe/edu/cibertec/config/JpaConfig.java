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
		entityManagerFactoryRef = "embeddedEntityManagerFactory",
		transactionManagerRef = "embeddedTransactionManager"
)
@EnableTransactionManagement
public class JpaConfig {

	@Autowired
	private Environment env;

	@Bean
	@Qualifier("embeddedDatabase")
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.HSQL).build();
	}
	
	@Bean
	PlatformTransactionManager embeddedTransactionManager(
			@Qualifier("embeddedEntityManagerFactory") LocalContainerEntityManagerFactoryBean lcemfb) {
		return new JpaTransactionManager(lcemfb.getObject());
	}
	
	@Bean
	@Qualifier("embeddedEntityManagerFactory")
	LocalContainerEntityManagerFactoryBean embeddedEntityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan("pe.edu.cibertec.application.security.domain");

		return factoryBean;
	}

}
