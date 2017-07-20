/**
 * http://thisthread.blogspot.com/2017/07/spring-and-jdbctemplate.html
 */
package spittr.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import spittr.Spitter;

@SpringBootApplication
public class UsingJdbcApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(UsingJdbcApplication.class);

    @Autowired
    private JdbcTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(UsingJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Long counter = template.queryForObject("SELECT count(id) FROM spitter", Long.class);
        log.info("Rows on spitter table: " + counter);

        log.info("Pushing a spitter in");
        Object[] admin = new Object[] { "admin", "password", "Admin", "admin@example.dd" };
        template.update("INSERT INTO spitter(username, password, fullname, email) VALUES(?, ?, ?, ?)", admin);

        template.query("SELECT * FROM spitter WHERE username = ?", new Object[] { "admin" },
                (rs, rowNum) -> new Spitter(rs.getLong("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("fullname"), rs.getString("email"), rs.getBoolean("updateByEmail")))
                .forEach(spitter -> log.info("Spitter: " + spitter.toString()));
    }
}
