package ee.cgi.kk.petmanager.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

//@Configuration
//@EnableMongoRepositories("demo.mongo.model")
//public class PersistenceMongoConfiguration extends AbstractMongoConfiguration {
//	@Value("${spring.profiles.active}")
//	private String profileActive;
//
//	@Value("${spring.application.name}")
//	private String proAppName;
//
//	@Value("${spring.data.mongodb.host}")
//	private String mongoHost;
//
//	@Value("${spring.data.mongodb.port}")
//	private String mongoPort;
//
//	@Value("${spring.data.mongodb.database}")
//	private String mongoDB;
//
//	@Override
//	public MongoMappingContext mongoMappingContext() throws ClassNotFoundException {
//		// TODO Auto-generated method stub
//		return super.mongoMappingContext();
//	}
//
//	@Bean
//	public Mongo mongo() throws Exception {
//		return new MongoClient(mongoHost + ":" + mongoPort);
//	}
//
//	@Override
//	protected String getDatabaseName() {
//		// TODO Auto-generated method stub
//		return mongoDB;
//	}
//
//	@Override
//	public MongoClient mongoClient() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}

@Configuration
@EnableMongoRepositories(basePackages = { "ee.cgi.kk.petmanager.repository" })
@ComponentScan(basePackages = { "ee.cgi.kk.petmanager.domain.*" })
@PropertySource("classpath:application.properties")
public class PersistenceMongoConfiguration extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.database}")
	private String database;
	@Value("${spring.data.mongodb.host}")
	private String host;
	@Value("${spring.data.mongodb.port}")
	private String port;
//    @Value("${com.frugalis.mongo.username}")
//    private String username;
//    @Value("${com.frugalis.mongo.password}")
//    private String password;

	@Override
	protected String getDatabaseName() {
		return database;
	}

	@Override
	protected String getMappingBasePackage() {
		return "ee.cgi.kk.petmanager.domain";
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoClient(), getDatabaseName());
	}

	@Override
	@Bean
	public MongoClient mongoClient() {

		List<MongoCredential> allCred = new ArrayList<MongoCredential>();
		// System.out.println("???????????????????"+username+" "+database+" "+password+"
		// "+host+" "+port);
		// allCred.add(MongoCredential.createCredential(username, database,
		// password.toCharArray()));
		MongoClient client = new MongoClient((new ServerAddress(host, Integer.parseInt(port))), allCred);
		client.setWriteConcern(WriteConcern.ACKNOWLEDGED);

		return client;
	}
}





//=======================================================================
//@Configuration
//@PropertySource({ "classpath:application.properties" })
////@EnableJpaRepositories(basePackages = "ee.cgi.kk.petmanager.domain", entityManagerFactoryRef = "productEntityManager", transactionManagerRef = "productTransactionManager")
//public class PersistenceMongoConfiguration {
//	@Autowired
//	private Environment env;
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean productEntityManager() {
//		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//		em.setDataSource(productDataSource());
//		em.setPackagesToScan(new String[] { "ee.cgi.kk.petmanager.domain.product" });
//
////		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
////		em.setJpaVendorAdapter(vendorAdapter);
////		HashMap<String, Object> properties = new HashMap<>();
////		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
////		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
////		em.setJpaPropertyMap(properties);
//
//		return em;
//	}
//
//	@Bean
//	public DataSource productDataSource() {
//
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		// dataSource.setDriverClassName(env.getProperty("spring.datasource.mongo.driver"));
//		dataSource.setUrl(env.getProperty("spring.data.mongodb.uri"));
////	        dataSource.setUsername(env.getProperty("jdbc.user"));
////	        dataSource.setPassword(env.getProperty("jdbc.pass"));
//
//		return dataSource;
//	}
//
//	@Bean
//	public PlatformTransactionManager productTransactionManager() {
//
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(productEntityManager().getObject());
//		return transactionManager;
//	}
//
//}
