package chenweipan.journal.config;


import chenweipan.journal.encrypt.CwpCrypt;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class DBConfig {

    @Autowired
    private Environment env;

    @Bean(name = "dataSource")
    public ComboPooledDataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(env.getProperty("db.driverClassName"));
        dataSource.setJdbcUrl("jdbc:mysql://" + CwpCrypt.cwpDecrypt(env.getProperty("db.url")) + "?useUnicode=true&amp;characterEncoding=utf-8");
        dataSource.setUser(CwpCrypt.cwpDecrypt(env.getProperty("db.username")));
        dataSource.setPassword(CwpCrypt.cwpDecrypt(env.getProperty("db.password")));
        dataSource.setMaxPoolSize(20);
        dataSource.setMinPoolSize(5);
        dataSource.setInitialPoolSize(10);
        dataSource.setMaxIdleTime(300);
        dataSource.setAcquireIncrement(5);
        dataSource.setIdleConnectionTestPeriod(60);

        return dataSource;
    }

}
