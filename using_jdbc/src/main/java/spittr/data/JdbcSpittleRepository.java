/**
 * http://thisthread.blogspot.com/2017/07/spring-and-jdbctemplate.html
 */
package spittr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import spittr.Spitter;
import spittr.Spittle;

public class JdbcSpittleRepository implements SpittleRepository {
    private static final String SELECT = "select sp.id, s.id as spitterId, s.username, s.password, s.fullname, s.email, s.updateByEmail, sp.message, sp.postedTime from Spittle sp, Spitter s where sp.spitter = s.id";
    private static final String SELECT_BY_ID = SELECT + " and sp.id=?";
    private static final String SELECT_BY_SPITTER_ID = SELECT + " and s.id=? order by sp.postedTime desc";
    private static final String SELECT_RECENT = SELECT + " order by sp.postedTime desc limit ?";
    private static final String SELECT_COUNT = "select count(id) from Spittle";
    private static final String DELETE = "delete from Spittle where id=?";

    private JdbcTemplate template;

    public JdbcSpittleRepository(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    public long count() {
        return template.queryForObject(SELECT_COUNT, Long.class);
    }

    public List<Spittle> findRecent() {
        return findRecent(10);
    }

    public List<Spittle> findRecent(int count) {
        return template.query(SELECT_RECENT, new SpittleRowMapper(), count);
    }

    public Spittle findOne(long id) {
        try {
            return template.queryForObject(SELECT_BY_ID, new SpittleRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Spittle> findBySpitterId(long spitterId) {
        return template.query(SELECT_BY_SPITTER_ID, new SpittleRowMapper(), spitterId);
    }

    public Spittle save(Spittle spittle) {
        long spittleId = insertSpittle(spittle);
        return new Spittle(spittleId, spittle.getSpitter(), spittle.getMessage(), spittle.getPostedTime());
    }

    private long insertSpittle(Spittle spittle) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template).withTableName("Spittle");
        insert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("spitter", spittle.getSpitter().getId());
        args.put("message", spittle.getMessage());
        args.put("postedTime", Timestamp.from(spittle.getPostedTime()));
        long spittleId = insert.executeAndReturnKey(args).longValue();
        return spittleId;
    }

    public void delete(long id) {
        template.update(DELETE, id);
    }

    private static final class SpittleRowMapper implements RowMapper<Spittle> {
        public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String message = rs.getString("message");
            Instant postedTime = rs.getTimestamp("postedTime").toInstant();
            long spitterId = rs.getLong("spitterId");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String fullName = rs.getString("fullname");
            String email = rs.getString("email");
            boolean updateByEmail = rs.getBoolean("updateByEmail");
            Spitter spitter = new Spitter(spitterId, username, password, fullName, email, updateByEmail);
            return new Spittle(id, spitter, message, postedTime);
        }
    }
}
