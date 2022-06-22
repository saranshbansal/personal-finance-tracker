package com.banking.financeapp.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.session.jdbc.config.annotation.SpringSessionDataSource;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static com.banking.financeapp.configuration.PftDatasourceConfig.DOMAIN_REPO_PACKAGE;
import static java.util.Collections.singletonMap;
import static java.util.TimeZone.getTimeZone;
import static java.util.TimeZone.setDefault;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = DOMAIN_REPO_PACKAGE,
		entityManagerFactoryRef = "pftEntityManagerFactory", transactionManagerRef = "pftTransactionManager")
@EnableJdbcHttpSession
public class PftDatasourceConfig {
	public static final String DEFAULT_TIME_ZONE = "Europe/London";

	static final String DOMAIN_REPO_PACKAGE = "com.banking.financeapp.repository";
	static final String DOMAIN_ENTITY_PACKAGE = "com.banking.financeapp.domain.entity";
	static final String PERSISTENT_UNIT_NAME = "PG_PFT";

	@Value("${pft.datasource.dialect:org.hibernate.dialect.PostgreSQL92Dialect}")
	private String dialect;

	@Bean(name = "pftEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean pftEntityManagerFactory(
			EntityManagerFactoryBuilder builder, @Qualifier("pftDataSource") DataSource dataSource
	) {
		return builder
				.dataSource(dataSource)
				.packages(DOMAIN_ENTITY_PACKAGE)
				.persistenceUnit(PERSISTENT_UNIT_NAME)
				.properties(singletonMap("hibernate.dialect", dialect))
				.build();
	}

	@Bean(name = "pftTransactionManager")
	public PlatformTransactionManager pftTransactionManager(
			@Qualifier("pftEntityManagerFactory") EntityManagerFactory entityManagerFactory
	) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Bean(name = "pftDataSource")
	@SpringSessionDataSource
	@ConfigurationProperties(prefix = "pft.datasource")
	public DataSource pftDataSource() {
		setDefault(getTimeZone(DEFAULT_TIME_ZONE));
		return DataSourceBuilder.create().build();
	}
}
