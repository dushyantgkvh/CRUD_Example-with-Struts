package com.witty.struts.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {

	@Bean
	public DataSource getDataSource() {

		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/empcrud");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("Dushyant@1122");

		return dataSourceBuilder.build();

	}

}
