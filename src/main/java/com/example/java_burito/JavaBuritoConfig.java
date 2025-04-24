package com.example.java_burito;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class JavaBuritoConfig implements Config {
	@Value("${APPDB_URL}")
	private String appdbUrl;
	
	@Value("${DB_NAME}")
	private String dbName;
	
	@Value("${APPDB_USER}")
	private String appdbUser;

	@Value("${DB_PASSWORD}")
	private String dbPassword;
	

//	@Override
//	public DataSource getDataSource() {
//		return new TransactionAwareDataSourceProxy(DataSourceBuilder.create().url(appdbUrl + dbName).username(appdbUser).password(dbPassword).build());
//	}

	@Override
	@Bean
	public DataSource getDataSource() {
		final HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setJdbcUrl(appdbUrl + dbName);
		dataSource.setUsername(appdbUser);
		dataSource.setPassword(dbPassword);
		return new TransactionAwareDataSourceProxy(dataSource);
	}
	
	@Override
	public Dialect getDialect() {
		return new PostgresDialect();
	}
}