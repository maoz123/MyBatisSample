package demo.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "demo.dao")
public class ApplicationConfig {
}
