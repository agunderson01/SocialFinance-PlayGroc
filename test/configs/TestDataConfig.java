package configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
// import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class TestDataConfig {


    private static HashMap<String,String> h2Params = new HashMap<String,String>(20);
    static {
        h2Params.put("db.test.scan.pkg",     "models");

        h2Params.put("db.test.driver",       "org.h2.Driver");
        h2Params.put("db.test.url",          "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        h2Params.put("db.test.user",         "sa");  // This is the default
        h2Params.put("db.test.password",     "");    // This is the default
        h2Params.put("db.test.dialect",      "org.hibernate.dialect.H2Dialect");
        h2Params.put("db.test.ddl.strategy", "create-drop");
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(false);
        // vendorAdapter.setDatabase(Database.H2);  // This is the default
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPackagesToScan(getConfig("db.test.scan.pkg"));
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(getConfig("db.test.driver"));
        dataSource.setUrl(getConfig("db.test.url"));

        // Username and Password not needed.  Rely on default.
        // dataSource.setUsername(getConfig("db.test.user"));
        // dataSource.setPassword(getConfig("db.test.pass"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

    private static String getConfig(String key) {
        /*
        * Don't mix Play and Spring.  Play has a Spring Context and Spring has a context and the twain shall
        * not meet unless you specifically architect using multiple Spring contexts.  So replace this use
        * of Play.application().configuration().getString(key)
        *       return Play.application().configuration().getString(key);
        */
        return h2Params.get(key);
    }
}