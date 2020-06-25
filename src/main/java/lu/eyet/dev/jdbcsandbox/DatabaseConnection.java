package lu.eyet.dev.jdbcsandbox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.querydsl.sql.PostgreSQLTemplates;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.SQLTemplates;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection {

    private static String JDBC_URL;

    private static String DB_USER;

    private static String DB_PASS;

    @Value("${spring.datasource.url}")
    public void setJDBCURL(String db) {
        JDBC_URL = db;
    }

    @Value("${spring.datasource.username}")
    public void setDBUser(String user) {
        DB_USER = user;
    }

    @Value("${spring.datasource.password}")
    public void setDBPassword(String password) {
        DB_PASS = password;
    }

    public SQLQuery<?> pgQuery() {
        SQLQuery<?> query = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            SQLTemplates dialect = new PostgreSQLTemplates();
            query = new SQLQuery<Void>(conn, dialect);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return query;
    }

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

}