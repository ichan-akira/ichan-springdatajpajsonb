package moe.ichan.springdatajpajsonb.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"moe.ichan.springdatajpajsonb.repository"},
        entityManagerFactoryRef = "postgresqlEntityManagerFactory",
        transactionManagerRef = "postgresqlTransactionManager"
)
public class PostgresqlConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.postgresql.datasource")
    public DataSourceProperties postgresqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource postgresqlDataSource() {
        return postgresqlDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "postgresqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        var properties = Map.of(
                "hibernate.hbm2ddl.auto", "none",
                "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect",
                "hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy"
        );
        return builder
                .dataSource(postgresqlDataSource())
                .packages("moe.ichan.springdatajpajsonb.entity")
                .properties(properties)
                .build();
    }

    @Bean(name = "postgresqlTransactionManager")
    public PlatformTransactionManager postgresqlTransactionManager(
            @Qualifier("postgresqlEntityManagerFactory") EntityManagerFactory postgresqlEntityManagerFactory
    ) {
        return new JpaTransactionManager(postgresqlEntityManagerFactory);
    }
}
