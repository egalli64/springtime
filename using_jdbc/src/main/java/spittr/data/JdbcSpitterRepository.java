/**
 * http://thisthread.blogspot.com/2017/07/spring-and-jdbctemplate.html
 */
package spittr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import spittr.Spitter;

public class JdbcSpitterRepository implements SpitterRepository {
    private static final String SELECT = "select id, username, password, fullname, email, updateByEmail from Spitter";
    private static final String UPDATE = "update Spitter set username=?, password=?, fullname=?, email=?, updateByEmail=? where id=?";
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
            return new Spitter(spitterId, spitter.getUsername(), spitter.getPassword(), spitter.getFullName(),
                    spitter.getEmail(), spitter.isUpdateByEmail());
        } else {
            template.update(UPDATE, spitter.getUsername(), spitter.getPassword(), spitter.getFullName(),
                    spitter.getEmail(), spitter.isUpdateByEmail(), id);
            return spitter;
        }
    }

    private long insertSpitter(Spitter spitter) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template).withTableName("Spitter");
        insert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("username", spitter.getUsername());
        args.put("password", spitter.getPassword());
        args.put("fullname", spitter.getFullName());
        args.put("email", spitter.getEmail());
        args.put("updateByEmail", spitter.isUpdateByEmail());
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
            String fullName = rs.getString("fullname");
            String email = rs.getString("email");
            boolean updateByEmail = rs.getBoolean("updateByEmail");
            return new Spitter(id, username, password, fullName, email, updateByEmail);
        }
    }
}
