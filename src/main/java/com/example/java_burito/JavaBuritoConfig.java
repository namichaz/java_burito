package com.example.java_burito;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

public class JavaBuritoConfig implements Config {
	@Value("${APPDB_URL}")
	private String appdbUrl;
	
	String dbName = "search_burrito";
	String apppdbUser = "tatsuya";
	String dbPassword = "tatsuya1013";

	@Override
	public DataSource getDataSource() {
		return new TransactionAwareDataSourceProxy(DataSourceBuilder.create().url(appdbUrl + dbName).username(apppdbUser).password(dbPassword).build());
	}

	@Override
	public Dialect getDialect() {
		return new PostgresDialect();
	}

}
