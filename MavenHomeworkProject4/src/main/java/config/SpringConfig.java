package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan({"beans", "db"})
@PropertySource("classpath:app.properties")
public class SpringConfig {
	
	@Autowired
	private Environment env;

	@Bean("jt")
	public JdbcTemplate getJdbcTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(env.getProperty("db.url"), env.getProperty("db.username"), env.getProperty("db.password"));
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		return new JdbcTemplate(dataSource);
		
	}
	

}
