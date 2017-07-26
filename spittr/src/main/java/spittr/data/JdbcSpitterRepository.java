/**
 * http://thisthread.blogspot.com/2017/06/spitter-registration.html
 * http://thisthread.blogspot.com/2017/07/using-jdbctemplate-in-spitter-web-app.html
 */
package spittr.data;

import org.springframework.stereotype.Repository;

import spittr.Spitter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {
    private static final String SELECT = "select id, username, password, firstname, lastname, email from Spitter";
    private static final String UPDATE = "update Spitter set username=?, password=?, firstname=?, lastname=?, email=? where id=?";
    private static final String SELECT_COUNT = "select count(id) from Spitter";

    private JdbcTemplate template;

    public JdbcSpitterRepository(JdbcTemplate template) {
        this.template = template;
    }

    public long count() {
        return template.queryForObject(SELECT_COUNT, Long.class);
    }

    public Spitter save(Spitter spitter) {
        Long id = spitter.getId();
        if (id == null) {
            long spitterId = insertSpitter(spitter);
            return new Spitter(spitterId, spitter.getUsername(), spitter.getPassword(), spitter.getFirstName(),
                    spitter.getLastName(), spitter.getEmail());
        } else {
            template.update(UPDATE, spitter.getUsername(), spitter.getPassword(), spitter.getFirstName(),
                    spitter.getLastName(),
                    spitter.getEmail(), id);
            return spitter;
        }
    }

    private long insertSpitter(Spitter spitter) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template).withTableName("Spitter");
        insert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("username", spitter.getUsername());
        args.put("password", spitter.getPassword());
        args.put("firstname", spitter.getFirstName());
        args.put("lastname", spitter.getLastName());
        args.put("email", spitter.getEmail());
        return insert.executeAndReturnKey(args).longValue();
    }

    public Spitter findOne(long id) {
        return template.queryForObject(SELECT + " where id=?", new SpitterRowMapper(), id);
    }

    public Spitter findByUsername(String username) {
        return template.queryForObject(SELECT + " where username=?", new SpitterRowMapper(), username);
    }

    public List<Spitter> findAll() {
        return template.query(SELECT + " order by id", new SpitterRowMapper());
    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String firstName = rs.getString("firstname");
            String lastName = rs.getString("firstname");
            String email = rs.getString("email");
            return new Spitter(id, username, password, firstName, lastName, email);
        }
    }
}
