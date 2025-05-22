package com.mycommerce.ecommerce.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration();

            // Parsing Dotenv
            Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

            // Load DB config from environment variables
            String dbUrl = dotenv.get("DB_URL");
            String dbUser = dotenv.get("DB_USERNAME");
            String dbPass = dotenv.get("DB_PASSWORD");

            if (dbUrl == null || dbUser == null || dbPass == null) {
                throw new RuntimeException("Database environment variables are not set.");
            }

            config.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            config.setProperty("hibernate.connection.url", dbUrl);
            config.setProperty("hibernate.connection.username", dbUser);
            config.setProperty("hibernate.connection.password", dbPass);
            config.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

            // Optional Hibernate settings
            config.setProperty("hibernate.hbm2ddl.auto", "update");
            config.setProperty("hibernate.show_sql", "true");

            // Register your entity classes here, e.g.:
            // config.addAnnotatedClass(YourEntity.class);

            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
