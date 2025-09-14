package config.java;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.TestPropertySource;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;

/**
 * Configuración específica para tests.
 * Esta clase proporciona configuraciones personalizadas para el entorno de pruebas.
 */
@TestConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class TestConfig {

    /**
     * Configura un DataSource específico para tests usando H2 en memoria.
     * @return DataSource configurado para tests.
     */
    @Bean
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder
                .create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
                .username("sa")
                .password("")
                .build();
    }
}
