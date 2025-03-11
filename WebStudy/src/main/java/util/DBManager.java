package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public class DBManager {

    private static Connection conn;

    public static Connection getConnection() {
        try {
            HikariConfig cf = new HikariConfig();

            cf.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            cf.setUsername("scott");
            cf.setPassword("tiger");
            cf.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            //cf.setMaximumPoolSize(10);
            //cf.setConnectionTimeout(60000);  // Increase timeout to 60 seconds
            cf.setMaximumPoolSize(10);
            cf.setMinimumIdle(2);
            cf.setIdleTimeout(30000);
            cf.setMaxLifetime(1800000);
            cf.setConnectionTimeout(30000);

            HikariDataSource ds = new HikariDataSource(cf);
            conn = ds.getConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

}
