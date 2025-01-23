package org.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3305/virtual_company");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }
@Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
}

}
