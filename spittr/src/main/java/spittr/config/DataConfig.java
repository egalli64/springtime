/**
 * http://thisthread.blogspot.com/2017/05/from-model-to-view-through-spring.html
 * http://thisthread.blogspot.com/2017/06/spitter-registration.html
 * http://thisthread.blogspot.com/2017/07/using-jdbctemplate-in-spitter-web-app.html
 */
package spittr.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import spittr.data.JdbcSpitterRepository;
import spittr.data.JdbcSpittleRepository;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;

public class DataConfig {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("schema.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcSpitterRepository(jdbcTemplate);
    }

    @Bean
    public SpittleRepository spittleRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcSpittleRepository(jdbcTemplate);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
