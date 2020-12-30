package ee.cgi.kk.petmanager.configuration;

import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.ibm.db2.jcc.DB2SimpleDataSource;


@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(basePackages = "ee.cgi.kk.petmanager.repository", entityManagerFactoryRef = "userEntityManager", transactionManagerRef = "userTransactionManager")
public class PersistencePetConfiguration {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hibernateddl;
	@Value("${spring.jpa.database-platform}")
	private String hibernateDialect;

//    @Value("${oracle.ucp.minPoolSize}")
//    private String minPoolSize;
//
//    @Value("${oracle.ucp.maxPoolSize}")
//    private String maxPoolSize;
//
//    @Value("${spring.datasource.driver-class-name:oracle.jdbc.pool.OracleDataSource}")
//    private String driverClassName;



	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
        this.url = url;
	}
//    @Primary
//	@Bean
//	DataSource dataSource() throws SQLException {
//		OracleDataSource dataSource = new OracleDataSource();
//		dataSource.setUser(username);
//		dataSource.setPassword(password);
//		dataSource.setURL(url);
//		dataSource.setImplicitCachingEnabled(true);
//		dataSource.setFastConnectionFailoverEnabled(true);
//		return dataSource;
//	}

    @Primary
	@Bean
	DataSource dataSource() throws SQLException {
		DB2SimpleDataSource dataSource = new DB2SimpleDataSource();
		dataSource.setUser("fcr70463");
		dataSource.setPassword("bfpt9p0fvqnpq^14");
		dataSource.setDatabaseName("BLUDB");
		dataSource.setServerName("dashdb-txn-sbox-yp-lon02-06.services.eu-gb.bluemix.net");
		dataSource.setPortNumber(50000);
		dataSource.setDriverType(4);

		return dataSource;
	}

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean userEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		try {
			em.setDataSource(dataSource());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		em.setPackagesToScan(new String[] { "ee.cgi.kk.petmanager.domain" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", hibernateddl);
		properties.put("hibernate.dialect", hibernateDialect);
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Primary
	@Bean
	public PlatformTransactionManager userTransactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(userEntityManager().getObject());
		return transactionManager;
	}

}




